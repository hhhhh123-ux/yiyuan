package com.gzq.yiyuan.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gzq.yiyuan.result.AjaxResult;
import com.sun.xml.internal.ws.client.sei.ResponseBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * @author SongYC
 */
@Slf4j
@Component
public class AccessFailureHandler implements AccessDeniedHandler {

    @Resource
    private ObjectMapper objectMapper;

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setContentType("application/json;charset=UTF-8");
        AjaxResult webResponse = AjaxResult.failed("会话失效！请重新登录！");
        response.getWriter().write(objectMapper.writeValueAsString(webResponse));
    }
}
