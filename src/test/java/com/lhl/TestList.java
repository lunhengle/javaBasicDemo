package com.lhl;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by lenovo on 2016/3/25.
 */
public class TestList {

    @Test
    public void testListContains() {
        List<Long> list = new ArrayList();
        list.add(1L);
        list.add(2L);
        list.add(3L);
        Assert.assertEquals("返回true正确 返回false 不正确", list.contains(2L), true);
    }

    @Test
    public void testList() {
        List<String> list = new ArrayList<String>();
        list.add(new String("12"));
        list.add(new String("23"));
        list.add(new String("12"));
        for (String str : list) {
            System.out.println("list: " + str);
        }
    }

    /**
     * 顺序排列.
     */
    @Test
    public void sort() {
        List list = new ArrayList();
        for (int i = 8; i >= 0; i--) {
            list.add("a" + i);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println("未排序前：" + list.get(i));
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("排序后：" + list.get(i));
        }
    }

    /**
     * 随机排序.
     */
    @Test
    public void shuffle() {
        List list = new ArrayList();
        for (int i = 0; i < 9; i++) {
            list.add("a" + i);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println("未排序前：" + list.get(i));
        }
        Collections.shuffle(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("排序后：" + list.get(i));
        }
    }

    /**
     * 倒叙排列.
     */
    @Test
    public void reverse() {
        List list = new ArrayList();
        for (int i = 0; i < 9; i++) {
            list.add("a" + i);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println("未排序前：" + list.get(i));
        }
        Collections.reverse(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("排序后：" + list.get(i));
        }
    }

    /**
     * 数组排序
     */
    @Test
    public void array() {
        String[] arr = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
      /*  List list = new ArrayList();
        Collections.addAll(list, arr);*/
        List list = Arrays.asList(arr);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("排序前：" + list.get(i));
        }
        Collections.reverse(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("排序后：" + list.get(i));
        }
    }
}
