package com.gzq.yiyuan.result;

import lombok.Data;

import java.io.Serializable;
import java.net.URL;

@Data
public class AjaxResult<T> implements Serializable {
    private static final int code_SUCCESS = 1;
    private static final int code_FAILED = 0;
   private int code;
   private T data;
   private String message;
   private String url;
   private String debug;



    public AjaxResult(int code) {
        this.code = code;
    }

    public AjaxResult(int code, T data, String message,String url, String debug) {
        this.code = code;
        this.data = data;
        this.message = message;
        this.url=url;
        this.debug = debug;
    }

    public AjaxResult(int code, T data, String message,String url) {
        this(code, data, message,url,null);
    }

    public static AjaxResult<?> success() {
        return new AjaxResult<>(code_SUCCESS);
    }

    public static <T> AjaxResult<T> success(String data,String url) {
        return new AjaxResult(code_SUCCESS, data, null,url);
    }

    public static <T> AjaxResult<T> success(T data) {
        return new AjaxResult<>(code_SUCCESS, data, null,null);
    }
    public static <T> AjaxResult<T> success(T data,String url,String message) {
        return new AjaxResult<>(code_SUCCESS, data, null,url);
    }
    public static <T> AjaxResult<T> success(T data, String message) {
        return new AjaxResult<>(code_SUCCESS, data, message,null);
    }

    public static AjaxResult<?> failed() {
        return new AjaxResult<>(code_FAILED);
    }

    public static <T> AjaxResult<T> failed(String message) {
        return new AjaxResult(code_FAILED, null, message,null);
    }

    public static <T> AjaxResult<T> failed(String message, String debug) {
        return new AjaxResult<>(code_FAILED, null, message, debug);
    }

    public static AjaxResult<?> failed(int code, String message) {

        return new AjaxResult<>(code, null, message,null);
    }


}
