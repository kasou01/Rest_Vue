package com.example.demo.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
/**
 * Spring Security�̔F�؎��s���ɌĂ΂��n���h���N���X
 */
public class SampleAuthenticationFailureHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		String errorId = "";
        // Exception����G���[ID���Z�b�g����
        if(exception instanceof BadCredentialsException){
            errorId = "401";
        }

        // ���O�C����ʂɃ��_�C���N�g����
        response.sendRedirect(request.getContextPath() + "/"
                + request.getParameter("identifier") + "/login?error=" + errorId);
	}

}
