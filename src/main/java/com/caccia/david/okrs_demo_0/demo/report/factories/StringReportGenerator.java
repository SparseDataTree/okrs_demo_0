package com.caccia.david.okrs_demo_0.demo.report.factories;

import com.caccia.david.okrs_demo_0.demo.report.interfaces.ReportGeneration;
import com.caccia.david.okrs_demo_0.demo.report.objects.*;

import java.util.Date;
import java.util.List;

import static com.caccia.david.okrs_demo_0.demo.report.factories.ReportHeaders.*;
import static com.caccia.david.okrs_demo_0.demo.report.factories.StringFormatConstants.*;

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
        b.append(ObjectivesHeader);
        for(List<ObjectiveAndKeyResults> okrVersions: teamOKRs.values())
        {
            ObjectiveAndKeyResults okr = okrVersions.get(okrVersions.size() - 1);
            b.append(makeOkrText(okr));
        }
        return b.toString();
    }

      String makeOkrText(ObjectiveAndKeyResults okr)
    {
        StringBuffer b = new StringBuffer();
        b.append(makeObjectiveText(okr.getObjective()));
        b.append(KeyResultsHeader);
        for(KeyResult keyResult: okr.getKeyResults().values())
        {
            b.append(makeKeyResultText(keyResult));
        }
        return b.toString();
    }

     String makeObjectiveText(Objective objective)
    {
        StringBuffer b = new StringBuffer();
//        b.append(ObjectivesHeader);
        b.append(String.format(ID_DATE_FORMAT,OBJECTIVE_ID_KEY, objective.getElementId().getObjectiveId(),getTime(objective.getTime())));
        b.append(LINE_SEPARATOR);
        b.append(LINE_SEPARATOR);
        b.append(objective.getElement());
        b.append(LINE_SEPARATOR);
        b.append(LINE_SEPARATOR);
        return b.toString();
    }

    String makeKeyResultText(KeyResult keyResult)
    {
        StringBuffer b = new StringBuffer();
//        b.append(KeyResultHeader);
        b.append(String.format(ID_DATE_FORMAT,KEY_RESULT_ID_KEY, keyResult.getElementId(),getTime(keyResult.getTime())));
        b.append(LINE_SEPARATOR);
        b.append(LINE_SEPARATOR);
        b.append(keyResult.getElement());
        b.append(LINE_SEPARATOR);
        b.append(LINE_SEPARATOR);
        return b.toString();
    }

    @Override
    public  String makeTeamContextReport(String teamId, List<ReportImpl> reports)
    {
        return new TeamContextualStringFormatter().format(teamId, reports);
    }
}
