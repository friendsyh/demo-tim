package com.tim.common.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

/**
 * JSON序列化与反序列化工具。功能不全，对于userName,user_name,isAllow格式的属性名都能够正确转化，但是is_allow不能正常转化.
 * 多了一个JsonNode的概念。相当于jsonString和Pojo的一个中间类。
 * 分为以下几种情况
 * 1.任何对象转json字符串，都是使用objectToString()或者toJsonStr()方法都可以
 * 2.字符串转普通对象stringToObject(jsonStr,Student.class)
 * 3.字符串转List对象stringToObject(jsonStr,new TypeReference<List<Student>>(){})
 * 4.字符串转Map对象 和第二种是一样的
 *
 * @author tim.syh
 * @since 2016-10-30确定
 */
public class JacksonUtils {
    private static ObjectMapper objectMapper;
    private static JsonFactory jsonFactory;

    static {
        objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        jsonFactory = new JsonFactory(objectMapper);
    }

    public static JsonFactory getFactory() {
        return jsonFactory;
    }

    public static String objectToString(final Object obj) throws JsonProcessingException {
        String content = objectMapper.writeValueAsString(obj);
        return content;
    }

    public static JsonNode stringToObject(final String input) throws IOException {
        JsonNode rtn = objectMapper.readTree(input);
        return rtn;
    }

    public static <T> T stringToObject(final String input, Class<T> clazz) throws IOException {
        T result = objectMapper.readValue(input, clazz);
        return result;
    }

    public static <T> T stringToObject(final String input, TypeReference<T> type) throws IOException {
        T result = objectMapper.readValue(input, type);
        return result;
    }

    public static Map<String, Object> jsonNodeToMap(final JsonNode node) {
        Map<String, Object> result = objectMapper.convertValue(node, Map.class);
        return result;
    }

    public static JsonNode valueToJsonNode(Map<String, Object> map) {
        return objectMapper.valueToTree(map);
    }

    public static String mapToString(final Map<String, Object> input) throws JsonProcessingException {
        String jsonResp = objectMapper.writeValueAsString(input);
        return jsonResp;
    }
}