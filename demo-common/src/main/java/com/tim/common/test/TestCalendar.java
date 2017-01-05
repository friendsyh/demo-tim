package com.tim.common.test;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import com.tim.common.util.DateUtil;

public class TestCalendar {

	
	public int getDaysOfMonth(String year, String month) {
		/* Checking */
		if (year == null || year.trim().length() == 0) {
			return 0;
		}
		
		if (month == null || month.trim().length() == 0) {
			return 0;
		}
		
		/* Days of a month */
		Calendar c = Calendar.getInstance();
		c.set(new Integer(year), new Integer(month) - 1, 1, 0, 0, 0);
		Date date = c.getTime();
		System.out.println(date);
		int daysOfMonth = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		return daysOfMonth;
	}
	
	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
//		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
//		Date date = formatter.parse("03/23/2014");
		System.out.println(new TestCalendar().getDaysOfMonth("2016", "02"));
		System.out.println("-----------------------another part----------------------");
		
		Calendar calendar = Calendar.getInstance();
		int year = 2014;
		int month = 2;
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1);
		System.out.println("the total day is : " + calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
//		calendar.get(Calendar.MONTH) == calendar.get(Calendar.MONTH)
//		int weekCount = calendar.getActualMaximum(Calendar.WEEK_OF_MONTH);
//		System.out.println("max week count : " + weekCount);
		int weekCount = 1;
		calendar.set(Calendar.WEEK_OF_MONTH, weekCount);
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		while(weekCount > 0){
			String sunStri = "";
			sunStri = DateUtil.convertDateToString(calendar.getTime(), DateUtil.TIMEF_FORMAT);
			calendar.add(Calendar.DAY_OF_MONTH, 6);
			sunStri += "-" + DateUtil.convertDateToString(calendar.getTime(), DateUtil.TIMEF_FORMAT);
			System.out.println(sunStri);
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			if(calendar.get(Calendar.MONTH) > month - 1){
				break;
			}
		}
		
//		System.out.println(calendar.get(Calendar.MONTH));
//		calendar.setTime(date);

		// 把日期设置为当月第一天
//		calendar.set(Calendar.DATE, 1);
		
		// 日期回滚一天，也就是最后一天
//		calendar.roll(Calendar.DATE, -1);
		
//		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
//		System.out.println(calendar.getTime());
//		for(int i = 1;i <= weekCount;i++){
//			Calendar cWeek = Calendar.getInstance();
//			cWeek.set(Calendar.YEAR, year);
//			cWeek.set(Calendar.MONTH, month -1);
//			cWeek.set(Calendar.WEEK_OF_MONTH,i);
//			for(int j = Calendar.SUNDAY; j <= Calendar.SATURDAY; j++){
//				System.out.println(cWeek.get(Calendar.DAY_OF_MONTH));
//				cWeek.add(Calendar.DAY_OF_MONTH, 1);
//			}
//			System.out.println("--------");
//		}
	
//		int days = calendar.get(Calendar.DAY_OF_WEEK);
//		System.out.println(days);
	}

}
