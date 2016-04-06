package com.lhl;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2016/4/6.
 */
public class StringBuilderTest {
    @Test
    public void stringBuilderTest() {
        String result = this.getStringBuffer(this.getSourceList());
        System.out.println(result);
    }

    public List<Long> getSourceList() {
        List<Long> list = new ArrayList<Long>();
        list.add(1l);
        list.add(3l);
        list.add(4l);
        list.add(7l);
        return list;
    }

    private String getStringBuffer(List<Long> longList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Long l : longList) {
            stringBuilder.append("," + l);
        }
        return stringBuilder.substring(1, stringBuilder.length());
    }
}
