package com.caccia.david.okrs_demo_0.demo.report.objects;

import com.caccia.david.okrs_demo_0.demo.report.interfaces.IdedMap;
import com.caccia.david.okrs_demo_0.demo.report.interfaces.Timed;

import java.util.Date;
import java.util.HashMap;

public abstract class AbstractIdedMap<V> extends HashMap<String, V> implements IdedMap<String,V>, Timed<Date>
{
    private String elementId;
    private String userId;

    private String teamName;
    private String teamSummary;
    private Date time;

    @Override
    public String getTeamName()
    {
        return teamName;
    }

    @Override
    public String getTeamSummary()
    {
        return teamSummary;
    }

    @Override
    public String getElementId()
    {
        return elementId;
    }

    @Override
    public String getUserId()
    {
        return userId;
    }

    @Override
    public Date getTime()
    {
        return time;
    }
}
