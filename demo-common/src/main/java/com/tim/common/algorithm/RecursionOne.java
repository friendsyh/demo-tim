package com.tim.common.algorithm;

/**
 * 递推算法。包括顺推和逆推。
 *
 * 适用场景:能够用数学公式推出a(n)和a(n-1)的关系。
 * 如果顺推知道a(1)，那么推出a(n) = N * a(n-1)的关系；如果是逆推知道a(MAX)，那么那么推出a(n-1) = N * a(n)的关系
 * 当然这个关系不仅仅是线性的关系。比如fibonacci就不是线性关系
 *
 * Created by tim.syh on 2017/8/7.
 */
public class RecursionOne {

    public static void main(String[] args) {
        RecursionOne.fibonacci(12);
//        RecursionOne.niTui(48);
    }

    /**
     * 递推-顺推算法。顺着推理。
     * 举例：斐波拉契数列。
     * 题目：如果1对兔子每月能生1对小兔子，而每对小兔在它出生后的第3个月(隔两个月)就可以生1对小兔子，
     * 如果从1对初生的小兔子开始，1年后能繁殖多少兔子？
     *
     * 解析：递推得出公式Fn=Fn-1+Fn-2。Fn-1表示上个月总共的兔子数量。
     * Fn-2表示这个月会生子的兔子数量，也就是上上个月的兔子数量(因为要隔两个月才会生子)。
     *
     * @param mouth
     */
    public static void fibonacci(int mouth){
        int[] fibonacci = new int[mouth+1];
        fibonacci[1] = 1;
        fibonacci[2] = 1;

        //用循环 把整个数列的值算出来
        for(int i = 3; i <= mouth; i++){
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
        }

        //打印数列
        for(int i = 1; i <= mouth;i++){
            System.out.println("fibonacci array[" + i + "]=" + fibonacci[i]);
        }
    }

    /**
     * 递推-逆推。知道了最后的结果来逆着推回去。
     *
     * 习题:父亲给他儿子的四年(48个月)大学生活存一笔钱，儿子每月只能取3k作为下个月的生活费，采用的是整存零取的方式，
     * 年利率在1.71%，请问父亲需要一次性存入多少钱。
     *
     * 解析:第一个月月初存入M，那么第一个月末儿子取了之后还剩下：a1=M*(1+0.0171/12)-3000,利息结算减去支出.那么类推
     * 第二个月月末应该结余:a2=a1*(1+0.0171/12)-3000,
     * 第三个月月末应该结余:a3=a2*(1+0.0171/12)-3000,
     * 第n个月月末应该结余:a(n)=a(n-1)*(1+0.0171/12)-3000,
     *
     * 根据以上得出规律：a(47) = 3000 并且 a(n-1) = (a(n)+3000) / (1+0.0171/12)
     * 因为：第47个月月末剩余3000，那么第48个月月初取出3000，恰好四年时间。
     *
     */
    public static void niTui(int mounth){
        double rate = 0.0171;

        //数组a[i] 表示第i个月月末 账号里面应该剩余多少钱。
        double[] array = new double[mounth];

        //最以一个月月末账号剩余3000块,如果总共48个月，那么array[47] = 3000,表示第47月月末剩余3000供第48月使用。
        array[mounth-1] = 3000.0;

        for(int i = mounth-1 ;i > 0; i--){
            array[i-1] = (array[i] + array[mounth]) / (1 + rate / 12);
        }

        //打印数组，其实a[1]表示第一个月末账号应该剩余money。那么a[0]就表示第一次需要存的数量
        for(int i = 0 ;i <= mounth;i++){
            System.out.println("第" + i + "个月末应该剩余的钱" + array[i]);
        }
    }
}
