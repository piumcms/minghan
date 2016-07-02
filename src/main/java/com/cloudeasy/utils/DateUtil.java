package com.cloudeasy.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateUtil {
	public static final String DATE_SHORT_PATTERN = "yyyy-MM-dd";
	public static final String DATE__TIME_PATTERN = "yyyy-MM-dd HH:mm";
	public static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
	public static final String TIME_SHORT_PALLTTRN = "HH:mm";
	public static final String TIME_PATTERN = "HH:mm:ss";
	public static final String TIME_PATTERN_EN = "ddMMMyyyy";
	private static final String TIME_PATTERN_EN2 = "dd/MM/yyyy";
	public static final String EXCEL_EXPORT_PATTERN = "yyyyMMdd_HHmm";

	/**
	 * 获得当前日期
	 * @return
	 */
	public static Timestamp newDate() {
		SimpleDateFormat format = new SimpleDateFormat(DATE_PATTERN);
		String timesampDate = format.format(new Date());
		return Timestamp.valueOf(timesampDate);
	}

	public static String dateToStringEn2(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(TIME_PATTERN_EN2);
		return sdf.format(date);
	}

	/**
	 * 将时间格式时间转换为字符串 HH:mm:ss
	 * @param dateDate
	 * @return
	 */
	public static String dateToLongString(Date date) {
		SimpleDateFormat format = new SimpleDateFormat(TIME_PATTERN);
		String timesampDate = format.format(date);
		return timesampDate;
	}

	/**
	 * 将时间格式时间转换为字符串 HH:mm
	 * @param dateDate
	 * @return
	 */
	public static String dateToShortTime(Date date) {
		SimpleDateFormat format = new SimpleDateFormat(TIME_SHORT_PALLTTRN);
		String timesampDate = format.format(date);
		return timesampDate;
	}

	/**
	 * 将时间格式时间转换为字符串 yyyy-MM-dd HH:mm:ss
	 * @param dateDate
	 * @return
	 */
	public static String dateTimeToStrLong(Date date) {
		SimpleDateFormat format = new SimpleDateFormat(DATE_PATTERN);
		String timesampDate = format.format(date);
		return timesampDate;
	}

	/**
	 * 将时间格式时间转换为字符串 yyyy-MM-dd
	 * @param date
	 * @return
	 */
	public static String dateToStrShort(Date date) {
		SimpleDateFormat format = new SimpleDateFormat(DATE_SHORT_PATTERN);
		String timesampDate = format.format(date);
		return timesampDate;
	}

	/**
	 * 将时间格式时间转换为字符串 ddMMMyyyy（英文格式）
	 * @param date
	 * @return
	 */
	public static String dateToStrShortEn(Date date) {
		DateTime dateDate = DateUtil.dateToDateTime(date);
		return dateDate.toString(TIME_PATTERN_EN, Locale.ENGLISH);
	}

	/**
	 * 将时间格式时间转换成字符串yyyyMMdd_HHmm
	 * @param date
	 * @return
	 */
	public static String dateToExcelPattern(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(EXCEL_EXPORT_PATTERN);
		return sdf.format(date);
	}

	/**
	 * Date转DateTime
	 * @param dateDate
	 * @return
	 */
	public static DateTime dateToDateTime(Date date) {
		return new DateTime(date);
	}

	/**
	 * Date转Timestamp
	 * @param date
	 * @return
	 */
	public static Timestamp dateToTimestamp(Date date) {
		return new Timestamp(date.getTime());
	}

	/**
	 * 将timestamp转换成date
	 * @param timestamp
	 * @return
	 */
	public static Date timestampToDate(Timestamp timestamp) {
		return new Date(timestamp.getTime());
	}

	/**
	 * 将字符串转换为Date日期
	 * @param strDate---被转换日期
	 * @param strInPattern----日期样式
	 * @return
	 */
	public static Date strToDate(String strDate, String strInPattern) {
		DateTimeFormatter formatter = DateTimeFormat.forPattern(strInPattern);
		DateTime result = formatter.parseDateTime(strDate);
		return result.toDate();
	}

	/**
	 * 将指定日期与指定格式转换成字符串形式
	 * @param date---被转换日期
	 * @param strInPattern----日期样式
	 * @return
	 */
	public static String dateToStr(Date date, String strInPattern) {
		try {
			if (null == date || StringUtils.isBlank(strInPattern)) {
				return "";
			} else {
				SimpleDateFormat sdf = new SimpleDateFormat(strInPattern);
				return sdf.format(date);
			}
		} catch (Exception e) {
			return "";
		}
	}
	
	 //获取当前月第一天：
	public static String getMonthFirstDay(){
		SimpleDateFormat format = new SimpleDateFormat(DATE_SHORT_PATTERN);
		Calendar c = Calendar.getInstance();   
	    c.add(Calendar.MONTH, 0);
	    c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
	    String first = format.format(c.getTime());
	    System.out.println("===============first:"+first);
	    return first;
	}
	
	//获取当前月最后一天
	public static String getMonthLastDay(){
		SimpleDateFormat format = new SimpleDateFormat(DATE_SHORT_PATTERN);
		Calendar c = Calendar.getInstance();   
	    c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH)); 
		String last = format.format(c.getTime());
	    System.out.println("===============last:"+last);
	    return last;
	}

	/**
	 * 获取JSON中DateTime格式时间
	 */
	public static Date getDate(String Time) {
		if (StringUtils.isNotBlank(Time)) {
			Time = Time.replaceAll("T", " ");
			return DateUtil.strToDate(Time, "yyyy-MM-dd HH:mm");
		} else {
			return null;
		}
	}

	/**
	 * 日期加一天
	 * @param date
	 * @return
	 */
	public static Date addOneDay(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_YEAR, 1);
		return c.getTime();
	}

	public static Date getBeforeDay(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, -1);
		return c.getTime();
	}

	public static Date getAfterDay(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, 1);
		return c.getTime();
	}

	/**
	 * 日期加整数天
	 * @param date
	 * @param Day
	 * @return
	 */
	public static Date setDay(Date date, int Day) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, Day);
		return c.getTime();
	}

	/**
	 * 日期减一天
	 * @param date
	 * @return
	 */
	public static Date minusOneDay(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_YEAR, -1);
		return c.getTime();
	}

	/**
	 * <p>Description: 日期减一年减一天</p>
	 * @param date
	 * @return
	 */
	public static Date minusYearAddDay(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.YEAR, -1);
		c.add(Calendar.DATE, -1);
		return c.getTime();
	}

	/**
	 * <p>Description: 日期减N年减N月减N天</p>
	 * <p>不增不减参数传递0</p>
	 * <p>例如：减一天传递-1，增加一天传递1</p>
	 * @param date
	 * @return
	 */
	public static Date adjustYearAndMonthAndDay(Date date, int year, int month, int day) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.YEAR, year);
		c.add(Calendar.MONTH, month);
		c.add(Calendar.DATE, day);
		return c.getTime();
	}

	/**
	 * <p>Description: 日期减一个月</p>
	 * @param date
	 * @return
	 */
	public static Date minusMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, -1);
		return c.getTime();
	}

	/**
	 * 增加多少个小时后的日期
	 * @param date
	 * @param hours
	 * @return
	 */
	public static Date addHoursDate(Date date, int hours) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.HOUR, hours);
		return c.getTime();
	}

	/**
	 * 增减分钟后的日期
	 * @param date
	 * @param minute
	 * @return
	 */
	public static Date addMinuteDate(Date date, int minute) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MINUTE, minute);
		return c.getTime();
	}

	public static Date getDate(int year, int month, int days, int hour, int minute, int seconds) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		if (year > 0) {
			calendar.set(Calendar.YEAR, year);
		}
		if (month != 0) {
			calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + month);
		}

		if (days != 0) {
			calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + days);
		}

		if (hour > 0) {
			calendar.set(Calendar.HOUR_OF_DAY, hour);
		}

		if (minute > 0) {
			calendar.set(Calendar.MINUTE, minute);
		} else {
			calendar.set(Calendar.MINUTE, 0);
		}

		if (seconds > 0) {
			calendar.set(Calendar.SECOND, seconds);
		} else {
			calendar.set(Calendar.SECOND, 0);
		}
		return calendar.getTime();
	}

	public static Date getDate(Date cDate, int year, int month, int days, int hour, int minute, int seconds) {
		Calendar calendar = Calendar.getInstance();
		if (null != cDate) {
			calendar.setTime(cDate);
		} else {
			calendar.setTime(new Date());
		}

		if (year > 0) {
			calendar.set(Calendar.YEAR, year);
		}

		if (month > 0) {
			calendar.set(Calendar.MONTH, month);
		}

		if (days != 0) {
			calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + days);
		}

		if (hour >= 0) {
			calendar.set(Calendar.HOUR_OF_DAY, hour);
		}

		if (minute >= 0) {
			calendar.set(Calendar.MINUTE, minute);
		}

		if (seconds >= 0) {
			calendar.set(Calendar.SECOND, seconds);
		}

		return calendar.getTime();
	}

	/**
	 * 12月3号7点到12月4号7点之间的时间段，返回3号的日期。。然后按需处理
	 * @return
	 */
	public static Date getWorkDate() {
		Calendar rightNow = Calendar.getInstance();
		int hour = rightNow.get(Calendar.HOUR_OF_DAY);
		int minute = rightNow.get(Calendar.MINUTE);
		if (hour < 7 || (hour == 7 && minute == 0)) {
			rightNow.add(Calendar.DATE, -1);
		}
		return rightNow.getTime();
	}

}