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
public class Sort {

	public static void main(String[] args) {
		int[] array = {49,385,10,890,5,76,1458,38};
//		int[] array = {49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
//		int[] array = {3,1,5,2};
		System.out.println("before sorted:\n" + Arrays.toString(array));
//		bullmSort(array);
//		selectSort(array);
//		insertSort(array);
		shellSort(array);
//		mergeSort(array, 0, array.length - 1);
//		quickSort(array, 0, array.length - 1);
//		radixSort(array);
//		heapSort(array);
		System.out.println("after sorted:\n" + Arrays.toString(array));
	}
	
	
	/**
	 * 冒泡排序。
	 * 外层循环遍历N-1次，每次循环结束后把最大的数冒泡到最后一个位置。内层循环比较相邻的两个数，如果前面的数大于后面的数，交换位置
	 * 冒泡排序是稳定的。算法时间复杂度O(n2)--[n的平方]
	 * @param array
	 */
	public static void bullmSort(int[] array) {
		System.out.println("******bullmSortting******");
		int length = array.length;
		for(int i = 0;i < length - 1;i++){
			for(int j = 0;j < length - i - 1;j++){
				if(array[j] > array[j+1]){
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			} 
			//用来看整个排序的过程
			System.out.println(Arrays.toString(array));
		}
	}
	
	/**
	 * 选择排序
	 * 在要排序的一组数中，选出最小的一个数与第一个位置的数交换；然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止。
	 * 选择排序是不稳定的排序方法（比如序列[5， 5， 3]第一次就将第一个[5]与[3]交换，导致第一个5挪动到第二个5后面）。算法复杂度O(n2)--[n的平方] 
	 * @param array
	 */
	public static void selectSort(int[] array) {
		System.out.println("******selectSortting******");
		int length = array.length;
		for(int i = 0;i < length - 1;i++){
			for(int j = i + 1;j < length;j++){
				if(array[i] > array[j]){
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}  
			//用来看整个排序的过程
			System.out.println(Arrays.toString(array));
		}
	}
	
	/**
	 * 直接插入排序
	 * 在要排序的一组数中，假设前面(n-1) [n>=2] 个数已经是排好顺序的，现在要把第n个数插到前面的有序数中，使得这n个数也是排好顺序的。如此反复循环，直到全部排好顺序。
	 * 直接插入排序是稳定的。算法时间复杂度O(n2)--[n的平方] 
	 * @param array
	 */
	public static void insertSort(int[] array) {
		System.out.println("******insertSortting******");
		int length = array.length;
		int key = 0;
		int j = 0;
		for(int i = 1;i < length;i++){
			//需要插入的array[i]元素，默认前面的array[0]——array[i-1]都已经排序好了
			key = array[i];
			//遍历前面排序好的array[j]——array[0]，如果发现key < a[j]，那么将a[j]后移一位到a[j+1],到最后会腾出一个位置。
            //这个地方巧妙的从排序好最大的也就是数组最末尾的数开始遍历。可以直接实现插入数组后后面数据都要移位的操作。如果从0开始遍历，处理起来就麻烦一些
			for(j = i - 1;j >= 0 && key < array[j];j--){
				array[j+1] = array[j];
			}
			array[j+1] = key;
			//用来看整个排序的过程
			System.out.println(Arrays.toString(array));
		}
	}
	
	/**
	 * shell排序
	 * 在直接插入排序算法中，每次插入一个数，使有序序列只增加1个节点，并且对插入下一个数没有提供任何帮助。
	 * 如果比较相隔较远距离（称为增量）的数，使得数移动时能跨过多个元素，则进行一次比较就可能消除多个元素交换。
	 * 
	 * 算法先将要排序的一组数按某个增量d分成若干组，每组中记录的下标相差d.
	 * 对每组中全部元素进行排序，然后再用一个较小的增量对它进行，在每组中再进行排序。当增量减到1时，整个要排序的数被分成一组，排序完成。
	 * 希尔排序是不稳定的。时间复杂度为O(n1.5)--[n的1.5次方]
	 * @param array
	 */
	public static void shellSort(int[] array) {
		System.out.println("******shellSortting******");
		int length = array.length;
		int key = 0;
		int j = 0;
		int gap = length / 2;
		//以下是一个插入排序。但是每次插入排序都是叉开的一个小数列。
		//gap用来分数组，把数组分为[[0,gap],[1,gap+1],……]等数组，依次对里面的小数组进行排序。
		for(gap = length / 2;gap > 0;gap = gap / 2){
			for(int i = gap;i < length;i++){
				key = array[i];
				for(j = i - gap;j >= 0 && key < array[j];j = j - gap){
					array[j+gap] = array[j];
				}
				array[j+gap] = key;
			}
			//用来看整个排序的过程
			System.out.println(Arrays.toString(array));
		}
	}

    /**
     * 归并排序算法
     * 归并（Merge）排序法是将两个（或两个以上）有序表合并成一个新的有序表，即把待排序序列分为若干个子序列，
     * 每个子序列是有序的。然后再把有序子序列合并为整体有序序列。
     * 归并排序是不稳定的，时间复杂度为O(nlogn)
     * @param array
     * @param left
     * @param right
     */
    public static void mergeSort(int[] array, int left, int right) {
        if(left<right){
            int middle = (left + right) / 2;
            //对左边进行递归
            mergeSort(array, left, middle);
            //对右边进行递归
            mergeSort(array, middle+1, right);
            //合并
            merge(array, left, middle, right);
        }
    }

    /**
     * 合并两个已经排好序的数组。
     * @param array
     * @param left 第一个数组的起点索引
     * @param middle 第一个数组的终点索引，middle+1 为第二个数组的起点索引
     * @param right 第二个数组的终点索引
     */
    private static void merge(int[] array, int left, int middle, int right) {
        int[] tmpArr = new int[array.length];
        int mid = middle+1; //右边的起始位置
        int tmp = left;
        int third = left;
        //这个地方用for循环也可以，总共是有两个变量。
        while(left <= middle && mid <= right){
            //从两个数组中选取较小的数放入中间数组
            if(array[left] <= array[mid]){
                tmpArr[third++] = array[left++];
            }else{
                tmpArr[third++] = array[mid++];
            }
        }
        //将剩余的部分放入中间数组
        while(left <= middle){
            tmpArr[third++] = array[left++];
        }
        while(mid <= right){
            tmpArr[third++] = array[mid++];
        }
        //将中间数组复制回原数组
        while(tmp <= right){
            array[tmp] = tmpArr[tmp++];
        }

        //打印每次分区后的结果
        System.out.println(Arrays.toString(array));
    }
	
	/**
	 * 快速排序
	 * 选择一个基准元素,通常选择第一个元素或者最后一个元素,通过一趟扫描，将待排序列分成两部分,一部分比基准元素小,
	 * 一部分大于等于基准元素,此时基准元素在其排好序后的正确位置,然后再用同样的方法递归地排序划分的两部分。
	 * @param array
	 *            要排序的数组
	 * @param low
	 *            数组中小的索引，用于向后扫描,最开始取0
	 * @param high
	 *            数组中大的索引，用于向前扫描,最开始取array.length-1
	 * 快速排序是不稳定的，时间复杂度为O(nlogn)
	 */
	public static void quickSort(int array[], int low, int high) {
		System.out.println("******quickSortting******");
		if (low < high) {
			int mid = partition(array, low, high);
			// 对枢纽关键字左边的分区进行分区
			quickSort(array, low, mid - 1);
			// 对枢纽关键字右边的分区进行分区
			quickSort(array, mid + 1, high);
		}
	}

	/**
	 * 挖坑填数，即具体实现分区的方法，每次的结果是将数组分为比枢纽关键字小的在左边， 比枢纽关键字大的在右边
	 * @param array
	 *            要排序的数组
	 * @param low
	 * @param high
	 * @return 执行完分区后low的坐标值，用于下次递归的时候分区用
	 */
	private static int partition(int array[], int low, int high) {
		// 将数组中第一个元素作为枢纽关键字，这个关键字将在本次分区过程中不变
		int pivotKey = array[low];

		if (low < high) {
			while (low < high) {
				// 从后向前扫描，如果array[high]>=pivotKey，则下表high向前移动
				while (low < high && array[high] >= pivotKey) {
					high--;
				}
				// array[high]<pivotKey，则将array[high]挖出来填入array[low]，即刚才被pivotKey挖走的地方
				array[low] = array[high];

				// 如果array[low]<=pivotKey，则下表low向后移动
				while (low < high && array[low] <= pivotKey) {
					low++;
				}
				// arry[low]>pivotKey，将array[low]挖出来填入刚才被挖的array[high]
				array[high] = array[low];
			}
			// 如果到最后low=high的时候，也就是扫描完整个数组，则将枢纽关键字填入剩下的那个被挖的坑array[low]
			array[low] = pivotKey;
		}
		// 打印每次分区后的结果
//		System.out.println(Arrays.toString(array));
		// 将这个分区结束时的坐标i返回，用于下次执行时当做前分区的尾坐标，当做后分区的头坐标
		return low;
	}

    /**
     * 基数排序
     * 将所有待比较数值（正整数）统一为同样的数位长度，数位较短的数前面补零。
     * 然后，从最低位开始，依次进行一次排序。这样从最低位排序一直到最高位排序完成以后,数列就变成一个有序序列。
     * 基数排序不稳定，时间复杂度为O(K*n)
     * @param array
     */
    public static void radixSort(int array[]){
    	//找出最大的，看他总共几位数，就是需要排序的趟数
    	int max = array[0];
    	for(int i = 1;i < array.length;i++){
    		if(max < array[i]){
    			max = array[i];
    		}
    	}
    	
    	System.out.println("the max=" + max);
    	//确定排序的趟数(数组最大数的位数)。
    	int times = 0;
    	while(max > 0){
    		max = max / 10;
    		times++;
    	}
    	
    	//构建一个长度为10数组，数组里面的元素为整形数组类型，在比较第N位数时 用来存放【0-9】每个数字出现过的array[i]。
    	//比如 比较个位数时：list[5]={45,5，155}，也就是所有个位数为5的元素
    	List<ArrayList<Integer>> list= new ArrayList<ArrayList<Integer>>();
    	for(int i = 0;i < 10;i++){
    		ArrayList<Integer> queue = new ArrayList<Integer>();
    		list.add(queue);
    	}
    	
    	//进行times次的分配和收集。从个位开始，一直到最后一位
    	for(int i = 0;i < times;i++){
    		//对数组所有的元素进行分配
    		for(int j = 0;j < array.length;j++){
    			//第i位数上的数组，比如i=0，个位的数字，i=1，十位上的数组。
    			int x = array[j] % (int)Math.pow(10, i + 1) / (int)Math.pow(10, i);
    			//获取保存这个数字的数组，插入其中，并且重新注入list当中
    			ArrayList<Integer> queue1 = list.get(x);
    			queue1.add(array[j]);
    			list.set(x, queue1);
    		}
    		
    		//新的元素下标
    		int count = 0;
    		//重新收集元素
    		for(int k = 0;k < 10;k++){
    			while(list.get(k).size() > 0){
    				ArrayList<Integer> queue2 = list.get(k);
    				array[count] = queue2.get(0);
    				queue2.remove(0);
    				count++;
    			}
    		}
    		// 打印每次分区后的结果
    		System.out.println(Arrays.toString(array));
    	}
    }
    
    /**
     * 堆排序
     * 开始时把要排序的数的序列看作是一棵顺序存储的二叉树，调整它们的存储序，使之成为一个 堆，这时堆的根节点的数最大。
     * 然后将根节点与堆的最后一个节点交换。然后对前面(n-1)个数重新调整使之成为堆。依此类推，直到只有两个节点的堆，并对 它们作交换，最后得到有n个节点的有序序列。
     * @param array
     */
    public static void heapSort(int array[]) {
    	//循环建堆  
		for(int i = 0;i < array.length - 1;i++){
			//建堆
			buildMaxHeap(array, array.length - 1 - i);
			System.out.println("Build Heap[" + (i+1) + "]:" + Arrays.toString(array));  
			//交换堆顶和最后一个元素  
			swap(array, 0, array.length - 1 - i);
		}
	}
    
    /**
     * 构建大顶堆
     * @param array
     * @param lastIndex
     */
    private static void buildMaxHeap(int[] array, int lastIndex){
         //从lastIndex处节点（最后一个节点）的父节点开始 
        for(int i = (lastIndex - 1) / 2;i >= 0;i--){
            //k保存正在判断的节点 
            int k = i;
            //如果当前k节点的子节点存在  
            while(k * 2 + 1 <= lastIndex){
                //k节点的左子节点的索引 
                int biggerIndex = 2 * k + 1;
                //如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
                if(biggerIndex < lastIndex){  
                    //若果右子节点的值较大  
                    if(array[biggerIndex] < array[biggerIndex + 1]){  
                        //biggerIndex总是记录较大子节点的索引  
                        biggerIndex++;  
                    }  
                }  
                //如果k节点的值小于其较大的子节点的值  
                if(array[k] < array[biggerIndex]){  
                    //交换他们  
                    swap(array,k,biggerIndex);  
                    //将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值  
                    k = biggerIndex;  
                }else{  
                    break;  
                }  
            }
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
