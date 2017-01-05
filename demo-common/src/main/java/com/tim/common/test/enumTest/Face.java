package com.tim.common.test.enumTest;
/**
 * 骰子的六面
 * @author Administrator
 *
 */
public enum Face {
	ONE(2),
	TWO(3),
	THREE(4),
	FOUR(5),
	FIVE(6),
	SIX(7);
	
	public int vaule;
	
	private Face(int value) {
		this.vaule = value;
	}
}
