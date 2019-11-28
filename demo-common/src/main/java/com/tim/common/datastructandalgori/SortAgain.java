package com.tim.common.datastructandalgori;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * java排序常见算法
 * 选择，冒泡，简单插入等排序 因为每一次比较都只是移动了相邻的两个数，所以效率比较低。
 * 但是比如快速，合并，shell，堆排序等依次比较可以跳跃到较远的位置，所以效率比较高。
 * @author 苏阳华
 * @since 2015-01-03
 *
 */
public class SortAgain {

	public static void main(String[] args) {
		int[] array = {49,385,10,890,5,76,1458,38};
//		int[] array = {49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
//		int[] array = {3,1,5,2};
		System.out.println("before sorted:\n" + Arrays.toString(array));
//		bullmSort(array);
//		selectSort(array);
//		insertSort(array);
//		shellSort(array);
		mergeSort(array, 0, array.length - 1);
//		quickSort(array, 0, array.length - 1);
//		radixSort(array);
//		heapSort(array);
		System.out.println("after sorted:\n" + Arrays.toString(array));
	}

    public static void mergeSort(int[] array, int left, int right) {
        if(left < right) {
            int middle = (left + right) / 2;
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            merge(array, left, middle, right);
        }
    }

    private static void merge(int[] array, int left, int middle, int right) {
	    int[] tempArray = new int[array.length];
	    int temp = left;
	    int index = left;
	    int rightStart = middle + 1;
	    while(left <= middle && rightStart <= right) {
	        if(array[left] < array[rightStart]) {
                tempArray[index++] = array[left++];
            } else {
                tempArray[index++] = array[rightStart++];
            }
        }

	    while(left <= middle) {
            tempArray[index++] = array[left++];
        }
        while(rightStart <= right) {
            tempArray[index++] = array[rightStart++];
        }

        while(temp <= right) {
            array[temp] = tempArray[temp];
            temp++;
        }
    }

}
