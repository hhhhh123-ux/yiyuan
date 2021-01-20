package com.gzq.yiyuan.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.gzq.yiyuan.result.AjaxResult;
import com.sun.xml.internal.ws.client.sei.ResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.security.auth.message.AuthException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    @Resource
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        logger.info("登录失败");
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setContentType("application/json;charset=UTF-8");
        if (exception instanceof AuthenticationException) {
            response.getWriter().write(objectMapper.writeValueAsString(((AuthenticationException) exception)));
        } else {
            AjaxResult webResponse = AjaxResult.failed("登录信息失效：" + exception.getMessage());
            response.getWriter().write(objectMapper.writeValueAsString(webResponse));
        }
        exception.printStackTrace();
    }
}
