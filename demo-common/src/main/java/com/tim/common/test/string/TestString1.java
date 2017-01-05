package com.tim.common.test.string;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.regex.Pattern;

public class TestString1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		System.out.println(String.valueOf(null));
		String str = "abcd";
//		Vector a = new TestString().splitMyself(str);
//		for(int i = 0;i < a.size();i++){
//			System.out.println(a.get(i) +"--" +a.size());
//		}
//		System.out.println(new TestString().getLastFolderName(str));
		String s2 = "'that','nice','thisThing'"; 
//		System.out.println(s2.contains("'this'"));
		String s3 = "a34567,44646,7641";
		splitMy(s3);

		String s4 = "test1,test2,test3";
		String[] ss4 = s4.split(",");
		List<String> myList = Arrays.asList(ss4);

	}
	
	private Vector splitMyself(String str){
		Vector result = new Vector();
		while(str.indexOf("|") > -1){
			int index = str.indexOf("|");
			String s1 = str.substring(0,index);
			result.add(s1);
			str = str.substring(index + 1, str.length());
		}
		result.add(str);
		return result;
	}
	
	public String getLastFolderName(String path){
		if(null == path || "".equals(path)){
			return "";
		}
		String s = "";
		s = path.substring(path.lastIndexOf("/") + 1, path.length());
		return s;
	}

	public static String splitMy(String str) {
		if(Pattern.compile("(\\d{2,10},)*\\d{2,10},?").matcher(str).matches()){
			System.out.println("匹配成功！");
		}else {
			System.out.println("匹配不成功！");
		}
		System.out.println("Get the length is : " + str.split(",").length + "--" + Arrays.toString(str.split(",")));
		return null;
	}
}
