package com.tim.common.utils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.reflect.TypeToken;

import com.tim.common.domain.CategoryNotStdDO;
import com.tim.common.domain.test.FeatureDO;
import com.tim.common.domain.test.FeatureListDO;
import com.tim.common.domain.test.FeatureResultDO;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * 非标准属性的json序列化和反序列化测试
 * Created by tim.syh on 2017/1/7.
 */
public class GsonUtilsNotStdTest {

    /** 不规则的pojo对象测试 */
    private CategoryNotStdDO categoryNotStdDO;

    private List<FeatureDO> featureDOList = Lists.newArrayList();

    private Map<String, Object> map = Maps.newHashMap();

    @Before
    public void init(){
        //测试下划线格式的POJO转json的逻辑.普通对象
        FeatureDO f1 = new FeatureDO("tim", true, true, "tim");
        FeatureDO f2 = new FeatureDO("lily", false, true, "tim");
        FeatureDO f3 = new FeatureDO();
        FeatureDO f4 = null;
        featureDOList.add(f1);
        featureDOList.add(f2);
        featureDOList.add(f3);
        featureDOList.add(f4);
        FeatureListDO featureListDO = new FeatureListDO();
        FeatureResultDO featureResulttDO = new FeatureResultDO(featureListDO);
        categoryNotStdDO = new CategoryNotStdDO(100, false, "衣服", f1, featureDOList, featureResulttDO);

        map.put("test_test1", 5);
        map.put("test_test2", f1);
    }

    @Test
    public void objectToString() throws Exception {
        System.out.println(GsonUtils.toJson(categoryNotStdDO));
        System.out.println(GsonUtils.toJson(featureDOList));
        System.out.println(GsonUtils.objectToString(map));
    }

    @Test
    public void stringToObject() throws Exception {
        String objStr = GsonUtils.objectToString(categoryNotStdDO);
        System.out.println(objStr);
        CategoryNotStdDO object11 = GsonUtils.stringToObject(objStr, CategoryNotStdDO.class);
        CategoryNotStdDO object12 = GsonUtils.stringToObject(objStr, new TypeToken<CategoryNotStdDO>() {});
        System.out.println(object11);
        System.out.println(object12);

        String listStr = GsonUtils.objectToString(featureDOList);
        System.out.println(listStr);
        List<FeatureDO> object21 = GsonUtils.stringToObject(listStr, List.class);  //因为找不到List里面的T类型，因此把List里面的对象转为TreeMap类型了。
		List<FeatureDO> object22 = GsonUtils.stringToObject(listStr, new TypeToken<List<FeatureDO>>(){}); //正确的做法
        System.out.println(object21.size());
        System.out.println(object22.size());
    }

    @Test
    public void stringToMap() throws Exception {
        String mapStr = GsonUtils.objectToString(map);
        System.out.println(mapStr);
        Map<String, Object> object31 = GsonUtils.stringToObject(mapStr, Map.class);
        Map<String, Object> object32 = GsonUtils.stringToMap(mapStr);
    }

}