package com.lhl;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2016/3/25.
 */
public class TestList {

    @Test
    public void testListContains() {
        List<Long> list=new ArrayList();
        list.add(1L);
        list.add(2L);
        list.add(3L);
        Assert.assertEquals("返回true正确 返回false 不正确",list.contains(2L),true);
    }

    @Test
    public void testList(){
        List<String> list=new ArrayList<String>();
        list.add(new String("12"));
        list.add(new String("23"));
        list.add(new String("12"));
        for(String str:list){
            System.out.println("list: "+str);
        }
    }
}
