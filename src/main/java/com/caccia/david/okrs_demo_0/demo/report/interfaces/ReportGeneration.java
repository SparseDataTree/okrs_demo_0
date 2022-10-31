package com.caccia.david.okrs_demo_0.demo.report.interfaces;

import com.caccia.david.okrs_demo_0.demo.report.objects.OkrMapImpl;
import com.caccia.david.okrs_demo_0.demo.report.objects.ReportImpl;

import java.util.List;

public interface ReportGeneration<R extends Report,T>
{
    /*
            We want to take a set of reports and output a (for now) text report.  Perhaps a stretch goal would be to output
            a formatted report, maybe md or html or pdf?

            What if ids were not text.  What if they were a list of ids, in order of hierarchy?
            That would make some aspect of report creation easier.  It might also make team navigation easier too.

         */
    // TODO make some tests for this method.
    R makeTeamReport(OkrMapImpl teamOKRs);

    T makeTeamContextReport(String teamId, List<R> reports);
}
