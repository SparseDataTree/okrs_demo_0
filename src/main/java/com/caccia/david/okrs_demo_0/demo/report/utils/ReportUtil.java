package com.caccia.david.okrs_demo_0.demo.report.utils;

import com.caccia.david.okrs_demo_0.demo.report.interfaces.Formater;
import com.caccia.david.okrs_demo_0.demo.report.interfaces.Report;
import com.caccia.david.okrs_demo_0.demo.report.objects.ReportImpl;
import com.caccia.david.okrs_demo_0.demo.report.objects.StringFormater;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ReportUtil
{
    /*
        We want to take a set of reports and output a (for now) text report.  Perhaps a stretch goal would be to output
        a formatted report, maybe md or html or pdf?

        What if ids were not text.  What if they were a list of ids, in order of hierarchy?
        That would make some aspect of report creation easier.  It might also make team navigation easier too.

     */

    @Autowired
    static StringFormater formater;

    static String makeTextReport( List<ReportImpl> reports)
    {
        return formater.format(reports);
    }

}
