package com.lhl;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by lenovo on 2016/3/31.
 * 关于getDayDate1 和 getDayDate2 返回结果是不同的 第一种比较的带时分秒 第二种只比较天数
 */
public class TimestampTest {

    @Test
    public void testDate() {
        //预定时间
        String date = "2016-04-01 11:03:21.456";
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Assert.assertEquals(0, this.getDateDay1(date));
        Assert.assertEquals(0, this.getDateDay2(date));
        this.getDifferDay(-3);
        this.getStartDay(timestamp);
        this.getEndDay(timestamp);
    }

    /**
     * 和预定时间相比相差多少天.
     *
     * @param date 预设时间
     * @return 相差天数
     */
    private int getDateDay1(String date) {
        Timestamp timestamp0 = Timestamp.valueOf(date);
        //当前时间
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        long intervalMilli = timestamp.getTime() - timestamp0.getTime();
        return (int) (intervalMilli / (24 * 60 * 60 * 1000));
    }

    /**
     * 和预定时间相比相差多少天.
     *
     * @param date 预设时间
     * @return 相差天数
     */
    private int getDateDay2(String date) {
        Timestamp timestamp0 = Timestamp.valueOf(date);
        Calendar calendar0 = Calendar.getInstance();
        calendar0.setTime(timestamp0);
        int date0 = calendar0.get(Calendar.DAY_OF_YEAR);
        //当前时间
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(timestamp);
        int date1 = calendar.get(Calendar.DAY_OF_YEAR);
        return date1 - date0;
    }

    /**
     * 输入相差天数求得相差时间的时间.
     *
     * @param day 相差天数
     */
    private void getDifferDay(int day) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(timestamp);
        calendar.add(Calendar.DAY_OF_YEAR, day);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = df.format(calendar.getTime());
        Timestamp ts = Timestamp.valueOf(time);
        System.out.println("newTime:" + ts.toString());
    }

    /**
     * 获取当前时间开始
     */
    private void getStartDay(Timestamp timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(timestamp);
        System.out.println("getStartDay>>>>>>>>>>>>>>>>>>>>>>" + calendar.getTime());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String time = df.format(calendar.getTime());
        time = time + " 00:00:00";
        System.out.println("getStartDay>>>>>>>>>>>>>>>>>>>>>" + time);
        Timestamp timestamp1 = Timestamp.valueOf(time);
        System.out.println("getStartDay>>>>>>>>>>>>>>>>>>>>>" + timestamp1.toString());
    }

    /**
     * 获取当前时间结束
     */
    private void getEndDay(Timestamp timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(timestamp);
        System.out.println("getEndDay>>>>>>>>>>>>>>>>>>>>>>>>>" + calendar.getTime());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String time = df.format(calendar.getTime());
        time = time + " 23:59:59";
        System.out.println("getEndDay>>>>>>>>>>>>>>>>>" + time);
        Timestamp timestamp1 = Timestamp.valueOf(time);
        System.out.println("getEndDay>>>>>>>>>>>>>>>>>" + timestamp1.toString());
    }
}
