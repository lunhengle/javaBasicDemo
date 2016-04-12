package com.lhl.effectiveJava;

import org.junit.Test;

/**
 * Created by lenovo on 2016/4/11.
 */
public class NutritionFoctsTest {
    @Test
    public void test() {
        NutritionFocts nutritionFocts = new NutritionFocts.Builder(100, 0).calories(1).carbohydrate(2).sodium(3).build();
    }
}
