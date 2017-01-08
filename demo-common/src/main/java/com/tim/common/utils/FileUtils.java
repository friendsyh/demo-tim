package com.tim.common.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * 文件的公共类
 * Created by tim.syh on 2017/1/8.
 */
public class FileUtils {

    private FileUtils(){
    }

    /**
     * 根据路径获取文件的名称
     * 比如传入/home/admin/test.txt  返回test.txt
     * @param path
     * @return
     */
    public static String getFileNameByPath(final String path){
        if(StringUtils.isEmpty(path)){
            return "";
        }
        return path.substring(path.lastIndexOf("/") + 1, path.length());
    }
}
