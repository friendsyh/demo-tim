package com.tim.common.test.string;

public class TestJsonJava {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String resultJson = "timepast";
		String bookingListResult = "OK";
		String jsonData = "bizParam={\"resultJson\":\""+resultJson+"\","+"\"bookingList\":\""+bookingListResult+"\"}";
		System.out.println(jsonData.replace("bizParam=", ""));

//		try {
//			test();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

	}

	//用来测试异常断点。
	private static void test(){
		String ss = null;
		String sss = "123";
		ss.equals("OK");
		String mm = "123";
	}

}
