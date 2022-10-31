package com.caccia.david.okrs_demo_0.demo.report.objects;

import com.caccia.david.okrs_demo_0.demo.report.interfaces.Comment;
import lombok.Data;

import java.util.Date;

@Data
public class CommentImpl extends IdedElement implements Comment<String, Date, String>
{
    private String comment;
    private Date time;

    @Override
    public String getComment()
    {
        return comment;
    }

    @Override
    public Date getTime()
    {
        return time;
    }
}
