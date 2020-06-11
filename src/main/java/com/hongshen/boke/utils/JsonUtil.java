package com.hongshen.boke.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class JsonUtil {

    private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);
    private static ObjectMapper objectMapper;
    private JsonUtil() {
    }

    /**
     * json数据转对象
     */
    public static <T> T parseJson(String jsonData, Class<T> type) {
        return new Gson().fromJson(jsonData, type);
    }

    /**
     * json数组转对象
     */
    public static <T> List<T> parseJsonList(String jsonData, Class<T> type) {
        return new Gson().fromJson(jsonData, new TypeToken<List<T>>() {
        }.getType());
    }

    /**
     * 对象转json数据
     */
    public static String toJson(Object objData) {
        return new Gson().toJson(objData);
    }


    public static <T> String tToString(T t) {
        if (null == t) {
            return null;
        }
        try {
            return getMapper().writeValueAsString(t);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ObjectMapper getMapper() {
        if (null == objectMapper) {
            objectMapper = new ObjectMapper().setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            objectMapper.configure(MapperFeature.ALLOW_EXPLICIT_PROPERTY_RENAMING, false);
        }
        return objectMapper;
    }


    /**
     * bean to JSONObject
     * @param bean
     * @return
     */
    public static <T> JSONObject beanToJsonObject(T bean){
        if(bean == null) return null;
        String json = JSON.toJSONString(bean);
        return JSON.parseObject(json);
    }
}
