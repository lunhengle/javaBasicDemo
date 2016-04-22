package com.lhl;

import org.junit.Test;

/**
 * Created by lenovo on 2016/4/22.
 */
public class IntTest {
    @Test
    public void testInt() {
        User user = new User();
        user.setUsername("1233");
        user.setPassword("45646");
        System.out.println(user.getType());
    }
}
