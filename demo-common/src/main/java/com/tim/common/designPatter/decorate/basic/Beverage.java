package com.tim.common.designPatter.decorate.basic;

/**
 *饮料基类
 * Created by tim.syh on 2016/7/10.
 */
public class Beverage {

    public String description = "Unknow beverage";

    /** 含糖 */
    private boolean sugar;

    /** 糖的价格 */
    private float sugarCost = 1;

    /** 含牛奶 */
    private boolean milk;

    /** 牛奶的价格 */
    private float milkCost = 1.5f;

    /** 含摩卡 */
    private boolean mocha;

    /** 摩卡的价格 */
    private float mochaCost = 3f;

    public float cost(){
        float condimentCost = 0.0f;
        if(isSugar()){
            condimentCost = condimentCost + sugarCost;
        }
        if(isMilk()){
            condimentCost = condimentCost + milkCost;
        }
        if(isMocha()){
            condimentCost = condimentCost + mochaCost;
        }
        return condimentCost;
    }

    public boolean isSugar() {
        return sugar;
    }

    public void setSugar(boolean sugar) {
        this.sugar = sugar;
    }

    public boolean isMilk() {
        return milk;
    }

    public void setMilk(boolean milk) {
        this.milk = milk;
    }

    public boolean isMocha() {
        return mocha;
    }

    public void setMocha(boolean mocha) {
        this.mocha = mocha;
    }
}
