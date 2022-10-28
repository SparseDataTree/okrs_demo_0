package com.caccia.david.okrs_demo_0.demo.report.objects;

import com.caccia.david.okrs_demo_0.demo.report.interfaces.Formater;
import com.caccia.david.okrs_demo_0.demo.report.interfaces.HierarchicalId;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
public class StringFormater implements Formater<String, String, List<ReportImpl>>
{
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String ID = "Report ID: ";
    private static final String NODE_SEPARATOR = "====================================================================" + LINE_SEPARATOR;
    private static final String TEAM_REPORT = "Team Report: ";
    private static final String CHAINED_REPORTS = "Chained Reports: ";
    private static final String SUBSCRIBED_REPORTS = "Subscribed Reports: ";
    private static final String SPACES = "     ";
    private static final String DATE = "Last updated: ";
    private static final String LINK = "Link: ";


    /*
        This will be a vertical list of reports, starting with the designated team, and working up the tree.  Once that has been done,
        reports from subscribed teams follow.
         */
    StringBuffer b = new StringBuffer();
    private int coreReportCount = 0;

    @Override
    public String format(String id, List<ReportImpl> input)
    {
        HierarchicalId nodeId = prereport(id,input);
        List<ReportImpl> reports = filter(nodeId, input);
        return format(reports);
    }

    private HierarchicalId prereport(String id, List<ReportImpl> input)
    {
        Optional<ReportImpl> teamReport = input.stream().filter(findLeaf(id)).findAny();
        b.append(LINE_SEPARATOR);
        b.append(LINE_SEPARATOR);
        b.append(TEAM_REPORT);
        b.append(LINE_SEPARATOR);
        b.append(LINE_SEPARATOR);

        makeNodeReport(teamReport.get());
        b.append(LINE_SEPARATOR);
        b.append(LINE_SEPARATOR);
        b.append(CHAINED_REPORTS);
        b.append(LINE_SEPARATOR);
        b.append(LINE_SEPARATOR);

        return teamReport.get().getElementId();
    }

    private void makeNodeReport(ReportImpl report)
    {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd:hh-mm");
        String time = df.format(report.getDate());
        b.append(ID + report.getElementId() + SPACES + DATE + time);
        b.append(LINE_SEPARATOR);
        b.append(LINE_SEPARATOR);
        b.append(report.getReport());
        b.append(LINE_SEPARATOR);
        b.append(LINE_SEPARATOR);
        b.append(LINK + report.getLink().toString());
        b.append(LINE_SEPARATOR);
        b.append(LINE_SEPARATOR);
        b.append(NODE_SEPARATOR);
        b.append(NODE_SEPARATOR);
    }

    @Override
    public String format(List<ReportImpl> input)
    {

        for(int i = 0; i < input.size(); i++)
        {
            ReportImpl report = input.get(i);
            if(i == coreReportCount)
            {
                b.append(LINE_SEPARATOR);
                b.append(LINE_SEPARATOR);
                b.append(SUBSCRIBED_REPORTS);
                b.append(LINE_SEPARATOR);
                b.append(LINE_SEPARATOR);
            }
            makeNodeReport(report);
        }
        return b.toString();
    }

    private List<ReportImpl> filter(HierarchicalId id, List<ReportImpl> input)
    {
        List<ReportImpl> filteredList = input.stream().filter(remove(id)).collect(Collectors.toList());
        List<ReportImpl> newList = new LinkedList<>();
        boolean hasParent = id.getIdList().size() > 1;
        String leaf = id.getLeaf();
        while(hasParent)
        {
            String parent = id.getParent(leaf);
            Optional<ReportImpl> report = filteredList.stream().filter(findLeaf(parent)).findAny();
            newList.add(report.get());
            filteredList.remove(report.get());
            hasParent = id.hasParent(parent);
            leaf = parent;
        }
        coreReportCount = newList.size();

        newList.addAll(filteredList);

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
