package com.caccia.david.okrs_demo_0.demo.report.objects;

import com.caccia.david.okrs_demo_0.demo.report.interfaces.Commented;

import com.caccia.david.okrs_demo_0.demo.report.interfaces.ReportComponentType;
import lombok.Data;

import java.util.Date;

@Data
public class KeyResult extends AbstractCommented<Commented<String, Date,String,String>> implements ReportComponentType<ReportComponentTypes>
{
    Commented<String, Date,String,String> keyResult;

    @Override
    public ReportComponentTypes getType()
    {
        return ReportComponentTypes.KeyResult;
    }

    @Override
    public Commented<String, Date, String, String> getElement()
    {
        return keyResult;
    }
}
