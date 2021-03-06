package com.blankj.utilcode.utils;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static com.blankj.utilcode.utils.TimeUtils.*;
import static com.google.common.truth.Truth.assertThat;


/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2016/8/12
 *     desc  : TimeUtils单元测试
 * </pre>
 */
public class TimeUtilsTest {


    SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss zzzz", Locale.getDefault());
    long millis = 1470991049000L;
    Date timeDate = new Date(millis);
    String timeString = "2016-08-12 16:37:29";
    String myTimeString = "2016-08-12 16:37:29 中国标准时间";
    String timeString0 = "2016-08-12 16:00:00";
    String timeString1 = "2016-08-12 17:10:10";
    String myTimeString0 = "2016-08-12 16:00:00 中国标准时间";
    String myTimeString1 = "2016-08-12 17:10:10 中国标准时间";


    @Test
    public void testMillis2String() throws Exception {
        assertThat(millis2String(millis)).isEqualTo(timeString);
        assertThat(millis2String(millis, myFormat)).isEqualTo(myTimeString);
    }

    @Test
    public void testString2Millis() throws Exception {
        assertThat(string2Millis(timeString)).isEqualTo(millis);
        assertThat(string2Millis(myTimeString, myFormat)).isEqualTo(millis);
    }

    @Test
    public void testString2Date() throws Exception {
        assertThat(string2Date(timeString)).isEqualTo(timeDate);
        assertThat(string2Date(myTimeString, myFormat)).isEqualTo(timeDate);
    }

    @Test
    public void testDate2String() throws Exception {
        assertThat(date2String(timeDate)).isEqualTo(timeString);
        assertThat(date2String(timeDate, myFormat)).isEqualTo(myTimeString);
    }

    @Test
    public void testDate2Millis() throws Exception {
        assertThat(date2Millis(timeDate)).isEqualTo(millis);
    }

    @Test
    public void testMillis2Date() throws Exception {
        assertThat(millis2Date(millis)).isEqualTo(timeDate);
    }

    @Test
    public void testGetIntervalTime() throws Exception {
        assertThat(getTimeSpan(timeString0, timeString1, ConstUtils.TimeUnit.SEC)).isEqualTo(4210);
        assertThat(getTimeSpan(myTimeString0, myTimeString1, ConstUtils.TimeUnit.SEC, myFormat)).isEqualTo(4210);
        assertThat(getTimeSpan(new Date(4210000), new Date(0), ConstUtils.TimeUnit.SEC)).isEqualTo(4210);
    }

    @Test
    public void testGetCurTimeMills() throws Exception {
        long interval = getCurTimeMills() - System.currentTimeMillis();
        assertThat(interval).isLessThan(10L);
    }

    @Test
    public void testGetCurTimeString() throws Exception {
        System.out.println(getCurTimeString());
        System.out.println(getCurTimeString(myFormat));
    }

    @Test
    public void testGetFriendlyTimeSpanByNow() throws Exception {
        System.out.println(getFriendlyTimeSpanByNow(System.currentTimeMillis()));
        System.out.println(getFriendlyTimeSpanByNow(System.currentTimeMillis() - 6 * ConstUtils.SEC));
        System.out.println(getFriendlyTimeSpanByNow(System.currentTimeMillis() - 6 * ConstUtils.MIN));
        System.out.println(getFriendlyTimeSpanByNow(System.currentTimeMillis() - 6 * ConstUtils.HOUR));
        System.out.println(getFriendlyTimeSpanByNow(System.currentTimeMillis() - ConstUtils.DAY));
        System.out.println(getFriendlyTimeSpanByNow(System.currentTimeMillis() - 2 * ConstUtils.DAY));
    }

    @Test
    public void testIsLeapYear() throws Exception {
        assertThat(isLeapYear(2012)).isEqualTo(true);
        assertThat(isLeapYear(2000)).isEqualTo(true);
        assertThat(isLeapYear(1900)).isEqualTo(false);
    }

    @Test
    public void testGetWeek() throws Exception {
        assertThat(getWeek(timeString)).isEqualTo("星期五");
    }

    @Test
    public void testGetWeekIndex() throws Exception {
        assertThat(getWeekIndex(timeString)).isEqualTo(6);
    }

    @Test
    public void testGetOfMonth() throws Exception {
        assertThat(getWeekOfMonth(timeString)).isEqualTo(2);
    }

    @Test
    public void testGetOfYear() throws Exception {
        assertThat(getWeekOfYear(timeString)).isEqualTo(33);
    }
}