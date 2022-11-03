package com.caccia.david.okrs_demo_0.demo.report.objects;

import com.caccia.david.okrs_demo_0.demo.report.interfaces.IdedMap;
import com.caccia.david.okrs_demo_0.demo.report.interfaces.Linked;
import com.caccia.david.okrs_demo_0.demo.report.interfaces.Timed;
import lombok.Data;

import java.net.URI;
import java.util.Date;
import java.util.HashMap;
/*
TODO: consider if we want comments at this level.
 */
@Data
public abstract class AbstractIdedMap<T,U,V> extends HashMap<T, V> implements IdedMap<T,U,V>, Timed<Date>, Linked
{
    private U elementId;
    private URI link;
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
    public U getElementId()
    {
        return elementId;
    }

    @Override
    public Date getTime()
    {
        return time;
    }

    @Override
    public URI getLink()
    {
        return link;
    }
}
