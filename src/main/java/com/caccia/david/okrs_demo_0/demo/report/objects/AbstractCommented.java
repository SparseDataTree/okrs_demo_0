package com.caccia.david.okrs_demo_0.demo.report.objects;

import com.caccia.david.okrs_demo_0.demo.report.interfaces.Commented;
import com.caccia.david.okrs_demo_0.demo.report.interfaces.Comments;
import lombok.Data;

import java.util.Date;

@Data
public abstract class AbstractCommented<E> extends IdedElement implements Commented<String, E, Date,String>
{
    private Date time;
    private Comments<String, Date, String> comments;

    @Override
    public Date getTime()
    {
        return time;
    }
    @Override
    public Comments<String, Date, String> getComments()
    {
        return comments;
    }
}
