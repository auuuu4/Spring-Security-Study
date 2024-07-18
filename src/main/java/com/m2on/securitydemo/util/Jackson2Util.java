package com.m2on.securitydemo.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created with IntelliJ IDEA.
 * @Author: HuLiang
 * @Date: 2024/07/17/22:33
 * @Description:
 */
public class Jackson2Util {
    private final static ObjectMapper objectMapper = new ObjectMapper();

    public static String parseJSONString(Object o) throws JsonProcessingException {
        return objectMapper.writeValueAsString(o);
    }

    public static <T> T  parseObject(String jsonStr,Class<T> clazz) throws JsonProcessingException {
        return objectMapper.readValue(jsonStr,clazz);
    }
}
