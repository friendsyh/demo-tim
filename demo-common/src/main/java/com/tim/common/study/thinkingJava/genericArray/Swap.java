package com.tim.common.study.thinkingJava.genericArray;

import java.util.Arrays;

import com.tim.common.domain.User;;

public class Swap {

	public static <T> void swapPosition(T[] a,int src,int desr){
		T temp = a[src];
		a[src] = a[desr];
		a[desr] = temp;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] arry = {"lily","tim","enerson","mars"};
		swapPosition(arry, 0, 2);
		System.out.println(Arrays.toString(arry));
		System.out.println(arry.toString());
		
		String[] barray = new String[arry.length];
		System.arraycopy(arry, 1, barray, 0, 3);
		System.out.println("after System.arraycopy() get----------");
		System.out.println(Arrays.toString(barray));
		
		//判断这样复制只是复制了地址，没有重新开辟空间，成为浅复制
		User[] users = {new User("tim"),new User("Lily"),new User("Enerson")};
		User[] userscopy = new User[users.length];
		System.arraycopy(users, 0, userscopy, 0, users.length);
		System.out.println(users[0] == userscopy[0]);
		//结果为true
		
	}

}
