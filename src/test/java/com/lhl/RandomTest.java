package com.lhl;

import org.junit.Test;

import java.util.Random;

/**
 * Created by lenovo on 2016/4/12.
 */
public class RandomTest {
    @Test
    public void randomTest(){
        this.random();
    }

    private void random(){
        Random random=new Random();
        for(int i=0;i<30;i++){
            System.out.println(random.nextInt(10)+1);
        }
    }
}
