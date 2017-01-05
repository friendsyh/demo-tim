package com.tim.common.test.enumTest;

public enum WeekDayEnum {
	//枚举类型必须要首先定义所有的类型。SUN就是WeekDayEnum的一种枚举，是通过构造方法产生的。
	SUN("星期天"),
	MON("星期一");
	
	private String name;
	
	private WeekDayEnum(){};
	
	private WeekDayEnum(String name){
		this.name = name;
	}
	
	public String toString(){
		return this.name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		System.out.println(SUN.getName());
	}
}
