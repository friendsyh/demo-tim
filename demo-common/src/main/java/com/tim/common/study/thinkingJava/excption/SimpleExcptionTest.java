package com.tim.common.study.thinkingJava.excption;

class SimpleExption extends Exception{
	public SimpleExption() {
		System.out.println("can not be 0");
	}
	public SimpleExption(String s) {
		super(s);
	}
};

public class SimpleExcptionTest {

	public int function(int a,int b) throws SimpleExption{
		if(b == 0){
			throw new SimpleExption();
		}else {
			return a/b;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SimpleExcptionTest test1 = new SimpleExcptionTest();
		try {
			System.out.println("result is:" + test1.function(10,0));
		} catch (SimpleExption e) {
			e.printStackTrace();
			System.out.println("Caught it..");
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}

}
