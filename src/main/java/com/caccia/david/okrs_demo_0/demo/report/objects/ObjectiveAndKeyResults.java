package com.caccia.david.okrs_demo_0.demo.report.objects;

import com.caccia.david.okrs_demo_0.demo.report.interfaces.Okr;
import com.caccia.david.okrs_demo_0.demo.report.interfaces.ReportComponentType;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ObjectiveAndKeyResults extends IdedElement implements Okr<String, Objective, KeyResult>, ReportComponentType<ReportComponentTypes>
{

    // Hm.  So, maybe this is ok for a single objective with its set of key results.
    // but then we still need a set of objectives with each of their collections of key results for a team.
    // I think that this class should have team name and team summary removed - to be added to the set of OKRs class.
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
