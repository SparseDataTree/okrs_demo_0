package com.caccia.david.okrs_demo_0.demo.report.factories;

import com.caccia.david.okrs_demo_0.demo.report.interfaces.ReportGeneration;
import com.caccia.david.okrs_demo_0.demo.report.objects.*;

import java.util.Date;
import java.util.List;

import static com.caccia.david.okrs_demo_0.demo.report.factories.ReportHeaders.*;

/*
Compare the purpose of this class to that of the TeamContextualStringFormatter.
This class works at the level of the individual team report
The formatter works at the level of a meta-report that composes multiple-team reports

While this class generates unformatted text, generics allows for development of report generation logic with other types of formats, such as html and md.

*/

public class StringReportGenerator implements ReportGeneration<ReportImpl, String>
{
    /*
        We want to take a set of reports and output a (for now) text report.  Perhaps a stretch goal would be to output
        a formatted report, maybe md or html or pdf?

        What if ids were not text.  What if they were a list of ids, in order of hierarchy?
        That would make some aspect of report creation easier.  It might also make team navigation easier too.

     */

    // todo consider making a data class to provide line format templates and such.

    @Override
    public  ReportImpl makeTeamReport(OkrMapImpl teamOKRs)
    {
        ReportImpl report = new ReportImpl();
        report.setLink(teamOKRs.getLink());
        report.setDate(new Date(System.currentTimeMillis()));
        report.setElementId(teamOKRs.getElementId());
        report.setReport(makeReportText(teamOKRs));
        return report;
    }

      String makeReportText(OkrMapImpl teamOKRs)
    {
        StringBuffer b = new StringBuffer();
        b.append(Objectives);
        for(List<ObjectiveAndKeyResults> okrVersions: teamOKRs.values())
        {
            b.append(Objective);
            ObjectiveAndKeyResults okr = okrVersions.get(okrVersions.size() - 1);
            b.append(makeOkrText(okr));
        }
        return b.toString();
    }

      String makeOkrText(ObjectiveAndKeyResults okr)
    {
        StringBuffer b = new StringBuffer();
        b.append(okr.getObjective().getElement());
        b.append(KeyResults);
        for(KeyResult keyResult: okr.getKeyResults().values())
        {
            b.append(KeyResult);
            b.append(makeKeyResultText(keyResult));

        }
        return b.toString();
    }

      String makeKeyResultText(KeyResult keyResult)
    {
        StringBuffer b = new StringBuffer();
        // todo connect in the formater?
        b.append(keyResult.getElement());

        return b.toString();
    }


    @Override
    public  String makeTeamContextReport(String teamId, List<ReportImpl> reports)
    {
        return new TeamContextualStringFormatter().format(teamId, reports);
    }

}
