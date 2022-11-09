package com.caccia.david.okrs_demo_0.demo.report.factories;

import com.caccia.david.okrs_demo_0.demo.report.interfaces.ObjectiveKRsId;
import com.caccia.david.okrs_demo_0.demo.report.objects.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class StringReportGeneratorTest
{
    StringReportGenerator reportGenerator = new StringReportGenerator();

    // This is a full team report including team-level headers and metadata
    @Test
    void makeTeamReport()
    {

        OkrMapImpl okrMap = TestUtil.makeTestOkrMap();
        ReportImpl report = reportGenerator.makeTeamReport(okrMap);
        assertThat(report).isNotNull(); // todo more validation
    }

    // This is the text of a team report, laying out the objectives and key results
    @Test
    void makeReportText()
    {
        OkrMapImpl okrMap = TestUtil.makeTestOkrMap();
        String reportText = reportGenerator.makeReportText(okrMap);
        assertThat(reportText).isNotNull(); // todo more validation
    }

    // This is the text of a single objective and its associated key results
    @Test
    void makeOkrText()
    {
        // todo let's clean up the output for this.
        OkrMapImpl okrMap = TestUtil.makeTestOkrMap();
        String objectiveId = TestUtil.okrKeys[0];
        ObjectiveKRsId okrKey = TestUtil.makeObjectiveIdThree(objectiveId);
        List<ObjectiveAndKeyResults> okr = okrMap.get(okrKey);
        String okrText = reportGenerator.makeOkrText(okr.get(0));
        assertThat(okrText).isNotNull(); // todo more validation
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