package com.caccia.david.okrs_demo_0.demo.report.objects;

import com.caccia.david.okrs_demo_0.demo.report.interfaces.Commented;
import com.caccia.david.okrs_demo_0.demo.report.interfaces.ReportComponentType;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Objective extends AbstractCommented<List<Commented<String,Date,String,String>> > implements ReportComponentType<ReportComponentTypes>
{
    List<Commented<String,Date,String,String>> objectiveVersions;

    @Override
    public ReportComponentTypes getType()
    {
        return ReportComponentTypes.Objective;
    }

    @Override
    public List<Commented<String, Date, String, String>> getElement()
    {
        return objectiveVersions;
    }
}
