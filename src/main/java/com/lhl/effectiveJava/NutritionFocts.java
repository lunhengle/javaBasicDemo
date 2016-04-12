package com.lhl.effectiveJava;

/**
 * Created by lenovo on 2016/4/11.
 * 此例子是用来代替有多个构造函数的参数可变的情况
 * 这样做的好处是 实例是可控的调用更加方便
 */
public class NutritionFocts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder {
        private final int servingSize;
        private final int servings;
        private int calories;
        private int sodium;
        private int carbohydrate;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val) {
            calories = val;
            return this;
        }

        public Builder sodium(int val) {
            sodium = val;
            return this;
        }

        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }

        public NutritionFocts build() {
            return new NutritionFocts(this);
        }
    }

    private NutritionFocts(Builder builder) {
        servings = builder.servings;
        servingSize = builder.servingSize;
        calories = builder.calories;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }
}
