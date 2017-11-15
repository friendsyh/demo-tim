package com.tim.common.practice.djhmianshi;

public class Sub extends Super {

    /**
     * 因为父类没有无参数的构造方法，因此子类必须要调用父类的构造函数，要不父类的参数怎么初始化，子类怎么集成父类的变量？
     */
    public Sub() {
        super(20);
    }

    @Override
    public Integer getLenght() {
        return new Integer(5);
    }

    public static void main(String[] args) {
        Super sooper = new Super(30);
        Sub sub = new Sub();
        System.out.println(sooper.getLenght().toString() + "," +
                sub.getLenght().toString());
    }
}
