package com.tim.common;

import com.tim.common.pojo.InitTestData;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * 路径相关测试
 * Created by tim.syh on 2017/1/8.
 */
public class PathTest {

    @Test
    public void getPathDemo() throws Exception {
        //取得根目录路径
        String rootPath = getClass().getResource("/").getFile().toString();
        System.out.println("rootPath:" + rootPath);
        //当前目录路径
        String currentPath1 = getClass().getResource(".").getFile().toString();
        System.out.println("currentPath:" + currentPath1);
        String currentPath2 = getClass().getResource("").getFile().toString();
        System.out.println("currentPath:" + currentPath2);

        //当前目录的上级目录路径
        String parentPath = getClass().getResource("../").getFile().toString();
        System.out.println("parentPath:" + parentPath);
    }

    @Test
    public void testPath() throws Exception {
        Properties userList = new Properties();

        /** 非常重要：注意这个默认路径是项目的根目录 ,这个项目里面就是D:/AliDrive/project/demo-tim， 项目的目录
         *  */
        File file = new File("src/test/java/com/tim/common/userFile.properties");
        System.out.println("file的绝对路径" + file.getAbsolutePath());
        if (!file.exists()) {
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

        userList.load(new FileInputStream(file));
//        userList.setProperty("120601", "tangzifu");
//        userList.setProperty("120602", "liunian");
//        userList.setProperty("120618", "suyanghua");
//        if (userList == null) {
//            System.out.println("里面没有东西");
//            return;
//        }
//        userList.store(new FileOutputStream(file), "userList");

        System.out.println(userList.getProperty("120618"));
    }

}
