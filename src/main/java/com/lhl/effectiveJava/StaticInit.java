package com.lhl.effectiveJava;

/**
 * Created by lenovo on 2016/4/11.
 * 单例模式
 */
public class StaticInit {
    private static StaticInit staticInit = new StaticInit();

    private StaticInit() {
    }

    public final static StaticInit getInitialization() {
        return staticInit;
    }
}
