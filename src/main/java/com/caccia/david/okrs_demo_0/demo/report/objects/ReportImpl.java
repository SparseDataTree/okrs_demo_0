package com.caccia.david.okrs_demo_0.demo.report.objects;

import com.caccia.david.okrs_demo_0.demo.report.interfaces.HierarchicalId;
import com.caccia.david.okrs_demo_0.demo.report.interfaces.Report;
import lombok.Data;

import java.net.URI;
import java.util.Date;

@Data
public class ReportImpl implements Report<HierarchicalId, String, Date>
{
    private String report;
    private HierarchicalId elementId;
    private Date date;
    private URI link;

    @Override
    public String getReport()
    {
        return report;
    }

    @Override
    public HierarchicalId getElementId()
    {
        return elementId;
    }

    @Override
    public Date getTime()
    {
        return date;
    }

    @Override
    public URI getLink()
    {
        return link;
    }
}
