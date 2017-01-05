package com.tim.common.datastruct;

public class TestDumb {

	public int theLessDumb(){
		boolean[] result = new boolean[100];
		for(int i = 0;i < result.length;i++){
			result[i] = false;
		}
		for(int i = 0;i < 100;i++){
			for(int j = 0;j < 100;j++){
				if((i+1) % (j+1) == 0){
					result[i] = !result[i];
				}
			}
		}
		int count = 0;
		for(int i = 0;i < result.length;i++){
			if(result[i]){
				System.out.println("the " + (i+1) + " lab is OK!");
				count ++;
			}
		}
		return count;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new TestDumb().theLessDumb());
	}

}
