package com.caccia.david.okrs_demo_0.demo.report.objects;

import com.caccia.david.okrs_demo_0.demo.report.interfaces.Okr;
import com.caccia.david.okrs_demo_0.demo.report.interfaces.ReportComponentType;
import lombok.Data;

import java.util.List;

@Data
public class OkrImpl extends IdedElement implements Okr<String, Objective, KeyResult>, ReportComponentType<ReportComponentTypes>
{
    private Objective objective;
    private List<KeyResult> keyResults;
    private String teamName;
    private String teamSummary;

    @Override
    public String getTeamName()
    {
        return teamName;
    }

    @Override
    public String getTeamSummary()
    {
        return teamSummary;
    }

    @Override
    public Objective getObjective()
    {
        return objective;
    }

    @Override
    public List<KeyResult> getKeyResults()
    {
        return keyResults;
    }

    @Override
    public ReportComponentTypes getType()
    {
        return ReportComponentTypes.OKR;
    }
}
