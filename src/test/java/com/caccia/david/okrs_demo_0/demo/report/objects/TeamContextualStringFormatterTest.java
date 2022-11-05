package com.caccia.david.okrs_demo_0.demo.report.objects;

import com.caccia.david.okrs_demo_0.demo.report.factories.TeamContextualStringFormatter;
import org.junit.jupiter.api.Test;

import java.util.List;

class TeamContextualStringFormatterTest
{

    List<ReportImpl> reportList = TestUtil.makeReportList();
    TeamContextualStringFormatter formater = new TeamContextualStringFormatter();


    @Test
    void testFormat()
    {
        String report = formater.format(TestUtil.reportPaths[3], reportList);

        System.out.println(report);
    }
}