package com.stockholm.main_project.auth.handler;

import com.google.gson.Gson;
import com.stockholm.main_project.auth.erroesponse.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 인증 성공 핸들러 클래스입니다.
 * 인증에 성공한 경우 로깅을 수행합니다.
 */
@Slf4j
public class MemberAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    /**
     * 인증 성공 시 호출되는 메서드입니다.
     * 성공한 경우 로깅을 수행합니다.
     *
     * @param request        HTTP 요청 객체
     * @param response       HTTP 응답 객체
     * @param authentication 인증 객체
     * @throws IOException      IO 예외 발생 시
     * @throws ServletException 서블릿 예외 발생 시
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        // 로그에 인증 성공 메시지를 기록합니다.
        log.info("# Authenticated successfully!");
    }
}
