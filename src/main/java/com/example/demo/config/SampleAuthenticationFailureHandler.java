package com.example.demo.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
/**
 * Spring Securityの認証失敗時に呼ばれるハンドラクラス
 */
public class SampleAuthenticationFailureHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		String errorId = "";
        // ExceptionからエラーIDをセットする
        if(exception instanceof BadCredentialsException){
            errorId = "401";
        }

        // ログイン画面にリダイレクトする
        response.sendRedirect(request.getContextPath() + "/"
                + request.getParameter("identifier") + "/login?error=" + errorId);
	}

}
