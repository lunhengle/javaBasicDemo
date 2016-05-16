package com.lhl;

import java.util.Comparator;

/**
 * Created by lenovo on 2016/5/14.
 */
public class ComparatorUser implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        User user0 = (User) o1;
        User user1 = (User) o2;
        //比较年龄
        int i = String.valueOf(user1.getTimestamp()).compareTo(String.valueOf(user0.getTimestamp()));
        System.out.println(i);
        return i;
    }
}
