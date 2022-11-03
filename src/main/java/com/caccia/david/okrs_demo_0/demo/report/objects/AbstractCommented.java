package com.caccia.david.okrs_demo_0.demo.report.objects;

import com.caccia.david.okrs_demo_0.demo.report.interfaces.Commented;
import com.caccia.david.okrs_demo_0.demo.report.interfaces.Ided;
import com.caccia.david.okrs_demo_0.demo.report.interfaces.Thread;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public abstract class AbstractCommented<E, I> implements Ided<I>, Commented<String, E, Date,String>
{
    /*
    TODO consider if we want a boolean to indicate that new comments have been added since the last report.
     */
    private Date time;
    private Set<Thread<String, Date, String>> threads;

    @Override
    public Date getTime()
    {
        return time;
    }
    @Override
    public Set<Thread<String, Date, String>> getThreads()
    {
        return threads;
    }
}
