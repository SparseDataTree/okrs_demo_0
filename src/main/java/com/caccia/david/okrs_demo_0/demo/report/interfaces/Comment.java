package com.caccia.david.okrs_demo_0.demo.report.interfaces;

public interface Comment<I, T, C> extends Ided<I,I>, Timed<T>
{
    C getComment();
}
