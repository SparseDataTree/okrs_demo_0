package com.caccia.david.okrs_demo_0.demo.report.objects;

import java.util.Arrays;
import java.util.List;

public class TestUtil
{
    public static String[] testPaths = new String[]{"root", "dir", "manager", "team", "developer"};
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
}
