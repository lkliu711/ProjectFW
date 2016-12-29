package com.example.pfw.projectframework.utils;

import android.text.TextUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 */
public class DateUtils {

    private static final String[] weeks = {"日", "一", "二", "三", "四", "五", "六"};

    /**
     * 将Date类型转换为日期字符串
     *
     * @param date Date对象
     * @param type 需要的日期格式
     * @return 按照需求格式的日期字符串
     */
    public static String formatDate(Date date, String type) {
        try {
            SimpleDateFormat df = new SimpleDateFormat(type);
            return df.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String formatDate(String date, String type) {
        if (TextUtils.isEmpty(date))
            return "";
        Date d = new Date(Long.parseLong(date));
        return formatDate(d, type);
    }

    /**
     * 获取当前日期为星期几
     *
     * @param value 日期
     * @return String
     * @author chenssy
     * @date Dec 31, 2013
     */
    public static String getCurrentWeek(Date value) {
        Calendar current = Calendar.getInstance();
        Calendar today = Calendar.getInstance();
        current.setTime(value);
        int weekIndex = current.get(Calendar.DAY_OF_WEEK) - 1 < 0 ? 0 : current.get(Calendar.DAY_OF_WEEK) - 1;

        if (today.get(Calendar.DAY_OF_MONTH) == current.get(Calendar.DAY_OF_MONTH)) {
            return "今天";
        } else {
            return weeks[weekIndex];
        }

    }

    /**
     * 得到当前日期前后几天的时间
     *
     * @param num
     * @return
     */
    public static Date getNextDay(int num) {
        Calendar calendar = Calendar.getInstance();
        int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
        calendar.set(Calendar.DAY_OF_YEAR, dayOfYear + num);
        return calendar.getTime();
    }

    /**
     * 是否是今天
     *
     * @param date
     * @return
     */
    public static boolean isToday(final Date date) {
        return isTheDay(date, new Date());
    }

    /**
     * 是否是指定日期
     *
     * @param date
     * @param day
     * @return
     */
    public static boolean isTheDay(final Date date, final Date day) {
        return date.getTime() >= DateUtils.dayBegin(day).getTime()
                && date.getTime() <= DateUtils.dayEnd(day).getTime();
    }

    /**
     * 获取指定时间的那天 00:00:00.000 的时间
     *
     * @param date
     * @return
     */
    public static Date dayBegin(final Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    /**
     * 获取指定时间的那天 23:59:59.999 的时间
     *
     * @param date
     * @return
     */
    public static Date dayEnd(final Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 999);
        return c.getTime();
    }

    /**
     * 将毫秒转换成时间格式
     * @param str
     * @param ss
     * @return
     */
    public static String longBydata(long str, String ss){
        SimpleDateFormat format = new SimpleDateFormat(ss);
        String time = format.format(new Date(str));
        return time;
    }
}
