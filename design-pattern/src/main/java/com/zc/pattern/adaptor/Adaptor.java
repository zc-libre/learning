package com.zc.pattern.adaptor;

/**
 * @author zhao.cheng
 * @date 2021/1/22 9:09
 */
public class Adaptor extends Adaptee implements ITarget {

    @Override
    public void f1() {
        super.fa();
    }

    @Override
    public void f2() {
        super.fb();
    }

    @Override
    public void f3() {
    }
}
