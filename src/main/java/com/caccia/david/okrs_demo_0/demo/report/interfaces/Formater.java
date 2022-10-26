package com.caccia.david.okrs_demo_0.demo.report.interfaces;

import com.caccia.david.okrs_demo_0.demo.report.objects.ReportImpl;

import java.util.List;

public interface Formater<R,D, I>
{
    R format(D id, I input);

    R format(I input);
}
