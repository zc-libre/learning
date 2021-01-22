package com.zc.pattern.adaptor;

/**
 * @author zhao.cheng
 * @date 2021/1/22 9:12
 */
public class ClassAdaptor implements ITarget{

    private final Adaptee adaptee;

    public ClassAdaptor(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void f1() {
        adaptee.fa();
    }

    @Override
    public void f2() {
        adaptee.fb();
    }

    @Override
    public void f3() {
        adaptee.fc();
    }
}
