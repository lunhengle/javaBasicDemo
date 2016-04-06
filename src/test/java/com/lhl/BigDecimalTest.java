package com.lhl;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by lenovo on 2016/4/6.
 */
public class BigDecimalTest {
    @Test
    public void BigDecimalTest(){
        Assert.assertEquals(true,this.compare());
    }

    private boolean compare(){
        BigDecimal b1,b2;
        b1=new BigDecimal(10);
        b2=new BigDecimal(20);
        return b1.compareTo(b2)==-1;
    }
}
