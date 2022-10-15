package com.caccia.david.okrs_demo_0.demo.report.objects;

import com.caccia.david.okrs_demo_0.demo.report.interfaces.HierarchicalId;
import com.caccia.david.okrs_demo_0.demo.report.interfaces.Report;

public class ReportImpl implements Report<HierarchicalId,String, String>
{
    private String report;
    private HierarchicalId nodeId;
    private String userId;

    @Override
    public String getReport()
    {
        return report;
    }

    @Override
    public HierarchicalId getElementId()
    {
        return nodeId;
    }

    @Override
    public String getUserId()
    {
        return userId;
    }
}
