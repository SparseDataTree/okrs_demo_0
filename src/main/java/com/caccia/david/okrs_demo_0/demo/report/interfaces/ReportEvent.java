package com.caccia.david.okrs_demo_0.demo.report.interfaces;

import java.util.Map;

/*
   Reports are not versioned and are not commented.  But They are ided.  Hence, there are no deletions on reports
 */
public interface ReportEvent<I,R> extends Ided<I>
{
    R report();

}
