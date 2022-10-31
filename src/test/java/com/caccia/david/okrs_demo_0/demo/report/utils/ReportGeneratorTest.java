package com.caccia.david.okrs_demo_0.demo.report.utils;

import com.caccia.david.okrs_demo_0.demo.report.objects.KeyResult;
import com.caccia.david.okrs_demo_0.demo.report.objects.OkrMapImpl;
import com.caccia.david.okrs_demo_0.demo.report.objects.ReportImpl;
import com.caccia.david.okrs_demo_0.demo.report.objects.TestUtil;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ReportGeneratorTest
{
    ReportGenerator reportGenerator = new ReportGenerator();

    @Test
    void makeTeamReport()
    {
        // todo not yet.  Let's develop tests for dependencies first
        OkrMapImpl okrMap = TestUtil.makeTestOkrMap();
        ReportImpl report = reportGenerator.makeTeamReport(okrMap);
        assertThat(report).isNotNull();
    }

    @Test
    void makeReportText()
    {
        // todo
    }

    @Test
    void makeOkrText()
    {
        // todo
    }

    @Test
    void makeKeyResultText()
    {
        KeyResult keyResult = TestUtil.makeTestKeyResult();
        String keyResultText = reportGenerator.makeKeyResultText(keyResult);
        assertThat(keyResultText).isNotNull();
    }

    @Test
    void makeTeamContextReport()
    {
        // todo
    }
}