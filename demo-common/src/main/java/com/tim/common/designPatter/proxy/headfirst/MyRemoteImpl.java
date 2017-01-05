package com.tim.common.designPatter.proxy.headfirst;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by tim.syh on 2016/7/9.
 */
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {

    public MyRemoteImpl() throws RemoteException {};

    @Override
    public String sayHello(String name) throws RemoteException {
        return "Hello,this is " + name;
    }

    public static void main(String[] args) {
        try {
            MyRemote service = new MyRemoteImpl();
            //本地主机上的远程对象注册表Registry的实例，并指定端口为8888，这一步必不可少（Java默认端口是1099），
            // 必不可缺的一步，缺少注册表创建，则无法绑定对象到远程注册表上。在书中少了这一步所以跑步起来
            LocateRegistry.createRegistry(8888);
            Naming.rebind("rmi://127.0.0.1:8888/RemoteHello", service);
            System.out.println("Remote Service start-----------------------");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

}
