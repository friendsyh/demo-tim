package com.tim.common.designpatter.proxy.headfirst;

import java.rmi.Naming;

/**
 * Created by tim.syh on 2016/7/9.
 */
public class MyRemoteClient {
    public static void main(String[] args) {
        new MyRemoteClient().excute();
    }

    private void excute(){
        try {
            System.out.println("MyRemoteClient start");
            MyRemote servcie = (MyRemote) Naming.lookup("rmi://127.0.0.1:8888/RemoteHello");
            String result = servcie.sayHello("tim");
            System.out.println(result);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
