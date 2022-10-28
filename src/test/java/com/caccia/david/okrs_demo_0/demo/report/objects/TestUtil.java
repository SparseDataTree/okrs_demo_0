package com.caccia.david.okrs_demo_0.demo.report.objects;

import com.caccia.david.okrs_demo_0.demo.report.interfaces.HierarchicalId;

import java.util.*;

public class TestUtil
{
    static String[] wordArray = new String[]{"I", "am", "going", "go", "will", "you", "we", "have", "will", "dog", "car", "house",
            "meeting","think","ate","ran", "stop", "bus", "book", "math", "numbers", "friend", "store","star", "zip", "may",
    "cup", "swim", "walk", "yawn", "bike", "hike", "tent", "could","cold", "happy", "sad", "begin", "in", "out", "above"};

    static Random random = new Random(System.currentTimeMillis());

    public static String[] testPaths = new String[]{"root", "dir", "manager", "team", "developer"};
    public static String[] reportPaths = new String[]{"alpha", "beta", "gamma", "delta", "epsilon"};
    public static HierarchicalIdImpl makeTestList()
    {
        List<String> paths = makeTestPaths(testPaths);
        HierarchicalIdImpl testList = new HierarchicalIdImpl(paths);
        return testList;
    }

    private static List<String> makeTestPaths(String... pathsIn)
    {
        List<String> testPaths = Arrays.asList(pathsIn);

        return testPaths;
    }

    public static List<ReportImpl> makeReportList()
    {

        HierarchicalIdImpl nodeId = new HierarchicalIdImpl(Arrays.asList(reportPaths));
        List<ReportImpl> reportList = new LinkedList<>();

        for(String path:reportPaths)
        {
            reportList.add(makeReport(nodeId.getHierarchicalId(path)));
        }
        return reportList;
    }

    private static ReportImpl makeReport(HierarchicalId hierarchicalId)
    {
        ReportImpl report = new ReportImpl();
        report.setReport(makeReportText());
        report.setNodeId(hierarchicalId);
        return report;
    }

    private static String makeReportText()
    {
        int wordsPerLine = 12;
        StringBuffer b = new StringBuffer();
        int lineCount = 5 + random.nextInt(10);
        for(int i = 0; i < lineCount; i++)
        {
            for(int j = 0; j < wordsPerLine; j++)
            {
                b.append(wordArray[random.nextInt(wordArray.length)]).append(" ");
            }
                b.append(System.lineSeparator());

        }

        return b.toString();
    }
}
