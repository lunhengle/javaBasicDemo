package com.lhl;

import org.junit.Test;

/**
 * Created by lenovo on 2016/4/18.
 */
public class ArrayTest {
    @Test
    public void testArray() {
        int[] i = this.getInt();
        for (int j = 0; j < i.length; j++) {
            System.out.println(j + ":" + i[j]);
        }
        Object[] o = this.getObject();
        for (int j = 0; j < o.length; j++) {
            if(o[j]!=null){
                System.out.println(j+":"+o[j]);
            }
        }
    }

    private int[] getInt() {
        int[] i = new int[3];
        i[0] = 0;
        i[2] = 2;
        return i;
    }

    private Object[] getObject() {
        Object[] o = new Object[3];
        o[0] = 0;
        o[2] = 2;
        return o;
    }
}
