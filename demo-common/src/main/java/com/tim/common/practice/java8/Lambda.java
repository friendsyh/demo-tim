package com.tim.common.practice.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * lambda 表达式
 * Created by tim.syh on 2017/4/6.
 */
public class Lambda {
    public static void main(String[] args) {
        new Lambda().lambdaSort();
    }

    public void lambdaForeach(){
        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer","Roger Federer",
                "Andy Murray","Tomas Berdych",
                "Juan Martin Del Potro"};
        List<String> players =  Arrays.asList(atp);

        players.forEach((player) -> System.out.println(player + ";"));
    }

    private void lambdaSort(){
        String[] players = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer","Roger Federer",
                "Andy Murray","Tomas Berdych",
                "Juan Martin Del Potro"};

//        //匿名函数写法。匿名函数主要是不可以复用
//        Arrays.sort(players, new Comparator<String>() {
//            @Override
//            public int compare(String s1, String s2) {
//                return s1.compareTo(s2);
//            }
//        });
//
//        //匿名函数的写法就相当于这种。
//        Arrays.sort(players, new MyComparator());
//
//        //lamda表达式的写法
//        Arrays.sort(players, (String s1, String s2) -> (s1.compareTo(s2)));

        //用stream流这样写有问题，排好序了，但是返回的是一个流。不行
        Arrays.stream(players).sorted();

        //默认为升序排序
        List<String> rlt = Arrays.stream(players).sorted().collect(Collectors.toList());


        System.out.println(Arrays.toString(players));

    }

    class MyComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    }
}
