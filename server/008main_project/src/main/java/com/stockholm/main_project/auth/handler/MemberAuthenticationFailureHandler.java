package com.stockholm.main_project.auth.handler;

import com.google.gson.Gson;
import com.stockholm.main_project.auth.erroesponse.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 인증 실패 핸들러 클래스입니다.
 * 인증에 실패한 경우 클라이언트에게 적절한 오류 응답을 제공합니다.
 */
@Slf4j
public class MemberAuthenticationFailureHandler implements AuthenticationFailureHandler {

    /**
     * 인증 실패 시 호출되는 메서드입니다.
     * 클라이언트에게 오류 응답을 보냅니다.
     *
     * @param request    HTTP 요청 객체
     * @param response   HTTP 응답 객체
     * @param exception  발생한 인증 예외
     * @throws IOException      IO 예외 발생 시
     * @throws ServletException 서블릿 예외 발생 시
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        // 로그에 인증 실패 메시지를 기록합니다.
        log.error("# Authentication failed: {}", exception.getMessage());

        // 클라이언트에게 오류 응답을 보냅니다.
        sendErrorResponse(response);
    }

    /**
     * 클라이언트에게 오류 응답을 보내는 메서드입니다.
     *
     * @param response HTTP 응답 객체
     * @throws IOException IO 예외 발생 시
     */
    private void sendErrorResponse(HttpServletResponse response) throws IOException {
        // Gson 객체를 생성합니다.
        Gson gson = new Gson();
        
        // 오류 응답 객체를 생성합니다.
        ErrorResponse errorResponse = ErrorResponse.of(HttpStatus.UNAUTHORIZED);
        
        // 응답 헤더와 내용을 설정합니다.
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.getWriter().write(gson.toJson(errorResponse, ErrorResponse.class));
    }
}
