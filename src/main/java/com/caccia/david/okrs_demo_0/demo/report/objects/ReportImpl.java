package com.caccia.david.okrs_demo_0.demo.report.objects;

import com.caccia.david.okrs_demo_0.demo.report.interfaces.Report;

public class ReportImpl extends IdedElement implements Report<String,String>
{
    private String report;

    @Override
    public String getReport()
    {
        return report;
    }
}
