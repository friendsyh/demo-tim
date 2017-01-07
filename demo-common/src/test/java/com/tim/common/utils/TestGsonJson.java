package com.tim.common.utils;

import com.google.gson.reflect.TypeToken;

import com.tim.common.utils.GsonUtils;
import com.tim.common.domain.CategoryNotStdDO;
import com.tim.common.domain.test.FeatureDO;
import com.tim.common.domain.test.FeatureListDO;
import com.tim.common.domain.test.FeatureResultDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TestGsonJson {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {

        //如果传对的对象为空，那么返回的字符串也是空串喽
        System.out.println(GsonUtils.objectToString(null));
        System.out.println(GsonUtils.stringToObject(null,Map.class));

        Map<String, Object> bizWrapByS = new HashMap<String, Object>();
        bizWrapByS.put("item",new Object());
        System.out.println(GsonUtils.objectToString(bizWrapByS));

        //测试下划线格式的POJO转json的逻辑.普通对象
        FeatureDO f1 = new FeatureDO("tim", true, true, "tim");
        FeatureDO f2 = new FeatureDO("lily", false, true, "tim");
        FeatureDO f3 = new FeatureDO();
        List<FeatureDO> fs = new ArrayList<FeatureDO>();
        fs.add(f2);
        fs.add(f3);
        FeatureListDO featureListDO = new FeatureListDO();
        FeatureResultDO featureResulttDO = new FeatureResultDO(featureListDO);
        CategoryNotStdDO c1 = new CategoryNotStdDO(100, false, "衣服", f1, fs, featureResulttDO);

        String result1 = GsonUtils.toJson(c1);
        System.out.println(result1);
        CategoryNotStdDO object11 = GsonUtils.stringToObject(result1, CategoryNotStdDO.class);
        CategoryNotStdDO object12 = GsonUtils.stringToObject(result1, new TypeToken<CategoryNotStdDO>() {
        });

        //list也使用toObj，不使用toList方法，还是有问题的。因为找不到List里面的T类型，因此把List里面的对象转为TreeMap类型了。
        String result = GsonUtils.objectToString(fs);
        System.out.println(result);
//		Object object = GsonUtils.stringToObject(result, List.class);  //因为找不到List里面的T类型，因此把List里面的对象转为TreeMap类型了。
//		Object object = GsonUtils.stringToObject(result, new TypeToken<List<FeatureDO>>(){});

        Map<String, Object> map = new TreeMap<String, Object>();
        map.put("test_test1", 5);
        map.put("test_test2", f1);
        String result2 = GsonUtils.objectToString(map);
        System.out.println(result2);
        Map<Object, Object> object2 = GsonUtils.stringToObject(result2, Map.class);
        Map<Object, Object> object3 = GsonUtils.stringToMap(result2);

    }

}
