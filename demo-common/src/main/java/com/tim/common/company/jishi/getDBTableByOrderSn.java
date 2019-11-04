//package com.tim.common.company.jishi;
//
//import com.doubo.common.hash.StringConsistentHashCoding;
//import com.sibu.mall.common.algorithms.ShardingDBAlgorithms;
//import com.sibu.mall.common.algorithms.ShardingTBAlgorithms;
//
///**
// * @Description:
// * @Author: qjunjia
// * @Date：2019/3/8
// */
//public class getDBTableByOrderSn {
//
//    protected static final int shardingDB = 64;
//
//    protected static final int shardingTB = 8;
//
//    public static void main(String[] args) {
//
//        String identity = "B1910091547041206849792JC";
//
//        System.out.println("订单：库在-" + calculateDB(identity));
//
//        System.out.println("订单：表在-" + calculateTB(identity));
//
//    }
//
//    public static Integer calculateDB(String identity){
//
//        Integer result = communalCalculate(identity);
//
//        result = result % shardingDB;
//
//        return result;
//    }
//
//    public static Integer calculateTB(String identity){
//
//        Integer result = communalCalculate(identity);
//
//        result = secordCalculateTB(result);
//
//        result = result % shardingTB;
//
//        return result;
//    }
//
//    public static Integer communalCalculate(String identity){
//
//        StringConsistentHashCoding dataBaseHashCoding = new StringConsistentHashCoding(1024, 64);
//
//        ShardingDBAlgorithms.setDataBaseHashCoding(dataBaseHashCoding);
//
//        Integer result = ShardingDBAlgorithms.transferRealNodeByLocatorStr(identity);
//
//        return result;
//    }
//
//    public static Integer secordCalculateTB(Integer identity){
//
//        StringConsistentHashCoding tableHashCoding = new StringConsistentHashCoding(64, 1024);
//
//        ShardingTBAlgorithms.setTableHashCoding(tableHashCoding);
//
//        String s = String.valueOf(identity);
//
//        Integer result = ShardingTBAlgorithms.getRealNode(s);
//
//        return result;
//    }
//
//}
