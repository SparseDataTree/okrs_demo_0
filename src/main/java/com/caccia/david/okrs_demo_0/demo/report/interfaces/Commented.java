package com.caccia.david.okrs_demo_0.demo.report.interfaces;

public interface Commented<I, E,T,C> extends Ided<I,I>, Timed<T>
{
    E getElement();
    Comments<I,T,C> getComments();
}
