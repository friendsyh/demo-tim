package com.tim.common.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import lombok.Data;

/**
 * 配置文件读取工具
 * @author tim.syh
 *
 */
@Data
public class PropertiesUtil {

    private Properties propertie;
    private InputStream inputFile;

    public PropertiesUtil(String filePath) {
        propertie = new Properties();
        try {
            inputFile = getClass().getResourceAsStream(filePath);
            propertie.load(inputFile);
            inputFile.close();
        } catch (FileNotFoundException ex) {
            System.out.println("读取属性文件--->失败！- 原因：文件路径错误或者文件不存在");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("装载文件--->失败!");
            ex.printStackTrace();
        }
    }

    /**
     * 重载函数，得到key的值
     *
     * @param key 取得其值的键
     * @return key的值
     */
    public String getValue(String key) {
        if (propertie.containsKey(key)) {
            String value = propertie.getProperty(key);// 得到某一属性的值
            try {
                return null == value ? null : new String(value.getBytes("ISO8859-1"), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 重载函数，得到key的值
     *
     * @param fileName properties文件的路径+文件名
     * @param key      取得其值的键
     * @return key的值
     */
    public String getValue(String fileName, String key) {
        try {
            String value = "";
            inputFile = getClass().getResourceAsStream(fileName);
            propertie.load(inputFile);
            inputFile.close();

            if (propertie.containsKey(key)) {
                value = propertie.getProperty(key);
                return value;
            } else {
                return value;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "";
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }

    /**
     * 根据指定资源路径加载单个资源文件,返回Properties类对象的引用。 若有异常产生,则Properties类对象为空。
     *
     * @param filePath 资源文件的路径的值
     * @return 给定资源文件所对应的Properties类对象的引用
     */
    private Properties loadPropertiesFile(String filePath) {
        Properties properties = new Properties();
        InputStream is = null;
        try {
            try {
                is = new FileInputStream(filePath);
                properties.load(is);
            } finally {
                if (is != null) {
                    is.close();
                    is = null;
                }
            }
        } catch (Exception e) {
            properties = null;
        }
        return properties;

    }
}
