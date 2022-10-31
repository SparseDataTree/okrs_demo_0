package com.caccia.david.okrs_demo_0.demo.report.interfaces;

import java.util.Set;

public interface Commented<I, E,T,C> extends Ided<I,I>, Timed<T>
{
    E getElement();
    Set<Thread<I,T,C>> getThreads();
}
