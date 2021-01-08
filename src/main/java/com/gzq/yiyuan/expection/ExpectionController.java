package com.gzq.yiyuan.expection;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gzq.yiyuan.result.AjaxResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.MultipartProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.MediaType;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.util.Set;

@ControllerAdvice
public class ExpectionController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExpectionController.class);

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private MultipartProperties properties;

    @ExceptionHandler({BaseException.class})
    @ResponseBody
    public AjaxResult<?> handleBaseException(BaseException e) {
        return AjaxResult.failed(e.getCode(), messageSource.getMessage(e.getMessage(), null, e.getMessage(), LocaleContextHolder.getLocale()));
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseBody
    public AjaxResult<?> validationException(MethodArgumentNotValidException exception) {
        return AjaxResult.failed(exception.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }

    @ExceptionHandler({MultipartException.class})
    public void handleMultipartException(MultipartException e, HttpServletResponse response) throws IOException {
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.getWriter().write(mapper.writeValueAsString(AjaxResult.failed(String.format("上传文件超限!单个文件最大%s 单次请求最大%s", properties.getMaxFileSize(), properties.getMaxRequestSize()), e.getMessage())));
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public AjaxResult<?> handleRequestMethodException(HttpRequestMethodNotSupportedException exception) {
        return AjaxResult.failed(String.format("该接口不支持%s请求！", exception.getMethod()));
    }

    @ExceptionHandler({ConstraintViolationException.class})
    @ResponseBody
    public AjaxResult<?> handleConstraintViolationException(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        for (ConstraintViolation<?> item : violations) {
            return AjaxResult.failed(item.getMessage());
        }
        return AjaxResult.failed(e.getMessage());
    }

    @ExceptionHandler({Exception.class})
    @ResponseBody
    public AjaxResult<?> handleException(Exception e) {
        if (e instanceof BaseException) {
            return handleBaseException((BaseException) e);
        }
        LOGGER.error("系统异常!", e);
        return AjaxResult.failed("系统异常!", e.getMessage());
    }
}
