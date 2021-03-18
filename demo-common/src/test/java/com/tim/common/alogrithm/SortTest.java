package com.tim.common.alogrithm;

import com.tim.common.pojo.InitTestData;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by friendsyh on 2020/9/16.
 */
public class SortTest extends InitTestData {

    private static final Logger logger = LoggerFactory.getLogger(SortTest.class);

    @Test
    public void insertSort(){

        int[] array = {49,385,10,890,5,76,1458,38};
//        int[] array = {49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};


        //前面a[0]——a[i-1] 已经排序好
        for(int i = 1; i < array.length; i++) {
            int insert = array[i];

            for(int j = i - 1; j >= 0; j--) {
                if(insert < array[j]) {
                    array[j + 1] = array[j];
                }
            }

        }
    }
}
