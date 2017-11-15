package com.tim.common.designpatter.proxy.jdk;

/**
 * 对人的一些基本操作，比如修改姓名，修改评分之类的
 * Created by tim.syh on 2016/7/9.
 */
public interface IPerson {

    public String getName();
    public void setName(String name);

    public int getRate();
    public void setRate(int rate);

    public void showPerosn();
}
