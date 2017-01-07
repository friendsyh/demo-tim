package com.tim.common.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.Map;

/**
 * JSON序列化与反序列化工具。功能很强大，对于userName,user_name,is_allow,isAllow格式的属性名都能够正确转化。
 * 可以设置时间格式，字段为空是否要输出等等配置，都是在初始化的时候进行配置。 分为以下几种情况
 * 1.任何对象转json字符串，都是使用objectToString()或者toJsonStr()方法都可以
 * 2.字符串转普通对象stringToObject(jsonStr,Student.class); 或者stringToObject(jsonStr,new TypeToken<Student>(){})
 * 3.字符串转List对象stringToObject(jsonStr,new TypeToken<List<Student>>(){})
 * 4.字符串转Map对象stringToObject(jsonStr,Map.class) | stringToObject(jsonStr,new TypeToken<Map>(){})会转成TreeMap，stringToMap(jsonStr,Map.class)会转成HashMap
 *
 * @author tim.syh
 * @since 2016-10-30确定
 */
public class GsonUtils {

    private static Gson gson;

    /**
     * 时间格式
     */
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    static {
        if (gson == null) {
            //可以定义很多根式，比如日期格式，比如为空是否要序列化。
            gson = new GsonBuilder().setDateFormat(DATE_FORMAT).create();
        }
    }

    //外面不可以实例化，让自己实例化就行了。
    private GsonUtils() {
    }

    /**
     * 对象序列化成JSON串
     *
     * @param t: 需要序列化的泛型对象。
     * @return String: 序列化后的JSON串
     */
    public static <T> String objectToString(T t) throws Exception {
        return gson.toJson(t);
    }

    /**
     * 对象序列化成JSON串
     *
     * @param obj: 需要序列化的对象
     * @return String: 序列化后的JSON串
     */
    public static String toJson(Object obj) throws Exception {
        return gson.toJson(obj);
    }

    /**
     * JSON串反序列化成对。Obj里面有Obj类型也是可以发序列化成功的。@常用
     *
     * @param json: 需要反序列化的JSON字符串
     * @param cls:  反序列化的对象class类型
     * @return <T> T: 反序列化的泛型对象
     */
    public static <T> T stringToObject(String json, Class<T> cls) throws Exception {
        return gson.fromJson(json, cls);
    }

    /**
     * JSON串反序列化成对象,@不常用
     * 对象需按JSON字符串的格式定义属性
     *
     * @param json: 需要反序列化的JSON字符串
     * @param type: new TypeToken<T>(){}
     * @return <T> T: 反序列化的泛型对象
     */
    public static <T> T stringToObject(String json, TypeToken<T> type) throws Exception {
        return gson.fromJson(json, type.getType());
    }

    /**
     * JSON串反序列化成MAP。经过测试，Map里面有key的值为Map的情况也是能够转化成功的。Map里面有key的值为POJO也能转化，但是把POJO反序列化成Map了。
     *
     * @param json: 需要反序列化的JSON字符串
     * @return <K, V> Map<K, V>: 反序列化的泛型对象MAP
     */
    public static <K, V> Map<K, V> stringToMap(String json) throws Exception {
        return gson.fromJson(json, new TypeToken<Map<K, V>>() {}.getType());
    }
}
