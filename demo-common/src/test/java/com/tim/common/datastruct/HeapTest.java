package com.tim.common.datastruct;

import com.tim.common.pojo.InitTestData;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 
 * 数据结构 堆 的相关方法(只考虑大顶堆)
 * 具有n个元素的序列 （h1,h2,...,hn),当且仅当满足（hi>=h2i,hi>=2i+1）或（hi<=h2i,hi<=2i+1） (i=1,2,...,n/2)时称之为堆.
 * 是一个完全二叉树
 * @author 苏阳华
 * @since 2015-04-29
 *
 */
public class HeapTest extends InitTestData {

    @Before
    public void init(){
        initObject();
    }

    @Test
    public void testBuildMaxHeapByJDK() {
        int[] array = {49,385,10,890,5,76,1458,38};
        System.out.println("before sorted:" + Arrays.toString(array));

        //构造一个大根堆进行排序
        Queue<Integer> sortedQueue = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for(int i = 0; i < array.length; i++) {
            sortedQueue.offer(array[i]);
        }

        //不能直接打印sortedQueue，需要使用poll方法才是对的，poll方法就是取出根节点并且将该节点移除形成新的heap。不断取根节点就行。
        System.out.println("after sorted:");
        for(int i = 0; i < array.length; i++) {
            System.out.print(sortedQueue.poll() + ",");
        }
    }

    @Test
    public void testBuildMaxHeap() {
        int[] array = {49,385,10,890,5,76,1458,38};
        System.out.println("before sorted:" + Arrays.toString(array));
//		Arrays.sort(array);
        //需要从最后一个叶节点的父节点开始遍历，一直到根节点。
        for (int i = array.length / 2; i >= 0; i--) {
            buildMaxHeap(array, i);
        }
        System.out.println("after sorted:" + Arrays.toString(array));
    }
	
    /**
     * 递归法构造大顶堆
     * @param array
     * @param rootNodeIndex
     */
	private static void buildMaxHeap(int array[], int rootNodeIndex){
		
		//定义左右节点的下标索引
		int left = rootNodeIndex * 2 + 1;
		int right = rootNodeIndex * 2 + 2;
		
		//定义最大的节点，默认为rootNode
		int largestIndex = rootNodeIndex;
		
		if(left < array.length && array[left] > array[rootNodeIndex]){
			largestIndex = left;
		}
		if(right < array.length && array[right] > array[rootNodeIndex]){
			largestIndex = right;
		}
		
		//根节点不是最大的，那么就和largest交换，然后再对交换过的子树进行构造
		if(rootNodeIndex != largestIndex){
			swap(array, largestIndex, rootNodeIndex);
			buildMaxHeap(array, largestIndex);
		}
	}
	
	/**
     * 对数组array[i] 和 array[j]进行交换
     * @param array
     * @param i
     * @param j
     */
    private static void swap(int[] array, int i, int j) {  
        int tmp=array[i];  
        array[i]=array[j];  
        array[j]=tmp;  
    } 
}
