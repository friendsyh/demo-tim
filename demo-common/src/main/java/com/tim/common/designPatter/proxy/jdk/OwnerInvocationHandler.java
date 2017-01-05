package com.tim.common.designPatter.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 这个类是代理要做的事情，封装在这个里面
 * 自己处理自己的过滤，就是不能修改自己的评分(rate)
 * Created by tim.syh on 2016/7/9.
 */
public class OwnerInvocationHandler implements InvocationHandler{

    private IPerson iperson;

    public OwnerInvocationHandler(IPerson iperson){
        this.iperson = iperson;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Exception {
        if(method.getName().startsWith("get")){
            return method.invoke(iperson, args);
        } else if(method.getName().equals("setRate")){
//            return method.invoke(iperson, args);
            throw new Exception("You can not change the rate by yourself!");
        } else if(method.getName().startsWith("set")){
            return method.invoke(iperson, args);
        }
        return null;
    }
}
