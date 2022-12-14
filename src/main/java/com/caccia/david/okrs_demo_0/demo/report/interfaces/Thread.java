package com.caccia.david.okrs_demo_0.demo.report.interfaces;

import com.caccia.david.okrs_demo_0.demo.report.factories.ReportComponentTypes;

import java.util.List;

public interface Thread<I,T,C> extends Ided<I>, Timed<T>
{
    static ReportComponentTypes type = ReportComponentTypes.Comment;

    List<Comment<I,T,C>> getThread();
}
