package com.lhl;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by lenovo on 2016/3/25.
 */
public class StringTest {
    @Test
    public void stringTest(){
        String str="100";
        long l=100;
        //Long l=100L;
        Assert.assertEquals(true,str.equals(String.valueOf(l)));
    }
}
