package com.tim.common.designpatter.decorate.headfirst;

/**
 * 装饰者模式
 * Created by tim.syh on 2016/7/10.
 */
public class MainTest {

    public static void main(String[] args) {

        //理解基类，tea.cost()方法，先拿出茶的价格，然后从基类去拿调料的价格。如果有这种调料，基类会自己添加。
        Beverage tea = new Tea();
        tea = new SizeDecorator(tea,"L");
        System.out.println(tea.getDescription() + " cost:" + tea.cost());

        Beverage cafe = new Cafe();
        //最难理解的代码，new了一个装饰者之后还是自己，因为装饰者和组件有着共同的基类Beverage
        cafe = new MilkDecorator(cafe);
        cafe = new SugarDecorator(cafe);
        System.out.println(cafe.getDescription() + " cost:" + cafe.cost());

        //上面代码可以简单写成这样子,就想JDK的流一样
        Beverage cafe1 = new SugarDecorator(new MilkDecorator(new Cafe()));
        System.out.println(cafe1.getDescription() + " cost:" + cafe1.cost());
    }
}
