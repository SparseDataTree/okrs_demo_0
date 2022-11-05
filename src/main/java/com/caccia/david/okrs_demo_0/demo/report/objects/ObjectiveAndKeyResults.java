package com.caccia.david.okrs_demo_0.demo.report.objects;

import com.caccia.david.okrs_demo_0.demo.report.factories.ReportComponentTypes;
import com.caccia.david.okrs_demo_0.demo.report.interfaces.Okr;
import com.caccia.david.okrs_demo_0.demo.report.interfaces.ReportComponentType;
import lombok.Data;

import java.util.Map;

@Data
public class ObjectiveAndKeyResults implements Okr<String, Objective, KeyResult>, ReportComponentType<ReportComponentTypes>
{
    private Objective objective;
    private Map<String, KeyResult> keyResults;

    @Override
    public Objective getObjective()
    {
        return objective;
    }

    @Override
    public Map<String,KeyResult> getKeyResults()
    {
        return keyResults;
    }

    @Override
    public ReportComponentTypes getType()
    {
        return ReportComponentTypes.OKR;
    }
}
