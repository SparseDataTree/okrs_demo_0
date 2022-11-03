package com.caccia.david.okrs_demo_0.demo.report.objects;

import com.caccia.david.okrs_demo_0.demo.report.interfaces.Comment;
import com.caccia.david.okrs_demo_0.demo.report.interfaces.Thread;
import lombok.Data;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Data
public class ThreadImpl implements Thread<String, Date, String>
{
    private Date time;
    private List<Comment<String, Date, String>> thread =  new LinkedList<>();
    private String elementId;

    @Override
    public List<Comment<String, Date, String>> getThread()
    {
        return thread;
    }

    @Override
    public Date getTime()
    {
        return time;
    }

    @Override
    public String getElementId()
    {
        return elementId;
    }
}
