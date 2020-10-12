package com.tim.common.designpatter.strategyFactoryTemplate;

import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by friendsyh on 2020/10/12.
 * 工厂模式工厂类。一般工厂需要实现两个方法一个是自己的getInstance()方法，一个是从工厂里面获取需要的对象方法。
 */
public class PriceHandleFactory {

    private static Logger logger = LoggerFactory.getLogger(PriceHandleFactory.class);

    //单例模式。这种恶汉单例模式也是线程安全的，最简单的一些写法，但是没有达到延迟加载的目的。要达到延迟加载的目的，就使用双重检测锁。
    private static final PriceHandleFactory priceHandleFactory = new PriceHandleFactory();

    //这个是容器，在初始化的时候把所有的实现都加载在容器里面
    private Map<String, PriceHandle> priceHandleMap = new HashMap<>();

    private PriceHandleFactory() {
        Reflections reflections = new Reflections("com.tim.common.designpatter.strategyFactoryTemplate.impl");
        Set<Class<?>> classSet = reflections.getTypesAnnotatedWith(MemberType.class);
        for(Class classOne : classSet) {
            MemberType memberType = (MemberType)classOne.getAnnotation(MemberType.class);
            PriceHandle priceHandle = null;
            try {
                priceHandle = (PriceHandle)classOne.newInstance();
            } catch (Exception e) {
                logger.error("get object from clazz exception", e);
            }

            priceHandleMap.put(memberType.memberType(), priceHandle);
        }
    }

    public PriceHandle getPriceHandle(String memberType) {
        PriceHandle priceHandle =  priceHandleMap.get(memberType);
        if(null == priceHandle) {
            throw new RuntimeException("error memberType input");
        }

        return priceHandle;
    }

    public static PriceHandleFactory getInstance() {
        return priceHandleFactory;
    }
}
