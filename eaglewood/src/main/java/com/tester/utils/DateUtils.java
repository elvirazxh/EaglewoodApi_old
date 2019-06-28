package com.tester.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DurationFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类, 继承org.apache.commons.lang.time.DateUtils类
 */
public class DateUtils {
	protected static Logger logger = LoggerFactory.getLogger(DateUtils.class);
    public interface Pattern {
        String yyyyMMddHHmmss = "yyyyMMddHHmmss";
        String yyyyMMddHHmmssSSS = "yyyyMMddHHmmssSSS";
        String yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
        String yyMMddHHmmssSSS = "yyMMddHHmmssSSS";
        String yyMMddHHmmss = "yyMMddHHmmss";
        String yyyyMMdd = "yyyyMMdd";
        String yyyy_MM_dd = "yyyy-MM-dd";
        String HHmmss = "HHmmss";
    }

    /**
     * 得到当前日期字符串
     */
    public static String getDateStr(String pattern) {
        return DateFormatUtils.format(new Date(), pattern);
    }

    public static String getDateStr(Date date, String pattern) {
        if (date == null) {
            return null;
        }
        return DateFormatUtils.format(date, pattern);
    }

    public static String getDateStr(long millis, String pattern) {
        return DateFormatUtils.format(millis, pattern);
    }

    public static Date parseDate(String dateStr, String pattern) throws Exception {
        if (StringUtils.isBlank(dateStr)) {
            return null;
        }
        return org.apache.commons.lang3.time.DateUtils.parseDate(dateStr, pattern);
    }

    /**
     * @param dateStr
     * @param pattern
     * @param defaultDate
     * @return
     * @throws Exception
     */
    public static Date parseDateQuietly(String dateStr, String pattern, Date defaultDate) {
        if (StringUtils.isBlank(dateStr)) {
            return defaultDate;
        }

        try {
            Date date = org.apache.commons.lang3.time.DateUtils.parseDate(dateStr, pattern);
            if (date == null) {
                return defaultDate;
            }
            return date;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return defaultDate;
    }

    public static String convertDate(String dateStr, String fromPattern, String toPattern) throws Exception {
        if (StringUtils.isBlank(dateStr)) {
            return null;
        }
        return DateFormatUtils.format(org.apache.commons.lang3.time.DateUtils.parseDate(dateStr, fromPattern), toPattern);
    }

    /**
     * Timestamp 加减
     *
     * @param date
     * @param minute
     * @return
     */
    public static Date addMinutes(Date date, int minute) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minute);
        return calendar.getTime();
    }

    /**
     * 得到日期+i天后的日期
     *
     * @param d
     * @param i
     * @return
     */
    public static Date addDay(Date d, int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.add(Calendar.DATE, i);// 把日期往后增加一天.整数往后推,负数往前移动
        return calendar.getTime();// 这个时间就是日期往后推一天的结果
    }

    public static String date2Str(Date date, String format) {
        if (format == null || format.equals("")) {
            format = Pattern.yyyyMMddHHmmss;
        }

        if (null == date) {
            return "";
        }

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 日期间隔
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static int dateDayDiff(Date startDate, Date endDate) {
        if (endDate.compareTo(startDate) >= 0) {
            String diff = DurationFormatUtils.formatPeriod(startDate.getTime(), endDate.getTime(), "d");
            return Integer.parseInt(diff);
        } else {
            String diff = DurationFormatUtils.formatPeriod(endDate.getTime(), startDate.getTime(), "d");
            return -1 * Integer.parseInt(diff);
        }
    }

    /**
     * 分钟间隔
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static int dateMinuteDiff(Date startDate, Date endDate) {
        if (endDate.compareTo(startDate) >= 0) {
            String diff = DurationFormatUtils.formatPeriod(startDate.getTime(), endDate.getTime(), "m");
            return Integer.parseInt(diff);
        } else {
            String diff = DurationFormatUtils.formatPeriod(endDate.getTime(), startDate.getTime(), "m");
            return -1 * Integer.parseInt(diff);
        }
    }

    /**
     * 获取当天起始时间
     *
     * @return
     */
    public static Date getStartTime() {
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        today.set(Calendar.MILLISECOND, 0);
        return today.getTime();
    }

    public static Date getStartOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    public static void main(String[] args) throws Exception {
        Date date1 = new Date();
        Date date2 = DateUtils.addDay(date1, 100);
        date2 = DateUtils.addMinutes(date2, 10000);
        System.out.println(DateUtils.dateDayDiff(date1, date2));
        System.out.println(DateUtils.dateDayDiff(date2, date1));
        System.out.println(DateUtils.dateMinuteDiff(date1, date2));
        System.out.println(DateUtils.dateMinuteDiff(date2, date1));
        System.out.println(DateUtils.convertDate("20180901", "yyyyMMdd", "yyyyMMddHHmmss"));
        System.out.println(DateUtils.convertDate("20180901", "yyyyMMdd", "yyyyMMdd000000"));
        System.out.println(DateUtils.date2Str(new Date(), DateUtils.Pattern.yyyyMMddHHmmssSSS));
    }
}
