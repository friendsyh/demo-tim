package com.tim.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * ZIP压缩工具类
 * Created by suyh on 2021/10/28.
 */
public class ZipUtils {

    private static final Logger log = LoggerFactory.getLogger(ZipUtils.class);

    public static void main(String[] args) {
        String source = "D:/data/cas/test/cas_189.csv";
        String target = "D:/data/cas/test/aaa.zip";
        doCompress(source, target);

        File file = new File(source);
        file.delete();
    }

    private ZipUtils() {
    }

    public static void doCompress(String srcFile, String zipFile) {
        try {
            doCompress(new File(srcFile), new File(zipFile));
        } catch (IOException e) {
            log.error("doCompress error", e);
        }
    }

    /**
     * 文件压缩
     *
     * @param srcFile 目录或者单个文件
     * @param zipFile 压缩后的ZIP文件
     */
    private static void doCompress(File srcFile, File zipFile) throws IOException {
        ZipOutputStream out = null;
        try {
            out = new ZipOutputStream(new FileOutputStream(zipFile));
            doCompress(srcFile, out);
        } catch (Exception e) {
            throw e;
        } finally {
            out.close();//记得关闭资源
        }
    }

    static void doCompress(String fileName, ZipOutputStream out) throws IOException {
        doCompress(new File(fileName), out);
    }

    private static void doCompress(File file, ZipOutputStream out) throws IOException {
        doCompress(file, out, "");
    }

    private static void doCompress(File inFile, ZipOutputStream out, String dir) throws IOException {
        if (inFile.isDirectory()) {
            File[] files = inFile.listFiles();
            if (files != null && files.length > 0) {
                for (File file : files) {
                    String name = inFile.getName();
                    if (!"".equals(dir)) {
                        name = dir + "/" + name;
                    }
                    ZipUtils.doCompress(file, out, name);
                }
            }
        } else {
            ZipUtils.doZip(inFile, out, dir);
        }
    }

    private static void doZip(File inFile, ZipOutputStream out, String dir) throws IOException {
        String entryName;
        if (!"".equals(dir)) {
            entryName = dir + "/" + inFile.getName();
        } else {
            entryName = inFile.getName();
        }
        ZipEntry entry = new ZipEntry(entryName);
        out.putNextEntry(entry);
        int len;
        byte[] buffer = new byte[1024];
        FileInputStream fis = new FileInputStream(inFile);
        while ((len = fis.read(buffer)) > 0) {
            out.write(buffer, 0, len);
            out.flush();
        }
        out.closeEntry();
        fis.close();
    }

//    /**
//     * 压缩 csv 文件成 zip，并提供下载
//     *
//     * @param filePath 要进行压缩的文件目录
//     * @param response      下载请求响应对象
//     */
//    public static void downloadZipFile(String filePath, HttpServletResponse response) {
//        File file = new File(filePath);
//        if (!file.exists()) {
//            log.error("file not exist.path={}", filePath);
//            return;
//        }
//        try(OutputStream os = response.getOutputStream()) {
//            response.reset();
//            response.setHeader("Content-Disposition", "attachment;filename=" + file.getName());
//            response.setContentType("application/octet-stream");
//            os.write(FileUtils.readFileToByteArray(file));
//        } catch (Exception e) {
//            log.error("download zip file error", e);
//        }
//    }
}
