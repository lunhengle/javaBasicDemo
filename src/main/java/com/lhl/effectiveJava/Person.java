package com.lhl.effectiveJava;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by lenovo on 2016/4/12.
 * 避免少见对象正确示例
 * Calendar Date 和 TimeZone  在调用isBabyBoomer时只会实例化一次
 */
public class Person {
    private final Date birthDate = new Date();
    private static final Date BOOM_START;
    private static final Date BOOM_END;

    static {
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0);
        BOOM_START = gmtCal.getTime();
        gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0);
        BOOM_END = gmtCal.getTime();
    }

    public boolean isBabyBoomer() {
        return birthDate.compareTo(BOOM_START) >= 0 && birthDate.compareTo(BOOM_END) < 0;
    }

}
