package com.lhl;

import org.junit.Test;

/**
 * Created by lenovo on 2016/3/30.
 */
public class StaticTest {
   @Test
    public void testStatic(){
      // Constents constents=new Constents();
       System.out.println(Constents.TYPES.get(0));
       System.out.println(Constents.getTypeName(18));
   }
}
