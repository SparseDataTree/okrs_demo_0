package com.caccia.david.okrs_demo_0.demo.report.interfaces;

import java.util.List;

public interface HierarchicalId
{
    List<String> getIdList();

    boolean isPresent(String id);

    String getRootId();

    boolean hasParent(String id);

    String getParent(String id);

    boolean hasChild(String id);

    String getChild(String id);
}
