package com.caccia.david.okrs_demo_0.demo.report.objects;

import com.caccia.david.okrs_demo_0.demo.report.interfaces.HierarchicalId;
import com.caccia.david.okrs_demo_0.demo.report.interfaces.Report;
import lombok.Data;

import java.net.URI;
import java.util.Date;

@Data
public class ReportImpl implements Report<HierarchicalId,String, String, Date>
{
    private String report;
    private HierarchicalId nodeId;
    private String userId;
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
        return nodeId;
    }

    @Override
    public String getUserId()
    {
        return userId;
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
