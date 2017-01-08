package com.tim.common.utils;

import com.tim.common.myutils.StringMyUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;



public class DateUtils {
	
	/** YYYYMMDD */
	public static final String SIMPLE_DATE_FOMAT = "yyyyMMdd";
	
	/**
	 * 显示日期的格式,yyyy-MM-dd
	 */
	public static final String DATE_FORMAT = "yyyy-MM-dd";

	/**
	 * 显示日期的格式,yyyy-MM-dd HH:mm:ss
	 */
	public static final String TIMEF_FORMAT = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 显示日期的格式,yyyy年MM月dd日
	 */
	public static final String DATECH_TIME_FORMAT = "yyyy年MM月dd日";
	
	/**
	 * 显示日期的格式,yyyy年MM月dd日HH时mm分ss秒
	 */
	public static final String ZHCN_TIME_FORMAT = "yyyy年MM月dd日HH时mm分ss秒";

	/**
	 * 显示日期的格式,yyyyMMddHHmmss
	 */
	public static final String TIME_STR_FORMAT = "yyyyMMddHHmmss";
	/**
	 * 显示日期的格式,yyyyMMddHHmmssSSS
	 */
	public static final String TIMESSS_STR_FORMAT = "yyyyMMddHHmmssSSS";

	/**
	 * 显示日期的格式,yyyy-MM-dd HH:mm:ss.SSS
	 */
	public static final String TIMESSS_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
	
	
	/**
	 * "2012年03月16日"转换"20120316"
	 */
	public static String dateFormat(String oldDate){
		if(StringMyUtils.isEmpty(oldDate))
			return null;
		else
			return oldDate.substring(0, 4)+oldDate.substring(5, 7)+oldDate.substring(8, 10);
	}
	/**
	 * "2012年第9周"转换"201209"
	 */
	public static String weekFormat(String oldWeek){
		if(StringMyUtils.isEmpty(oldWeek))
			return null;
		else {
			String year = oldWeek.substring(0, 4);
			String week = null;
			if(oldWeek.length()==8){
				week ="0" + oldWeek.substring(6, 7);
			}else{
				week = oldWeek.substring(6, 8);
			}
			return year+week;
		}
	}
	/**
	 * "2012年04月"转换"201204"
	 */
	public static String monthFormat(String oldMonth){
		if(StringMyUtils.isEmpty(oldMonth))
			return null;
		else
			return oldMonth.substring(0, 4)+oldMonth.substring(5, 7);
	}
	
	/**
	 * "201204"转换"2012年04月"
	 */
	public static String un_weekFormat(String oldMonth){
		if(StringMyUtils.isEmpty(oldMonth))
			return null;
		else{
			return oldMonth.substring(0, 4)+"年第"+Integer.parseInt(oldMonth.substring(4, 6))+"周";
		}
			
	}
	
	/**
	 * "201204"转换"2012年04月"
	 */
	public static String un_monthFormat(String oldMonth){
		if(StringMyUtils.isEmpty(oldMonth))
			return null;
		else{
			return oldMonth.substring(0, 4)+"年第"+oldMonth.substring(4, 6)+"月";
		}
			
	}
	
	/**
	 * 将yyyymmdd形式的字符串转换成Date的形式

	 *
	 * @param date
	 *            yyyymmdd形式的日期字符串
	 * @return Date对象
	 * @throws ParseException
	 */
	public static Date convertStrToDate(String date) throws ParseException {
		return new SimpleDateFormat(SIMPLE_DATE_FOMAT).parse(date);
	}
	
	/**
	 * 将yyyymmdd形式的字符串转换成Date的形式

	 *
	 *            yyyymmdd形式的日期字符串
	 * @return Date对象
	 * @throws ParseException
	 */
	public static Date convertStrToDate(String dateStr, String format) throws ParseException {
		return new SimpleDateFormat(format).parse(dateStr);
	}
	
	/**
	 * 将Date转换为yyMMddHHmmss的形式
	 * @param date
	 * @return 日期的字符串形式,格式：yyMMddHHmmss
	 */
	public static String convertDateToString(Date date, String formatStr) {
		return new SimpleDateFormat(formatStr).format(date);
	}
	
	/**
	 * 将String的日期转换为指定格式的日期STRING
	 * @return 日期的字符串形式
	 */
	public static String convertDateStrToStr(String dateStr, String oldFormat, String newFormat) throws ParseException {
		return convertDateToString(convertStrToDate(dateStr, oldFormat), newFormat);
	}
	
	/**
	 * 根据原来的时间（Date）获得当前周的开始日期
	 * 
	 * @param protoDate 原来的时间（java.com.tim.common.util.Date）
	 * @param formatStr 时间格式
	 * 
	 * @return 时间（java.com.tim.common.util.Date），没有时分秒
	 */
	public static String getFirstDayOfWeek(Date protoDate, String formatStr){
		Calendar cal = Calendar.getInstance();
		cal.setTime(protoDate);
		cal.set(Calendar.DAY_OF_WEEK, cal.getActualMinimum(Calendar.DAY_OF_WEEK));
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		return sdf.format(cal.getTime());
	}

	
	/**
	 * 根据原来的时间（Date）获得当前周的结束日期
	 * 
	 * @param protoDate 原来的时间（java.com.tim.common.util.Date）
	 * @param formatStr 时间格式
	 * 
	 * @return 时间（java.com.tim.common.util.Date），没有时分秒
	 */
	public static String getLastDayOfWeek(Date protoDate, String formatStr){
		Calendar cal = Calendar.getInstance();
		cal.setTime(protoDate);
		cal.set(Calendar.DAY_OF_WEEK, cal.getActualMaximum(Calendar.DAY_OF_WEEK));
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		return sdf.format(cal.getTime());
	}
	
	
	/**
	 * 得到某年某周的最后一天
	 * 注意周的顺序是：周日开始至周六结束
	 * 
	 * @param year
	 * @param week
	 * @return
	 */
	public static Date DateOfWeek(int year, int week) {
		Calendar c = new GregorianCalendar();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, Calendar.JANUARY);
		c.set(Calendar.DATE, 0);

		Calendar cal = (GregorianCalendar) c.clone();
		cal.add(Calendar.DATE, week * 7);

		return cal.getTime();
	}
	
	/**
	 * 根据原来的时间（Date）获得相对偏移 N 天的时间（Date）


	 * @param protoDate 原来的时间（java.com.tim.common.util.Date）


	 * @param dateOffset（向前移正数，向后移负数）

	 * @return 时间（java.com.tim.common.util.Date），没有时分秒


	 */
	public static Date getOffsetSimpleDate(Date protoDate,int dateOffset){
		Calendar cal = Calendar.getInstance();
		cal.setTime(protoDate);
//		cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) - dateOffset);
		cal.add(Calendar.DAY_OF_MONTH, dateOffset);
		return cal.getTime();
	}

	/**
	 * 根据原来的时间（String）获得相对偏移 N 天的时间（String）
	 * @param protoStr		输入时间
	 * @param dateOffset	dateOffset（向前移正数，向后移负数）
	 * @param format		格式化类型
	 * @return
	 * @throws ParseException
	 */
	public static String getOffsetSimpleDate(String protoStr, int dateOffset, String format) throws ParseException {

		Calendar cal = Calendar.getInstance();
		cal.setTime(convertStrToDate(protoStr, format));
		cal.add(Calendar.DAY_OF_MONTH, dateOffset);
		return convertDateToString(cal.getTime(), format);
		
	}
	
	/**
	 * 根据原来的时间（Date）获得相对偏移 N 小时的时间（Date）

	 * @param protoDate 原来的时间（java.com.tim.common.util.Date）

	 * @param offsetHour （向前移正数，向后移负数）

	 * @return 时间（java.com.tim.common.util.Date）

	 */
	public static Date getOffsetHourDate(Date protoDate,int offsetHour){
		Calendar cal = Calendar.getInstance();
		cal.setTime(protoDate);
		cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY) - offsetHour);
		return cal.getTime();
	}
	
	
	/**
	 * 根据原来的时间（protoStr）获得相对偏移  dateOffset 周的时间 格式为 yyyyWW
	 * @param protoStr ,格式为yyyyWW
	 * @param dateOffset 正数为往后偏移，负数为向前偏移
	 * @return yyyyWW
	 * @throws ParseException
	 */
	public static String getOffsetWeek(String protoStr, int dateOffset) throws ParseException{
		Calendar calendar = Calendar.getInstance();
	    calendar.setTime(DateOfWeek(Integer.parseInt(protoStr.substring(0, 4)),Integer.parseInt(protoStr.substring(4))));
	    calendar.add(Calendar.WEEK_OF_YEAR, dateOffset);    
	    int year = calendar.get(Calendar.YEAR);
	    int week = calendar.get(Calendar.WEEK_OF_YEAR);
	    return ""+year+ (week >=10 ? week : "0" + week);
	}
	
	/**
	 * 根据原来的时间（protoStr）获得相对偏移  dateOffset 月的时间 格式为 yyyyMM
	 * @param protoStr,格式为yyyyMM
	 * @param dateOffset 正数为往后偏移，负数为向前偏移
	 * @return 格式为yyyyMM
	 * @throws ParseException
	 */
	public static String getOffsetMonth(String protoStr, int dateOffset) throws ParseException{
		Calendar calendar = Calendar.getInstance();
	    calendar.setTime(convertStrToDate(protoStr+"01")); //以每月1号为时间进行计算
	    calendar.add(Calendar.MONTH, dateOffset);    
	    int year = calendar.get(Calendar.YEAR);
	    int month = calendar.get(Calendar.MONTH)+1;
	    return ""+year+(month >=10 ? month : "0" + month);
	}
	/**
	 * 计算 两个日期之间的 天数 
	 * @param t1
	 * @param t2
	 * @param strformat
	 * @return
	 * @throws Exception
	 */
	public	static int getBetweenDays(String t1, String t2,String strformat) throws Exception {  
		  SimpleDateFormat format = new SimpleDateFormat(strformat);  
	   int betweenDays = 0;  
	   Date d1 = format.parse(t1);  
	   Date d2 = format.parse(t2);  
	   Calendar c1 = Calendar.getInstance();  
	  Calendar c2 = Calendar.getInstance();  
		    c1.setTime(d1);  
		   c2.setTime(d2);  
	   // 保证第二个时间一定大于第一个时间  
		    if (c1.after(c2)) {  
	          c1 = c2;  
	          c2.setTime(d1);  
		   }  
		    int betweenYears = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);  
		  betweenDays = c2.get(Calendar.DAY_OF_YEAR) - c1.get(Calendar.DAY_OF_YEAR);  
		    for (int i = 0; i < betweenYears; i++) {  
		       c1.set(Calendar.YEAR, (c1.get(Calendar.YEAR) + 1));  
		        betweenDays += c1.getMaximum(Calendar.DAY_OF_YEAR);  
		   }  
		   return betweenDays;  
	}  

	public static void main(String[] args) throws Exception{
		/*System.out.println(DateOfWeek(2012, 10));//20120304
		System.out.println(getFirstDayOfWeek(DateOfWeek(2012, 10),DATE_FORMAT));
		System.out.println(getLastDayOfWeek(DateOfWeek(2012, 10),DATE_FORMAT));*/
//		 Calendar now = Calendar.getInstance();
//		  int week = now.get(Calendar.WEEK_OF_YEAR);
//		  int day = now.get(Calendar.DAY_OF_WEEK);
//		  System.out.println(now.get(Calendar.DAY_OF_WEEK));
//		  System.out.println(week);
//		  now.add(Calendar.WEEK_OF_YEAR, 1);
//		  //System.out.println(now.get(Calendar.) + "day" + (now.get(Calendar.MONTH) + 1) + "month");
//		  now.add(Calendar.DAY_OF_WEEK, 1 - day);
//		  System.out.println("start date: " + now.get(Calendar.DAY_OF_MONTH) + "day" + (now.get(Calendar.MONTH) + 1) + "month");
//		  now.add(Calendar.DAY_OF_WEEK, 6);
//		  System.out.println("end date: " + now.get(Calendar.DAY_OF_MONTH) + "day" + (now.get(Calendar.MONTH) + 1) + "month");
		 
		 System.out.println(getBetweenDays("20120521","20120917","yyyyMMdd"));
	}
}
