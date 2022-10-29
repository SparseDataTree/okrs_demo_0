package com.caccia.david.okrs_demo_0.demo.report.objects;

import com.caccia.david.okrs_demo_0.demo.report.interfaces.Commented;
import com.caccia.david.okrs_demo_0.demo.report.interfaces.ReportComponentType;
import lombok.Data;

import java.util.Date;

@Data
public class Objective extends AbstractCommented<Commented<String,String,Date, String> > implements ReportComponentType<ReportComponentTypes>
{
    Commented<String,String,Date,String> objective;

    @Override
    public ReportComponentTypes getType()
    {
        return ReportComponentTypes.Objective;
    }

    @Override
    public Commented<String, String, Date, String> getElement()
    {
        return objective;
    }
}
