package com.tim.common.test;

public class TestExcption {

	/**
	 * @param
	 */
	public static void showTest() throws Exception{
		//数组的三中定义方式
		int[] a = new int[]{1,2,3,4};
//		int[] b = new int[4];
//		int[] c = {1,2,3,4};
		
		try {
			System.out.println(a[0]);
			System.out.println(a[4]);
			//后面的就不会执行了！！！！！！！！！
			System.out.println(a[1]);
		} catch (Exception e) {
			System.out.println(a[2]);
			e.printStackTrace();
			System.out.println(a[3]);
		}
		System.out.println("then still go on excute!!");
	}
	
	public static void main(String[] args) {
		try {
			showTest();
			System.out.println("111111111");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("this is catch the exception again!!");
		}
		System.out.println("but this will go on!");
	}

}
