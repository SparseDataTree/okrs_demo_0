package com.caccia.david.okrs_demo_0.demo.report.objects;

import org.junit.jupiter.api.Test;

import java.util.List;

class TeamContextualStringFormaterTest
{

    List<ReportImpl> reportList = TestUtil.makeReportList();
    TeamContextualStringFormater formater = new TeamContextualStringFormater();


    @Test
    void testFormat()
    {
        String report = formater.format(TestUtil.reportPaths[3], reportList);

        System.out.println(report);
    }
}