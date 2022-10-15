package com.caccia.david.okrs_demo_0.demo.report.interfaces;

import com.caccia.david.okrs_demo_0.demo.report.objects.ReportComponentTypes;

public interface Comments<I,T,C> extends Ided<I,I>, Timed<T>
{
    static ReportComponentTypes type = ReportComponentTypes.Comment;
    C getComment();
    Comments<I,T,C> getReply();
}
