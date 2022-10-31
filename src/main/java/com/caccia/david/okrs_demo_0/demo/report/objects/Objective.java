package com.caccia.david.okrs_demo_0.demo.report.objects;

import com.caccia.david.okrs_demo_0.demo.report.interfaces.ReportComponentType;
import lombok.Data;


@Data
public class Objective extends AbstractCommented< String> implements ReportComponentType<ReportComponentTypes>
{
    String objective;

    @Override
    public ReportComponentTypes getType()
    {
        return ReportComponentTypes.Objective;
    }

    @Override
    public String getElement()
    {
        return objective;
    }
}
