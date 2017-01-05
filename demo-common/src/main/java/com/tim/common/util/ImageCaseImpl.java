package com.tim.common.util;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

/***
 * @author pfzeng
 * 图片处理实现类
 */
public class ImageCaseImpl implements ImageCase {

	public File compressionImage(File formerFile, double minification)throws Exception{
		BufferedImage dstImage = null;  
		File file=null;
		long num = System.currentTimeMillis() + new Random().nextInt(1000);
        BufferedImage sourceImage = ImageIO.read(formerFile);  
       
        AffineTransform transform = AffineTransform.getScaleInstance(minification, minification);
        AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);   
        dstImage = op.filter(sourceImage, null);   
        String counxt= formerFile.getAbsolutePath();
        String filePath=counxt.substring(0,counxt.lastIndexOf(File.separator)+1);
              
        String fileformat=counxt.substring(counxt.lastIndexOf("."),counxt.length());
        file=new File(filePath+num+fileformat);
	        try {   
	        	
	            ImageIO.write(dstImage, "png", file);   
	        	} catch (IOException e) {   
	            e.printStackTrace();   
	        }   
		return file;
	}

	/****
	 * 判断Image是否符合规格
	 * 
	 * @param fileArray
	 * @param size
	 * @return
	 */
	public  boolean isStandard(File fileArray, int width , int height ) {
		boolean bool = false;
		BufferedImage src;
		int imgeWidth = 0;
		int imgeHeight = 0;
		try {
			// 将File转换成IMGE判断其大小
			src = ImageIO.read(fileArray.getAbsoluteFile());
			imgeWidth = src.getWidth();
			imgeHeight = src.getHeight();
			if (imgeWidth == width && imgeHeight == height) {
				bool = true;
			}
		} catch (Exception e) {
			return bool;
		}
		return bool;
	}
	
	public static void main(String args[]){
		ImageCase imge=new ImageCaseImpl();
		try {
			imge.compressionImage(new File("D://20090413084130535.png"), 0.25);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
