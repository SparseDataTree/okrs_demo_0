package com.caccia.david.okrs_demo_0.demo.report.objects;

import com.caccia.david.okrs_demo_0.demo.report.factories.ReportComponentTypes;
import com.caccia.david.okrs_demo_0.demo.report.interfaces.ObjectiveId;
import com.caccia.david.okrs_demo_0.demo.report.interfaces.ReportComponentType;
import lombok.Data;


@Data
public class Objective extends AbstractCommented< String, ObjectiveId> implements ReportComponentType<ReportComponentTypes>
{
    String objective;
    private ObjectiveId elementId;

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

    @Override
    public ObjectiveId getElementId()
    {
        return elementId;
    }
}
