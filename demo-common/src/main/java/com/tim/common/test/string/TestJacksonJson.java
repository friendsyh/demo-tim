package com.tim.common.test.string;

import com.fasterxml.jackson.databind.JsonNode;

import com.tim.common.util.JacksonUtil;

import com.tim.common.domain.CategoryNotStdDO;
import com.tim.common.domain.test.FeatureDO;
import com.tim.common.domain.test.FeatureResultDO;

import java.util.*;

public class TestJacksonJson {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {

        String key = "com/tim/common/test";
        String jsonNodeStr = "\"apiKey\":\"" + key + "\"";
        JsonNode jsonNode111 = JacksonUtil.stringToObject(jsonNodeStr);

        //如果传对的对象为空，那么返回的字符串也是空串喽
        System.out.println(JacksonUtil.objectToString(null));

        //测试下划线格式的POJO转json的逻辑.普通对象
        FeatureDO f1 = new FeatureDO("tim", true, true, "tim");
        FeatureDO f2 = new FeatureDO("lily", false, true, "tim");
        FeatureDO f3 = new FeatureDO();
        List<FeatureDO> fs = new ArrayList<FeatureDO>();
        fs.add(f2);
        fs.add(f3);
        FeatureResultDO featureResulttDO = new FeatureResultDO();
        CategoryNotStdDO c1 = new CategoryNotStdDO(100, false, "衣服", f1, fs, featureResulttDO);

        String result1 = JacksonUtil.objectToString(c1);
        System.out.println(result1);
        CategoryNotStdDO object11 = JacksonUtil.stringToObject(result1, CategoryNotStdDO.class);
        //多了一个jsonNode的概念.
        JsonNode jsonNode = JacksonUtil.stringToObject(result1);

        //list也使用toObj，不使用toList方法，还是有问题的。因为找不到List里面的T类型，因此把List里面的对象转为TreeMap类型了。
        String result = JacksonUtil.objectToString(fs);
        System.out.println(result);
//		Object object = JacksonUtil.stringToObject(result, List.class);  //因为找不到List里面的T类型，因此把List里面的对象转为TreeMap类型了。
//		Object object = JacksonUtil.stringToObject(result, new TypeToken<List<FeatureDO>>(){});

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("test_test1", 5);
        map.put("test_test2", f1);
        String result2 = JacksonUtil.objectToString(map);
        System.out.println(result2);
        Map<Object, Object> object2 = JacksonUtil.stringToObject(result2, Map.class);

    }

}
