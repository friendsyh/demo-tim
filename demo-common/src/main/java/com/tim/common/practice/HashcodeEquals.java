package com.tim.common.practice;

/**
 * 测试hashcode和equals
 * 1. Object.equals()比较的是引用地址是否相等（同一个对象），源码 this==obj。但是实际上我们有个时候我们
 * 希望两个对象的属性相等就完全相等，这个时候需要重写equals（）方法。
 * Created by tim.syh on 2017/3/4.
 */
public class HashcodeEquals {
    private int number;

    private String data;

    /**
     *只需要属性完全相等就相等。需要重写equals()，重写需要满足
     * 1. 自反性 x.equals(x) 一定返回true
     * 2. 对null x.equals(null) 一定返回true
     * 3. 传递性
     */
    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null || (obj.getClass() != this.getClass())){
            return false;
        }

        //能执行到这里，说明obj和this同类且非null。
        //number 是相同的。并且data也相同。
        HashcodeEquals temp = (HashcodeEquals)obj;
        //this.data == temp.data 主要用来来判断为空的情况，如果为空，string.equals()方法会抛出空指针异常
        return this.number == temp.number && (this.data == temp.data || (data != null && data.equals(temp.data)));
    }

    /**
     * 实现hashcode的原则。
     * 1. 如果两个对象equals返回true，那么hashcode一定要相等。
     * 2. 如果两个对象equals返回false，hashcode可以用不相等。
     * 3. 考虑到hashcode的用途，尽量让不同对象的hashcode值不冲突。
     *
     * 根据1,2,3，如果是Integer类型，hashCode()直接返回value就行了。为什么选择17，因为碰撞概率比较低吧。
     * 可以参考String的hashcode方法，是把每个字符进行2的n-1次方然后求和。
     * 为了尽量保证不同的string返回的hashcode不一样，
     * @return
     */
    @Override
    public int hashCode(){
        int result = 17;
        result = result * 31 + data.hashCode();
        result = result * 31 + number;

        return result;
    }
}
