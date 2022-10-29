package com.caccia.david.okrs_demo_0.demo.report.utils;

import com.caccia.david.okrs_demo_0.demo.report.objects.*;

import java.util.Date;
import java.util.List;

public class ReportUtil
{
    /*
        We want to take a set of reports and output a (for now) text report.  Perhaps a stretch goal would be to output
        a formatted report, maybe md or html or pdf?

        What if ids were not text.  What if they were a list of ids, in order of hierarchy?
        That would make some aspect of report creation easier.  It might also make team navigation easier too.

     */

    static ReportImpl makeReport(OkrMapImpl teamOKRs)
    {
        ReportImpl report = new ReportImpl();
        report.setLink(teamOKRs.getLink());
        report.setDate(new Date(System.currentTimeMillis()));
        report.setElementId(teamOKRs.getElementId());
        report.setReport(makeReportText(teamOKRs));
        return report;
    }

    private static String makeReportText(OkrMapImpl teamOKRs)
    {
        StringBuffer b = new StringBuffer();
        // todo header?
        for(List<ObjectiveAndKeyResults> okrVersions: teamOKRs.values())
        {
            // todo header?
            ObjectiveAndKeyResults okr = okrVersions.get(okrVersions.size() - 1);
            b.append(makeOkrText(okr));
            // todo separators?
        }
        return b.toString();
    }

    private static String makeOkrText(ObjectiveAndKeyResults okr)
    {
        StringBuffer b = new StringBuffer();
        b.append(okr.getObjective().getElement().getElement());
        for(KeyResult keyResult: okr.getKeyResults().values())
        {
            b.append(makeKeyResultText(keyResult));

        }
        return b.toString();
    }

    private static String makeKeyResultText(KeyResult keyResult)
    {
        StringBuffer b = new StringBuffer();
        // todo make header
        b.append(keyResult.getKeyResult().getElement());
        // todo make separator

        return b.toString();
    }


    static String makeTextReport( String teamId, List<ReportImpl> reports)
    {
        return new StringFormater().format(teamId, reports);
    }

}
