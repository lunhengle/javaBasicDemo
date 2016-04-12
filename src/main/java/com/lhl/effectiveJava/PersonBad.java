package com.lhl.effectiveJava;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by lenovo on 2016/4/12.
 * 避免创建比必要的对象
 * 这是一个错误的实例 每当调用isBabyBoomer时会初始化一个 Calendar 一个 TimeZone 两个 date
 */
public class PersonBad {
    private final Date birthDate = new Date();

    public boolean isBabyBoomer() {
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0);
        Date boomStart = gmtCal.getTime();
        gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0);
        Date boomEnd = gmtCal.getTime();
        return birthDate.compareTo(boomStart) >= 0 && birthDate.compareTo(boomEnd) < 0;
    }
}
