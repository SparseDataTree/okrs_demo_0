package com.caccia.david.okrs_demo_0.demo.report.objects.ids;

import com.caccia.david.okrs_demo_0.demo.report.interfaces.ObjectiveKRsId;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class ObjectiveKRsIdsImpl implements ObjectiveKRsId
{
    private String objectiveId;
    private Set<String> keyResultIds = new HashSet<>();

    @Override
    public String getObjectiveId()
    {
        return objectiveId;
    }

    @Override
    public Set<String> getKeyResultIds()
    {
        return keyResultIds;
    }
}
