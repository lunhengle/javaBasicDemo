package com.lhl;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by lenovo on 2016/3/26.
 */
public class CopyTest {
    @Test
    public void copyTest() {
        CopyObject copyObject = new CopyObject();
        copyObject.setId(1);
        copyObject.setUsername("lunhengle");
        copyObject.setPassword("123456");
        CopyObjectVo copyObjectVo = new CopyObjectVo().getCopy(copyObject);
        System.out.println(copyObject.getUsername()+":"+copyObjectVo.getUsername());
        Assert.assertEquals(copyObject.getUsername(),copyObjectVo.getUsername());
    }
}
