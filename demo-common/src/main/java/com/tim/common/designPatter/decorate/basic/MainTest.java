package com.tim.common.designPatter.decorate.basic;

/**
 * 这样子做的问题如下：
 * 1.调料价格的变化需要修改基类代码
 * 2.一旦出现新的调料，我们需要在改变基类的cost的代码
 * 3.总的开说就是不符合开闭原则喽
 * Created by tim.syh on 2016/7/10.
 */
public class MainTest {

    public static void main(String[] args) {

        //理解基类，tea.cost()方法，先拿出茶的价格，然后从基类去拿调料的价格。如果有这种调料，基类会自己添加.
        //使用的是继承的方式。
        Beverage tea = new Tea();
        tea.setSugar(true);
        tea.setMilk(true);
        System.out.println(tea.description + " cost:" + tea.cost());

        Beverage cafe = new Cafe();
        cafe.setSugar(true);
        cafe.setMilk(true);
        System.out.println(cafe.description + " cost:" + cafe.cost());
    }
}
