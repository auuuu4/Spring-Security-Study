package com.m2on.securitydemo.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * @Author: HuLiang
 * @Date: 2024/07/17/22:43
 * @Description:
 */
@Data
public class HttpResult <T> {
    int code;
    String message;
    T data = null;

    public HttpResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public HttpResult(int code, String message) {
        this.code = code;
        this.message = message;
        this.data = null;
    }


    public static HttpResult success(){
        return new HttpResult(200,"操作成功");
    }
    public static HttpResult fail(){
        return new HttpResult(200,"操作失败");
    }
    public static <T>HttpResult success(String message,T data){
        return new HttpResult(200,message,data);
    }
    public static HttpResult success(String message){
        return new HttpResult(200,message);
    }
    public static HttpResult fail(String message){
        return new HttpResult(200,message);
    }
    public static HttpResult fail(int code,String message){
        return new HttpResult(code,message);
    }
}
