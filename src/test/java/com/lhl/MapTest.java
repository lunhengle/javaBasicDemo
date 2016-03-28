package com.lhl;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by lenovo on 2016/3/25.
 */
public class MapTest {
    @Test
    public void hashMaptest() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("1", "1");
        Set<String> set = map.keySet();
        for (String str : set) {
            System.out.println("key:" + str + " value: " + map.get(str));
        }

    }
}
