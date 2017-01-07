package com.tim.common.myutils;

import java.math.BigDecimal;

public class SizeUtil {
	/**  
     * 对double数据进行取精度.  
     * @param value  double数据.  
     * @param scale  精度位数(保留的小数位数).  
     * @param roundingMode  精度取值方式.  
     * @return 精度计算后的数据.  
     */  
	 public static double round(Float value, int scale, 
             int roundingMode) {   
        BigDecimal bd = new BigDecimal(value);   
        bd = bd.setScale(scale, roundingMode);   
        double d = bd.doubleValue();   
        bd = null;   
        return d;   
    }  

	public static void main(String[] args) {
		Float number = new Float(0f);
		System.out.println(round(number, 2, BigDecimal.ROUND_HALF_UP));
	}
}
