package com.tim.common.datastruct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

public class DataStructTest {
	public static void main(String[] args) {
/*--------------------------------------------------堆栈的使用----------------------------------------------*/

		 Stack<Integer> stack = new Stack<Integer>();
		 stack.push(5);
		 stack.push(3);
		 System.out.println(stack.peek());
		 }

/*--------------------------------------------------Random的使用----------------------------------------------*/

//        Random random = new Random(47); //一般的构造方法学用48的种子构造随机数。
//		Set<Integer> inset = new HashSet<Integer>();
//		for(int i = 0; i < 10000; i++) {
//			inset.add(random.nextInt(30));//取0到30之间的整数，并且是随机的取用。
//		}
//
//		System.out.println(inset);

/*--------------------------------------------------map的使用----------------------------------------------*/
//		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//		for (int i = 0; i < 10000; i++) {
//			int r = random.nextInt(20);
//			Integer freq = map.get(r);
//			map.put(r, freq == null ? 1 : freq + 1);
//		}
//		System.out.println(map);

/*--------------------------------------------------队列的使用----------------------------------------------*/
//		Queue<Integer> queue = new LinkedList<Integer>();
//		for(int i = 0; i < 10; i++) {
//			queue.offer(random.nextInt(50));
//		}
//		System.out.println(queue);
//		System.out.println(queue.peek());//peek方法得到第一个元素。
//
//		queue.remove();//把队首的元素移除和pool（）方法的效果一样。
//		System.out.println(queue);
//	}
}
