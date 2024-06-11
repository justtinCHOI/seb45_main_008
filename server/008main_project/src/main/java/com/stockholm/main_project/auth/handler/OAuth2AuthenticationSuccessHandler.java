package com.stockholm.main_project.auth.handler;

import com.stockholm.main_project.auth.jwt.JwtTokenizer;
import com.stockholm.main_project.auth.utils.CustomAuthorityUtils;
import com.stockholm.main_project.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class OAuth2AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final JwtTokenizer jwtTokenizer;
    private final CustomAuthorityUtils authorityUtils;
    private final MemberService memberService;

    @Autowired
    public OAuth2AuthenticationSuccessHandler(JwtTokenizer jwtTokenizer, CustomAuthorityUtils authorityUtils, MemberService memberService) {
        this.jwtTokenizer = jwtTokenizer;
        this.authorityUtils = authorityUtils;
        this.memberService = memberService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        var oAuth2User = (OAuth2User) authentication.getPrincipal();

        // OAuth2User로부터 이메일 정보 획득
        String email = String.valueOf(oAuth2User.getAttributes().get("email"));

        // 이메일을 기반으로 권한 생성
        List<String> authorities = authorityUtils.createRoles(email);

        // 액세스 토큰 및 리프레시 토큰 생성
        String accessToken = delegateAccessToken(email, authorities);
        String refreshToken = delegateRefreshToken(email);

        // 헤더에 토큰 추가
        response.addHeader("Authorization", "Bearer " + accessToken);
        response.addHeader("Refresh-Token", refreshToken);

        // 리다이렉트 진행
        redirect(request, response, email, authorities);
    }

    private void redirect(HttpServletRequest request, HttpServletResponse response, String username, List<String> authorities) throws IOException {
        // 액세스 토큰 및 리프레시 토큰 생성
        String accessToken = delegateAccessToken(username, authorities);
        String refreshToken = delegateRefreshToken(username);

        // URI 생성
        String uri = createURI(accessToken, refreshToken).toString();
        // 리다이렉트 진행
        getRedirectStrategy().sendRedirect(request, response, uri);
    }

    // 액세스 토큰 생성
    private String delegateAccessToken(String username, List<String> authorities) {
        // 사용자의 이메일로 Member ID를 가져옴
        int memberId = memberService.findMemberIdByEmail(username);

        // 클레임 설정
        Map<String, Object> claims = new HashMap<>();
        claims.put("email", username);
        claims.put("roles", authorities);
        claims.put("memberId", memberId); // Member ID를 클레임에 추가

        // 토큰 만료 시간 설정
        String subject = username;
        Date expiration = jwtTokenizer.getTokenExpiration(jwtTokenizer.getAccessTokenExpirationMinutes());

        // Secret Key 인코딩
        String base64EncodedSecretKey = jwtTokenizer.encodeBase64SecretKey(jwtTokenizer.getSecretKey());

        // 액세스 토큰 생성
        String accessToken = jwtTokenizer.generateAccessToken(claims, subject, expiration, base64EncodedSecretKey);

        return accessToken;
    }

    // 리프레시 토큰 생성
    private String delegateRefreshToken(String username) {
        // 토큰 subject 설정
        String subject = username;
        // 토큰 만료 시간 설정
        Date expiration = jwtTokenizer.getTokenExpiration(jwtTokenizer.getRefreshTokenExpirationMinutes());
        // Secret Key 인코딩
        String base64EncodedSecretKey = jwtTokenizer.encodeBase64SecretKey(jwtTokenizer.getSecretKey());
        // 리프레시 토큰 생성
        String refreshToken = jwtTokenizer.generateRefreshToken(subject, expiration, base64EncodedSecretKey);

        return refreshToken;
    }

    // 리다이렉트할 URI 생성
    private URI createURI(String accessToken, String refreshToken) {
        // 쿼리 파라미터 설정
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add("access_token", accessToken);
        queryParams.add("refresh_token", refreshToken);
        //        return UriComponentsBuilder
//                .newInstance()
//                .scheme("http")
//                .host("localhost")
//                .port(8080)
//                .queryParams(queryParams)
//                .path("/receive-token.html")
//                .build()
//                .toUri();
//    }

        // URI 생성
        return UriComponentsBuilder
                .newInstance()
                .scheme("http")
                .host("seb008stockholm.s3-website.ap-northeast-2.amazonaws.com")
                .queryParams(queryParams)
                .path("/")
                .build()
                .toUri();
    }
}
