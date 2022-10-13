package com.caccia.david.okrs_demo_0.demo.report.objects;

import com.caccia.david.okrs_demo_0.demo.report.interfaces.Comments;
import com.caccia.david.okrs_demo_0.demo.report.interfaces.ReportComponentType;
import lombok.Data;

import java.util.Date;

@Data
public class CommentsImpl extends AbstractCommented<String> implements Comments<String, Date,String>, ReportComponentType<ReportComponentTypes>
{

    private String element; // At some point, we may want comments to be editable (meaning that it can be versioned).

    @Override
    public String getElement()
    {
        return element;
    }

    @Override
    public String getComment()
    {
        return getElement();
    }

    @Override
    public Comments<String, Date, String> getReply()
    {
        return getComments();
    }

    @Override
    public ReportComponentTypes getType()
    {
        return type;
    }
}
