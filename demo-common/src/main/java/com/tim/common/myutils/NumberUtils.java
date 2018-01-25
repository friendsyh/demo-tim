package com.tim.common.myutils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;


public class NumberUtils {
	
	private final static BigDecimal TEN_THOUSAND =new BigDecimal(10000);

	/**
	 * Long类型转数字。
	 *
	 */
	public static long num(Long data){
		if(data==null){
			return 0;
		}
		return data;
	}

	/**
	 * Integer类型转数字。
	 *
	 */
	public static int num(Integer data){
		if(data==null){
			return 0;
		}
		return data;
	}

	/**
	 * 金额单位转换
	 *
	 * @return
	 * @创建人 何源
	 * @创建时间 2016年9月13日下午4:45:57
	 *
	 */
	public static BigDecimal hao2yuan(Long amount){
        if (amount == null)
            amount = 0L;

        return new BigDecimal(amount).divide(new BigDecimal(10000));
	}

    public static Long hao2yuanHalfup(Long amount){
        if (amount == null)
            amount = 0L;

        return BigDecimalUtil.halfup(new BigDecimal(new Double(amount)/10000).longValue(), 2);
    }

	/**
	 * 金额单位转换,格式化字符串
	 *
	 * @return
	 * @创建人 何源
	 * @创建时间 2016年9月13日下午4:45:57
	 *
	 */
	public static String hao2yuanString(Long amount){
        if (amount == null)
            amount = 0L;
		BigDecimal data = new BigDecimal(new Double(amount)/10000);
		DecimalFormat df = new DecimalFormat("0.00");
		df.setRoundingMode(RoundingMode.HALF_UP);
		return df.format(data);
	}

    /**
     * 单位转换, 四舍五入,保留两位小数
     * @param amount
     * @return
     */
    public static String hao2yuanHalfupString(Long amount){
        if (amount == null) {
            amount = 0L;
        }

        BigDecimal data = new BigDecimal(new Double(amount)/10000);
        return String.valueOf(BigDecimalUtil.formate(data));
    }

    public static void main(String[] args) {
        System.out.println(hao2yuan(Long.valueOf(1744100L)).toString());
        System.out.println(hao2yuanHalfup(Long.valueOf(1744100L)).toString());

        String shouldBack = new Double(1768.61d).toString();

        String amount = new Double(1744.19d).toString();
        String serviceFee = new Double(18.31d).toString();
        String profit = new Double(6.10d).toString();
        String overdueFee = new Double(0.00d).toString();
        System.out.println("shouldBack=" + shouldBack + "(amount=" + amount + " serviceFee=" + serviceFee + " profit=" + profit + " overDue=" + overdueFee);

        Double result = new Double(shouldBack) - new Double(amount) - new Double(serviceFee);
        BigDecimal result1 = new BigDecimal(shouldBack).subtract(new BigDecimal(amount)).subtract(new BigDecimal(serviceFee));
        System.out.println(result.toString());
        System.out.println(result1.setScale(2).toString());
    }

}
