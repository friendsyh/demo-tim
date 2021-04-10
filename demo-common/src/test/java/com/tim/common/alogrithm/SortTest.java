package com.tim.common.alogrithm;

import com.tim.common.pojo.InitTestData;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Created by friendsyh on 2020/9/16.
 */
public class SortTest extends InitTestData {

    private static final Logger logger = LoggerFactory.getLogger(SortTest.class);

    @Test
    public void insertSort(){

//        int[] array = {49,385,10,890,5,76,1458,38};
        int[] array = {49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};

        System.out.println("before sorted:\n" + Arrays.toString(array));
        //前面a[0]——a[i-1] 已经排序好
        for(int i = 1; i < array.length; i++) {
            int needInsert = array[i]; //a[i]就是要插入的元素
            int inertIndex = i; //a[i]需要插入的位置，初始的时候设置在i的位置
            for(int j = i - 1; j >= 0; j--) {
                if(needInsert < array[j]) {
                    array[j + 1] = array[j];
                    inertIndex--; //插入的位置往前面移
                }
            }
            array[inertIndex] = needInsert;
        }

        System.out.println("after sorted:\n" + Arrays.toString(array));
    }

    @Test
    public void testQuickSort() {
        int[] array = {49,385,10,890,5,76,1458,38};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void testPartition() {
        int[] array = {49,385,10,890,5,76,1458,38};

        //把某一个元素排好序放到指定坑位
        System.out.println("partition index=" + partition(array, 0, array.length - 1));
        System.out.println("partition:" + Arrays.toString(array));

    }

    private static void quickSort(int array[], int low, int high) {
        System.out.println("--------------------a quickSort call start----------------");
        System.out.println("low--" + low + "--high--" + high);
        if (low < high) {
            int index = partition(array, low, high);
            System.out.println("partition:" + low + "," + (index - 1) + "----" + (index + 1) + "," + high);
            System.out.println("index--" + index);
            System.out.println("arrays--" + Arrays.toString(array));
            quickSort(array, low, index - 1);
            quickSort(array, index + 1, high);
        }
//        System.out.println("--------------------a quickSort call end----------------");  //这个肯定是不对称的
    }

    private static int partition(int array[], int low, int high) {
        int start = array[low];
        while(low < high) {
            while(low < high && array[high] >= start) {
                high--;
            }
            array[low] = array[high];

            while(low < high && array[low] <= start) {
                low++;
            }
            array[high] = array[low];
        }
        array[low] = start;
        return low;
    }

    /**
     * 合并两个排序好的数组array[left,middle] 和array[middle+1,right]
     */
    private static void merge(int[] array, int left, int middle, int right) {

        int[] tmpArray = new int[array.length];
        int rightArrayLeftIndex = middle + 1;

        while (left < middle && rightArrayLeftIndex < right) {

        }

    }
}
