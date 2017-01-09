package com.tim.common.practice;

/**
 * 路径问题
 * Created by tim.syh on 2017/1/9.
 */
public class PathDemoTest {

    public static void main(String[] args) throws Exception {
        PathDemoTest pathTest = new PathDemoTest();
        pathTest.getPathDemo();
    }

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
}
