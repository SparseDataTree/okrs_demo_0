package com.caccia.david.okrs_demo_0.demo.report.objects.ids;

import com.caccia.david.okrs_demo_0.demo.report.interfaces.HierarchicalId;
import com.caccia.david.okrs_demo_0.demo.report.interfaces.ObjectiveKRsId;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
   We assume a directed tree graph of nodes.  We assume uniqueness of all node identifiers within a tree.
   A hierarchical identifier marks out the path from the root of the tree to a particular node.

 */
public class HierarchicalIdImpl implements HierarchicalId
{
    List<String> idList;
    private Set<ObjectiveKRsId> objectiveKRsIds = new HashSet<>();

    public HierarchicalIdImpl(List<String> path)
    {
        idList = path;  // todo maybe copy list?
    }


    @Override
    public List<String> getIdList()
    {
        return idList;
    }

    @Override
    public boolean isPresent(String idIn)
    {
        return idList.contains(idIn);
    }

    @Override
    public String getRootId()
    {
        return idList.get(0); // todo do we want to check for null or empty list?
    }

    @Override
    public boolean isLeaf(String idIn)
    {
        return idList.get(idList.size() - 1).equals(idIn);
    }

    @Override
    public boolean hasParent(String id)
    {
        return idList.indexOf(id) > 0;
    }

    @Override
    public String getParent(String id) // use after checking for existence of parent
    {
        int ix = idList.indexOf(id) - 1;
        return idList.get(ix);
    }

    @Override
    public boolean hasChild(String id)
    {
        return idList.indexOf(id) < idList.size() - 1;
    }

    @Override
    public String getChild(String id) // use after checking for existence of child
    {
        int ix = idList.indexOf(id) + 1;
        return idList.get(ix);
    }

    @Override
    public HierarchicalId getHierarchicalId(String id) // use after checking for presence
    {
        List<String> path = new LinkedList<>();
        for(String idElement: idList)
        {
            path.add(idElement);
            if(id.equals(idElement)) break;
        }
        return new HierarchicalIdImpl(path);
    }

    @Override
    public String getLeaf()
    {
        return idList.get(idList.size() - 1);
    }

    @Override
    public Set<ObjectiveKRsId> getObjectiveIds()
    {
        return objectiveKRsIds;
    }

    @Override
    public String toString()
    {
        return idList.stream().collect(Collectors.joining(" -> "));
    }
}
