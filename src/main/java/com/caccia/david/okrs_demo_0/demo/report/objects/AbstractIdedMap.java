package com.caccia.david.okrs_demo_0.demo.report.objects;

import com.caccia.david.okrs_demo_0.demo.report.interfaces.IdedMap;
import com.caccia.david.okrs_demo_0.demo.report.interfaces.Timed;

import java.util.Date;
import java.util.HashMap;
/*
TODO: consider if we want comments at this level.
 */
public abstract class AbstractIdedMap<T,U,V> extends HashMap<T, V> implements IdedMap<T,U,V>, Timed<Date>
{
    private T elementId;
    private U userId;

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
    public T getElementId()
    {
        return elementId;
    }

    @Override
    public U getUserId()
    {
        return userId;
    }

    @Override
    public Date getTime()
    {
        return time;
    }
}
