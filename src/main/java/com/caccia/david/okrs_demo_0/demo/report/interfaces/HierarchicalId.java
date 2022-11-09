package com.caccia.david.okrs_demo_0.demo.report.interfaces;

import java.util.List;
import java.util.Set;

public interface HierarchicalId
{
    List<String> getIdList();

    boolean isPresent(String id);

    String getRootId();

    //tod do we want a method to get the leaf?

    boolean isLeaf(String idIn);

    boolean hasParent(String id);

    String getParent(String id);

    boolean hasChild(String id);

    String getChild(String id);

    HierarchicalId getHierarchicalId(String id) // use after checking for presence
    ;

    String getLeaf();

    Set<ObjectiveKRsId> getObjectiveIds();
}
