package com.gzq.yiyuan.utils;


import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 日期工具类
 *
 * @author wang_zhongpei
 * @function SSI框架组件
 */
public class DateUtil {
    /**
     * 默认日期分割字符
     */
    private static final String DEFAULT_DATE_DELIMITERS = "-";

    /**
     * 默认时间分割字符
     */
    private static final String DEFAULT_HOUR_DELIMITERS = ":";

    /**
     * 默认的完整日期字符串Formatter
     */
    private static ThreadLocal<DateFormat> threadLocalDefault = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    /**
     * 默认的日期Formatter
     */
    private static ThreadLocal<DateFormat> threadLocalDate = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    /**
     * 默认的时间Formatter
     */
    private static ThreadLocal<DateFormat> threadLocalHour = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("hh:mm:ss");
        }
    };

    /**
     * 默认构造方法
     */
    private DateUtil() {
    }

    /**
     * 根据"yyyy-MM-dd"格式的字符串，解析得到日期对象
     *
     * @param date "yyyy-MM-dd"格式的日期字符串
     * @return 日期对象
     * @throws ParseException 当日期字符串格式不匹配时抛出
     */
    public static Date parseStringToDate(String date) throws ParseException {
        return parseStringToDate(date, DEFAULT_DATE_DELIMITERS);
    }

    /**
     * 根据分隔符，拼接日期格式字符串后，解析得到日期对象
     *
     * @param date           "yyyy?MM?dd"格式的日期字符串，其中问号为dateDelimiters参数
     * @param dateDelimiters 用于分割年月日的字符串
     * @return 日期对象
     * @throws ParseException 当日期字符串格式不匹配时抛出
     */
    public static Date parseStringToDate(String date, String dateDelimiters) throws ParseException {
        StringBuilder sb = new StringBuilder();
        sb.append("yyyy").append(dateDelimiters).append("MM").append(dateDelimiters).append("dd");
        return getDateByPattern(date, sb.toString());
    }

    /**
     * 根据"hh:mm:ss"格式的字符串，解析得到日期对象
     *
     * @param date "hh:mm:ss"格式的日期字符串
     * @return 日期对象
     * @throws ParseException 当日期字符串格式不匹配时抛出
     */
    public static Date parseStringToHour(String date) throws ParseException {
        return parseStringToHour(date, DEFAULT_HOUR_DELIMITERS);
    }

    /**
     * 根据分隔符，拼接日期格式字符串后，解析得到日期对象
     *
     * @param date           "hh?mm?ss"格式的日期字符串，其中问号为dateDelimiters参数
     * @param dateDelimiters 用于分割年月日的字符串
     * @return 日期对象
     * @throws ParseException 当日期字符串格式不匹配时抛出
     */
    public static Date parseStringToHour(String date, String dateDelimiters) throws ParseException {
        StringBuilder sb = new StringBuilder();
        sb.append("hh").append(dateDelimiters).append("mm").append(dateDelimiters).append("ss");
        return getDateByPattern(date, sb.toString());
    }

    /**
     * 根据给定的表达式解析字符串，得到日期对象
     *
     * @param date    源日期格式字符串
     * @param pattern 解析表达式，如"yyyy-MM-dd" 或 "hh:mm:ss"
     * @return 日期对象
     * @throws ParseException 当字符串格式与表达式解析字符串不匹配时抛出
     */
    public static Date getDateByPattern(String date, String pattern) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.parse(date);
    }

    /**
     * 按照默认的"yyyy-MM-dd hh:mm:ss"格式化字符串
     *
     * @param date 源日期格式字符串
     * @return 日期对象
     * @throws ParseException 当字符串不符合"yyyy-MM-dd hh:mm:ss"格式时时抛出
     */
    public static Date getDate(String date) throws ParseException {
        return threadLocalDefault.get().parse(date);
    }

    /**
     * 将日期对象按照"yyyy-MM-dd"格式输出为字符串
     *
     * @param date 日期格式对象
     * @return 格式化后的字符串
     */
    public static String parseDateToString(Date date) {
        return parseDateToString(date, DEFAULT_DATE_DELIMITERS);
    }

    /**
     * 将日期对象按照"yyyy?MM?dd"格式输出为字符串
     *
     * @param date           日期格式对象
     * @param dateDelimiters 分割字符串
     * @return 格式化后的字符串
     */
    public static String parseDateToString(Date date, String dateDelimiters) {
        StringBuilder sb = new StringBuilder();
        sb.append("yyyy").append(dateDelimiters).append("MM").append(dateDelimiters).append("dd");
        return getStringByPattern(date, sb.toString());
    }

    /**
     * 根据给定的格式解析日期，得到字符串
     *
     * @param date    日期格式对象
     * @param pattern 解析表达式，如"yyyy-MM-dd" 或 "hh:mm:ss"
     * @return 格式化后的字符串
     */
    public static String getStringByPattern(Date date, String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(date);
    }

    /**
     * 根据给定的格式解析日期，得到字符串
     *
     * @param pattern 解析表达式，如"yyyy-MM-dd" 或 "hh:mm:ss"
     * @return 格式化后的字符串
     */
    public static String getStringByPattern(String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(new Date());
    }

    /**
     * 根据给定的格式解析日期，得到字符串
     *
     * @return 格式化后的字符串
     */
    public static String getStringByYYYYMMDD() {
        return getStringByPattern("yyyyMMdd");
    }

    /**
     * 获得当前年
     */
    public static String getCurrentYear() {
        return getDateList()[0];
    }

    /**
     * 获得当前月份
     */
    public static String getCurrentMonth() {
        return getDateList()[1];
    }

    private static String[] getDateList() {
        return getDate().split(DEFAULT_DATE_DELIMITERS);
    }

    public static String getDate() {
        return formatDate(new Date(), "yyyy-MM-dd");
    }


    /**
     * 将给定的日期格式化为"yyyy-MM-dd hh:mm:ss"格式的字符串
     *
     * @param date 源日期对象
     * @return 格式化后的字符串
     */
    public static String getString(Date date) {
        return threadLocalDefault.get().format(date);
    }

    /**
     * 获得日期的Map对象
     *
     * @param date 日期字符串
     * @return 包含了年月日、时分秒，以及全格式日期对象的Map对象
     * @throws ParseException 解析方法错误时，抛出该异常
     */
    public static Map<String, Date> getDateMap(String date) throws ParseException {
        Map<String, Date> dateMap = new HashMap<String, Date>();
        Date days = threadLocalDate.get().parse(date);
        Date hours = threadLocalHour.get().parse(date);
        Date fullDate = threadLocalDefault.get().parse(date);
        dateMap.put("__days", days);
        dateMap.put("__hours", hours);
        dateMap.put("__fullDate", fullDate);
        return dateMap;
    }

    /**
     * 获得日期的Map对象
     *
     * @param date 日期对象
     * @return 包含了年月日、时分秒，以及全格式字符串的Map对象
     */
    public static Map<String, String> getStringMap(String date) {
        Map<String, String> dateMap = new HashMap<String, String>();
        String days = threadLocalDate.get().format(date);
        String hours = threadLocalHour.get().format(date);
        String fullDate = threadLocalDefault.get().format(date);
        dateMap.put("__days", days);
        dateMap.put("__hours", hours);
        dateMap.put("__fullDate", fullDate);
        return dateMap;
    }

    /**
     * 获得日期的Map对象
     *
     * @param date         日期对象
     * @param daysPattern  日期格式化字符串
     * @param hoursPattern 时间格式化字符串
     * @param fullPattern  全格式格式化字符串
     * @return 包含了年月日、时分秒，以及全格式字符串的Map对象
     * @throws ParseException 格式化异常
     */
    public static Map<String, Date> getDateMap(String date, String daysPattern, String hoursPattern, String fullPattern)
            throws ParseException {
        SimpleDateFormat daysFormatter = new SimpleDateFormat(daysPattern);
        SimpleDateFormat hoursFormatter = new SimpleDateFormat(hoursPattern);
        SimpleDateFormat fullFormatter = new SimpleDateFormat(fullPattern);
        Map<String, Date> dateMap = new HashMap<String, Date>();
        Date days = daysFormatter.parse(date);
        Date hours = hoursFormatter.parse(date);
        Date fullDate = fullFormatter.parse(date);
        dateMap.put("__days", days);
        dateMap.put("__hours", hours);
        dateMap.put("__fullDate", fullDate);
        return dateMap;
    }

    /**
     * 获得日期的Map对象
     *
     * @param date         日期对象
     * @param daysPattern  日期格式化字符串
     * @param hoursPattern 时间格式化字符串
     * @param fullPattern  全格式格式化字符串
     * @return 包含了年月日、时分秒，以及全格式字符串的Map对象
     */
    public static Map<String, String> getStringMap(Date date, String daysPattern, String hoursPattern,
                                                   String fullPattern) {
        SimpleDateFormat daysFormatter = new SimpleDateFormat(daysPattern);
        SimpleDateFormat hoursFormatter = new SimpleDateFormat(hoursPattern);
        SimpleDateFormat fullFormatter = new SimpleDateFormat(fullPattern);
        Map<String, String> dateMap = new HashMap<String, String>();
        String days = daysFormatter.format(date);
        String hours = hoursFormatter.format(date);
        String fullDate = fullFormatter.format(date);
        dateMap.put("__days", days);
        dateMap.put("__hours", hours);
        dateMap.put("__fullDate", fullDate);
        return dateMap;
    }

    /**
     * 根据给定的日期以、格式、提前月数，得到新的日期字符串
     *
     * @param date    日期格式对象
     * @param pattern 解析表达式，如"yyyy-MM-dd" 或 "hh:mm:ss"
     * @return 格式化后的字符串
     */
    public static String getStringDateByMonth(Date date, String pattern, int month, int day) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        Calendar calendar = Calendar.getInstance();// 日历对象
        calendar.setTime(date);// 设置当前日期
        calendar.add(Calendar.MONTH, month);// 提前月份数字
        calendar.add(Calendar.DATE, day);// 提前月份数字
        return formatter.format(calendar.getTime());
    }

    /**
     * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String getDateTime() {

        return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String formatDate(Date date, Object... pattern) {
        String formatDate = null;
        if (pattern != null && pattern.length > 0) {
            formatDate = DateFormatUtils.format(date, pattern[0].toString());
        } else {
            formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
        }
        return formatDate;
    }

    public static Date getTimesMorning() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        Date beginOfDate = cal.getTime();
        return beginOfDate;
    }

    public static Date getTimesEnd(){
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        Date d = calendar.getTime();
        return d;
    }

    public static Date getYesterdayTimesMorning() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.add(Calendar.DATE, -1);
        Date beginOfDate = cal.getTime();
        return beginOfDate;
    }

    public static Date getYesterdayTimesEnd(){
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.DATE, -1);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        Date d = calendar.getTime();
        return d;
    }

    public static void main(String[] args) {
        System.out.println(getTimesMorning());
        System.out.println(getTimesEnd());
    }
}
