package com.tim.common.myutils;

import java.io.File;

/**
 * 图片处理公共接口
 * @author pfzeng
 *
 */
public interface ImageCase {
	/***
	 * 图片压缩 
	 * @param formerFile  原文件
	 * @param minification  缩放倍率
	 * @return
	 */
	File compressionImage(File formerFile,double minification) throws Exception;
	
	
	/***
	 * 判断图片是否符合规格
	 * @param fileArray
	 * @param width
	 * @param height
	 * @return
	 */
	 boolean isStandard(File fileArray, int width , int height);

}
