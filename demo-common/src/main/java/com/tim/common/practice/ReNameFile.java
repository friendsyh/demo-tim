package com.tim.common.practice;

import java.io.File;

/**
 * 该类用来修改文件名
 *
 * @author Administrator
 */
public class ReNameFile {

    public static String path = "F:/test/study/pg";

    public static void main(String[] args) {
        reName(path);
    }

    public static void reName(String filePath) {

        File rootFile = new File(filePath);
        if (rootFile.isDirectory()) {
            File files[] = rootFile.listFiles();
            if (files != null && files.length > 0) {
                for (int i = 0; i < files.length; i++) {
                    File f = files[i];
                    if (f.isDirectory()) {
                        reName(f.getAbsolutePath());
                    } else {
                        f.renameTo(new File("F:/test/study/pg/" + (i + 1) + ".jpg"));//记得将路径也输入
                    }
                }
            }

        }
//		else{
//			rootFile.renameTo(new File("F:/test/subject/地理/" + i+1));//记得将路径也输入
//		}

    }

}
