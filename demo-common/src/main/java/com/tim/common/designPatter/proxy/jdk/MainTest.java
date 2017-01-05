package com.tim.common.designPatter.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * Created by tim.syh on 2016/7/9.
 */
public class MainTest {
    public static void main(String[] args) {
        MainTest test = new MainTest();

        IPerson person = new PersonImpl("tim", 100);
        person.showPerosn();
        IPerson personOwnerProxy = test.getOwnerPoxy(person);
        //只能修改名字，不能修改评分。
        try {
            personOwnerProxy.setName("suyanghua");
            personOwnerProxy.setRate(75);
        } catch (Exception e){
            e.printStackTrace();
        }
        person.showPerosn();
    }

    /**
     * 返回代理类，传入实际服务类和返回的代理类都实现了相同的接口，所以可以同时作为参数和返回值
     * 创建代理类，JDK帮我们做了，我们调用Proxy的方法就行了，需要传入类加载器，接口，和要实际处理业务的类
     * @param person
     * @return
     */
    private IPerson getOwnerPoxy(IPerson person){
        return (IPerson) Proxy.newProxyInstance(
                person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                new OwnerInvocationHandler(person)
        );
    }
}
