package com.tim.common.algorithm.algoriMethod;

/**
 * 递归算法。程序调用自身叫做递归。
 * 发现递归和递推首先都需要用数学去推，退出规律，然后用代码实现规律。
 *
 * 三要素
 * 1. 一个问题可以分解为几个子问题的解
 * 2. 这个问题和分解之后的子问题，除了数据规模不同，求解思路完全一样
 * 3. 当子问题的规模足够小时，必须能够直接求出该规模问题的解，其实也就是必须要有结束递归的条件。
 *
 * 注意：
 * 1. 递归必须要有一个递归出口。
 * 2. 深层次的递归会涉及到频繁进栈出栈和分配内存空间，所以运行效率比较低，当问题规模较大时，不推荐使用。
 * 3. 在递归过程中，每次调用中的参数，方法返回点，局部变量都是存放在堆栈中的，如果当问题规模非常大时，容易造成堆栈溢出。
 *
 * Created by tim.syh on 2017/8/7.
 */
public class RecursionTwo {

    public static void main(String[] args) {
//        System.out.println(RecursionTwo.fact(5)); //5!=120
        System.out.println(RecursionTwo.fact(50)); //50!=-3258495067890909184,已经超出了long类型的范围
//        System.out.println(RecursionTwo.fact(100000)); //100000!=java.lang.StackOverflowError,堆栈异常.

//        RecursionTwo.convertToBinary(63);//111111
//        RecursionTwo.convertToBinary(64);//1000000
//        RecursionTwo.convertToBinary(100);//1100100

//        System.out.println(RecursionTwo.convertToBinaryWithRecursion(2));//10
//        System.out.println(RecursionTwo.convertToBinaryWithRecursion(63));//111111
//        System.out.println(RecursionTwo.convertToBinaryWithRecursion(64));//1000000
//        System.out.println(RecursionTwo.convertToBinaryWithRecursion(100));//1100100

//        hanoi(3, "A", "C", "B");
    }

    /**
     * 举例：整数的阶乘
     * 比较消耗栈空间，计算到50就long溢出了。计算到100000就栈抛出异常。
     *
     * 解析：Fn = n * Fn-1
     * @param number
     */
    public static long fact(final int number){
        if(number == 1){
            return 1;
        }
        return number * fact(number - 1);
    }

    /**
     * 十进制转二进制不使用递归
     * 思路:采用除2取余法，取余数为相应二进制数的最低位，然后再用商除以2得到次低位.......直到最后一次相除商为0时得到二进制的最高位
     *
     */
    public static void convertToBinary(int number){
        StringBuffer ss = new StringBuffer();
        while(number / 2 != 0){
            ss.append(number % 2);
            number = number / 2;
        }
        ss.append(number);

        //进行反转
        System.out.println(ss.reverse().toString());
    }

    /**
     * 十进制转二进制使用递归
     * 思路：number/2得到的二进制数，加上nubmer/2的余数作为低位就可以了。
     * @param number
     * @return
     */
    public static String convertToBinaryWithRecursion(int number){
        if(number / 2 == 0){
            return "" + number % 2;
        }
        return "" + convertToBinaryWithRecursion(number / 2) + number % 2;
    }

    /**
     * 汉诺塔问题。经典的递归问题
     * 问题：随便搜下就知道了。A,B,C三个杆，全部从A移动到C，要求1.大盘子必须在下面 2.每次只能移动一个盘子。
     * @param index
     */
    public static void hanoi(int index, String from, String to, String bridge){
        if(index == 1){
            move(1, from, to);
        } else{
            //把之前的index-1以上的盘子进行hanoi，从A移动到B，借助C
            hanoi(index-1, from, bridge, to);
            //把index直接从A移动到C
            move(index, from, to);
            //把index-1以上的盘子进行hanoi，从B移动到C，就完成了整个操作
            hanoi(index-1, bridge, to, from);
        }
    }

    private static void move(int index, String from, String to){
        System.out.println("把编号为" + index + "的圆盘从" + from + "---->" + to);
    }
}
