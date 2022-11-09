package com.caccia.david.okrs_demo_0.demo.report.objects;

import com.caccia.david.okrs_demo_0.demo.report.interfaces.Comment;
import com.caccia.david.okrs_demo_0.demo.report.interfaces.ObjectiveKRsId;
import com.caccia.david.okrs_demo_0.demo.report.interfaces.Thread;
import com.caccia.david.okrs_demo_0.demo.report.interfaces.HierarchicalId;
import com.caccia.david.okrs_demo_0.demo.report.objects.ids.HierarchicalIdImpl;
import com.caccia.david.okrs_demo_0.demo.report.objects.ids.ObjectiveKRsIdsImpl;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

public class TestUtil
{
    static String[] wordArray = new String[]{"I", "amk", "geing", "go", "wzll", "yvu", "we", "hlve", "wgll", "dtg", "cur", "hopse",
            "mefting","thibk","aqe","rbn", "stqp", "bzs", "boqk", "malh", "numders", "friwnd", "stqre","stpr", "zop", "moy",
    "czp", "swkm", "wavk", "yakn", "bime", "hikve", "tewt", "coqld","colpd", "hawpy", "saed", "begfin", "in", "opwt", "abeve"};

    static Random random = new Random(System.currentTimeMillis());

    public static String[] testPaths = new String[]{"root", "dir", "manager", "team", "developer"};
    public static String[] reportPaths = new String[]{"alpha", "beta", "gamma", "delta", "epsilon"};
    public static String[] okrKeys = new String[]{"Stronger", "Faster", "Smarter"};

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
        report.setElementId(hierarchicalId);
        report.setDate(new Date(1700000000000L + random.nextInt(50000000)));
        try
        {
            report.setLink(new URI("https://mockedlinkfortesting.com/home/enterprise/team/"+ UUID.randomUUID()));
        } catch (URISyntaxException e)
        {
            throw new RuntimeException(e);
        }
        return report;
    }

    private static String makeReportText()
    {
        int wordsPerLine = 12;
        StringBuffer b = new StringBuffer();
        int lineCount = 5 + random.nextInt(10);
        makeLinesOfText(wordsPerLine, b, lineCount);

        return b.toString();
    }

    private static void makeLinesOfText(int wordsPerLine, StringBuffer b, int lineCount)
    {
        for(int i = 0; i < lineCount; i++)
        {
            for(int j = 0; j < wordsPerLine; j++)
            {
                b.append(wordArray[random.nextInt(wordArray.length)]).append(" ");
            }
                b.append(System.lineSeparator());

        }
    }

    private static String makeLinesOfText(int wordsPerLine, int lineCount)
    {
        StringBuffer b = new StringBuffer();
        makeLinesOfText( wordsPerLine, b,  lineCount);
        return b.toString();
    }

    public static OkrMapImpl makeTestOkrMap()
    {
        OkrMapImpl okrs = new OkrMapImpl();
        okrs.setTeamName("Test team name");
        okrs.setTime(new Date(System.currentTimeMillis()));
        okrs.setLink(URI.create("https://dummylink.com/home"));
        okrs.setElementId(new HierarchicalIdImpl(Arrays.asList("abc","def")));

        for(String key: okrKeys)
        {

            ObjectiveKRsId objectiveKRsId = makeObjectiveIdThree(key);
            okrs.put(objectiveKRsId, makeTestOkr(objectiveKRsId));
        }

        return okrs;
    }

    public static ObjectiveKRsId makeObjectiveIdThree(String key)
    {
        int keyResultCount = 3;
        ObjectiveKRsIdsImpl objectiveId = new ObjectiveKRsIdsImpl();
        objectiveId.setObjectiveId(key);
        Set<String> keyResultIds = new HashSet<>();
        for(int i = 0; i < keyResultCount; i++)
        {
            keyResultIds.add("testKeyResult-" + i);
        }
        objectiveId.setKeyResultIds(keyResultIds);
        return objectiveId;
    }

    private static List<ObjectiveAndKeyResults> makeTestOkr(ObjectiveKRsId objectiveKRsId)
    {

        List<ObjectiveAndKeyResults> objectiveAndKeyResultList = new LinkedList<>();
        Set<String> krIds = objectiveKRsId.getKeyResultIds();
        ObjectiveAndKeyResults okr = new ObjectiveAndKeyResults();
        Objective objective = makeObjective(objectiveKRsId);
        // todo maybe generate comments
        okr.setObjective(objective);
        okr.setKeyResults(makeKeyResults(krIds));
        objectiveAndKeyResultList.add(okr);
        return objectiveAndKeyResultList;
    }

    private static Objective makeObjective(ObjectiveKRsId objectiveKRsId)
    {
        Objective objective = new Objective();
        objective.setTime(new Date(System.currentTimeMillis()));
        objective.setElementId(objectiveKRsId);
        objective.setObjective(makeLinesOfText(8,3));
        return objective;
    }

    private static Map<String, KeyResult> makeKeyResults(Set<String> krIds)
    {
        Map<String, KeyResult> krs = new HashMap<>();
        for(String key: krIds)
        {
            krs.put(key, makeKeyResult(key));
        }
        return krs;
    }

    private static KeyResult makeKeyResult(String key)
    {
        KeyResult kr = new KeyResult();
        kr.setTime(new Date(System.currentTimeMillis()));
        kr.setElementId(key);
        kr.setElement(makeLinesOfText(7,4));
        // todo maybe generate comments
        return kr;
    }

    public static KeyResult makeTestKeyResult()
    {
        KeyResult testKeyResult = new KeyResult();
        testKeyResult.setTime(new Date(System.currentTimeMillis()));
        testKeyResult.setElementId("testKeyResultId");
        testKeyResult.setThreads(makeTestThreads());
        testKeyResult.setElement("test key result");
        return testKeyResult;
    }

    private static Set<Thread<String, Date, String>> makeTestThreads()
    {
        Set<Thread<String, Date, String>> threads = new HashSet<>();
        Thread<String, Date, String> thread =  new ThreadImpl();
        thread.getThread().add(makeTestComment());
        threads.add(thread);
        return threads;
    }

    private static Comment<String, Date, String> makeTestComment()
    {
        CommentImpl comment = new CommentImpl();
        comment.setTime(new Date(System.currentTimeMillis()));
        comment.setComment("test comment");
        return comment;
    }
}
