package com.tim.common.test.classLoader;

public class ColorPoint extends Point {
	
	private String color;

	/**
	 * @param x
	 * @param y
	 * @param color
	 */
	public ColorPoint(int x, int y, String color) {
		super(x, y);
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
