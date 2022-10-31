package com.caccia.david.okrs_demo_0.demo.report.objects;

import com.caccia.david.okrs_demo_0.demo.report.interfaces.ReportComponentType;
import lombok.Data;


@Data
public class KeyResult extends AbstractCommented<String> implements ReportComponentType<ReportComponentTypes>
{
    String element;

    @Override
    public ReportComponentTypes getType()
    {
        return ReportComponentTypes.KeyResult;
    }

    @Override
    public String getElement()
    {
        return element;
    }
}
