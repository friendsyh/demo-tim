package com.tim.common.designPatter.proxy.jdk;

/**
 * 一个人。为什么要实现接口不直接定义类，因为代理和实际服务类要实现相同的接口，所以是模拟。
 * 用户自己能偶修改自己的name，但是自己不能修改自己的rate
 * 别的用户不能修改别人的name，但是能够给别人打分
 * Created by tim.syh on 2016/7/9.
 */
public class PersonImpl implements IPerson{

    private String name;

    private int rate;

    public PersonImpl(String name, int rate){
        this.name = name;
        this.rate = rate;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getRate() {
        return rate;
    }

    @Override
    public void setRate(int rate) {
        this.rate = rate;
    }

    public void showPerosn(){
        System.out.println("person[name=" + name + ",rate=" + rate + "]");
    }
}
