package com.caccia.david.okrs_demo_0.demo.report.objects;

import com.caccia.david.okrs_demo_0.demo.report.interfaces.Formater;
import com.caccia.david.okrs_demo_0.demo.report.interfaces.HierarchicalId;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// todo let's make unit tests for this.
@Component
public class StringFormater implements Formater<String, List<ReportImpl>>
{
    /*
    This will be a vertical list of reports, starting with the designated team, and working up the tree.  Once that has been done,

     */
    StringBuffer b = new StringBuffer();

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
        // todo make report text.  put it into the string buffer
    }

    @Override
    public String format(List<ReportImpl> input)
    {
        // todo implement
        return b.toString();
    }

    private List<ReportImpl> filter(HierarchicalId id, List<ReportImpl> input)
    {
        List<ReportImpl> filteredList = input.stream().filter(check(id)).collect(Collectors.toList());

        // todo order these.  Put elemente from id in order; leave others as is.

        return filteredList;
    }

    private Predicate<? super ReportImpl> findLeaf(String id)
    {
        return (Predicate<ReportImpl>) report -> report.getElementId().isLeaf(id);
    }

    private Predicate<? super ReportImpl> check(HierarchicalId elementIdIn)
    {
        String elementId = elementIdIn.toString();
        return (Predicate<ReportImpl>) report -> report.getElementId().toString().equals(elementId);
    }
}
