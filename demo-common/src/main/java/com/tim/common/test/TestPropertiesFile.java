package com.tim.common.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class TestPropertiesFile {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties userList = new Properties();
		
		/** 非常重要：注意这个默认路径是项目的根目录 ,这个项目里面就是D:/AliDrive/project/DemoTim， 项目的目录
		 *  */
		File file = new File("demo-common/src/main/java/com/tim/common/test/userFile.properties");
        System.out.println("file的绝对路径" + file.getAbsolutePath());
		if(!file.exists()) {
			file.createNewFile();
			System.out.println("文件创立成功");
		}
		
		/** 非web项目的时候这个目录就是D:\AliDrive\project\DemoTim\test.properties，项目的根目录 */
//		File file1 = new File("test.properties");
//		if(!file.exists()) {
//			file.createNewFile();
//			System.out.println("文件创立成功");
//		}
		
		/** 非web项目打印的结果为:D:/AliDrive/project/DemoTim/src/main/java/test/userFile.properties，是基于项目的根目录
		 * 	注意：我的elcipse目录是在D:/Programe Files/eclipse这个目录下,所以这个原始目录和eclipse没有关系.
		 * */
		/** 但是如果是web项目，因为web项目最终是在tomcat容器中跑，不知道跟项目在哪里，所以输出的结果就未知了，比如如果new File()时参数填写为空，那么
		 *  我本地测试输出的是eclipse的目录 D:/Program Files/eclipse/userFile.properties */
		System.out.println("file的绝对路径" + file.getAbsolutePath());
		
		userList.load(new FileInputStream(file));
		
		userList.setProperty("120601", "tangzifu");
		userList.setProperty("120602", "liunian");
		userList.setProperty("120618", "suyanghua");
		if (userList == null) {
			System.out.println("里面没有东西");
			return;
		}
		userList.store(new FileOutputStream(file), "userList");
		
//		userList.load(new FileInputStream(file));
		System.out.println(userList.getProperty("120618"));
	}

}
