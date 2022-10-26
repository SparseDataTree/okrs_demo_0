package com.caccia.david.okrs_demo_0.demo.report.objects;

import com.caccia.david.okrs_demo_0.demo.report.interfaces.Formater;
import com.caccia.david.okrs_demo_0.demo.report.interfaces.HierarchicalId;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// todo let's make unit tests for this.
@Component
public class StringFormater implements Formater<String, String, List<ReportImpl>>
{
    private static final String BLANK_LINE = System.lineSeparator();
    private static final String ID = "Report ID: ";
    private static final String NODE_SEPARATOR = "====================================================================" + BLANK_LINE;


    /*
        This will be a vertical list of reports, starting with the designated team, and working up the tree.  Once that has been done,

         */
    StringBuffer b = new StringBuffer();

    @Override
    public String format(String id, List<ReportImpl> input)
    {
        HierarchicalId nodeId = prereport(id,input);
        List<ReportImpl> reports = filter(nodeId, input);
        return format(input);
    }

    private HierarchicalId prereport(String id, List<ReportImpl> input)
    {
        Optional<ReportImpl> teamReport = input.stream().findAny().filter(findLeaf(id));

        makeNodeReport(teamReport.get());

        return teamReport.get().getElementId();
    }

    private void makeNodeReport(ReportImpl report)
    {
        b.append(ID + report.getElementId());
        b.append(BLANK_LINE);
        b.append(report.getReport());
        b.append(NODE_SEPARATOR);
        b.append(NODE_SEPARATOR);
    }

    @Override
    public String format(List<ReportImpl> input)
    {
        for(ReportImpl report: input)
        {
            makeNodeReport(report);
        }
        return b.toString();
    }

    private List<ReportImpl> filter(HierarchicalId id, List<ReportImpl> input)
    {
        List<ReportImpl> filteredList = input.stream().filter(remove(id)).collect(Collectors.toList());
        List<ReportImpl> newList = new LinkedList<>();
        for(String leaf: id.getIdList())
        {
            if(id.hasParent(leaf))
            {
                String parent = id.getParent(leaf);
                Optional<ReportImpl> report = input.stream().filter(findLeaf(parent)).findAny();
                newList.add(report.get());
                input.remove(report.get());
            }
            newList.addAll(input);
        }

        return newList;
    }

    private Predicate<? super ReportImpl> findLeaf(String id)
    {
        return (Predicate<ReportImpl>) report -> report.getElementId().isLeaf(id);
    }

    private Predicate<? super ReportImpl> remove(HierarchicalId elementIdIn)
    {
        String elementId = elementIdIn.toString();
        return (Predicate<ReportImpl>) report -> !report.getElementId().toString().equals(elementId);
    }
}
