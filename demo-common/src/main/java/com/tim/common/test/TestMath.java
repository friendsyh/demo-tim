package com.tim.common.test;

public class TestMath {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double a = 5;
//		System.out.println(Math.ceil(9.0/4));
		for (int i = 0; i < 100; i++) {
			System.out.println(getRandom(1.15,2.65));
		}
		
	}
	
	private static double getRandom(double min,double max){
		return Math.random() * (max - min) + min;
	}

}
