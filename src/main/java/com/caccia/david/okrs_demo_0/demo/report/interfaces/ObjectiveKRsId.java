package com.caccia.david.okrs_demo_0.demo.report.interfaces;

import java.util.Set;

/*
An objective and its associated key results makes a logical unit.  We are intentionally binding their ids into one class.
 */
public interface ObjectiveKRsId
{
    String getObjectiveId();
    Set<String> getKeyResultIds();
}
