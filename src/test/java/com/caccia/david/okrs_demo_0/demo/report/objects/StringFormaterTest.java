package com.caccia.david.okrs_demo_0.demo.report.objects;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringFormaterTest
{

    List<ReportImpl> reportList = TestUtil.makeReportList();
    StringFormater formater = new StringFormater();


    @Test
    void testFormat()
    {
        String report = formater.format(TestUtil.reportPaths[3], reportList);

        System.out.println(report);
    }
}