package com.tim.common.designPatter.proxy.headfirst;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 最简单的远程接口
 * Created by tim.syh on 2016/7/9.
 */
public interface MyRemote extends Remote {

    /** 注意返回类型和参数类型都必须是基本类型或者实现了Serializable类型 */
    public String sayHello(String name) throws RemoteException;
}
