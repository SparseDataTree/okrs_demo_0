package com.caccia.david.okrs_demo_0.demo.report.objects;

import com.caccia.david.okrs_demo_0.demo.report.interfaces.HierarchicalId;
import com.caccia.david.okrs_demo_0.demo.report.objects.ids.HierarchicalIdImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HierarchicalIdImplTest
{

    HierarchicalIdImpl testList = TestUtil.makeTestList();


    @Test
    void getIdList()
    {
        List<String> ids = testList.getIdList();
        assertIdsMatchExpected(ids, TestUtil.testPaths);
    }

    private void assertIdsMatchExpected(List<String> ids, String[] testPaths)
    {
        assertNotNull(ids);
        assertNotNull(testPaths);
        assertEquals(ids.size(), testPaths.length);
        for(int i = 0; i < ids.size(); i++)
        {
            assertEquals(ids.get(i),testPaths[i]);
        }
    }

    @Test
    void isPresent()
    {
        assertTrue(testList.isPresent("dir"));
        assertFalse(testList.isPresent("apples"));
    }

    @Test
    void getRootId()
    {
        assertEquals(testList.getRootId(),"root");
        assertNotEquals(testList.getRootId(),"dev");
    }

    @Test
    void isLeaf()
    {
        assertFalse(testList.isLeaf("root"));
        assertFalse(testList.isLeaf("dir"));
        assertTrue(testList.isLeaf("developer"));
    }

    @Test
    void hasParent()
    {
        assertTrue(testList.hasParent("developer"));
        assertTrue(testList.hasParent("dir"));
        assertFalse(testList.hasParent("root"));
    }

    @Test
    void getParent()
    {
        assertEquals(testList.getParent("developer"),"team");
        assertNotEquals(testList.getParent("manager"),"root");
    }

    @Test
    void hasChild()
    {
        assertFalse(testList.hasChild("developer"));
        assertTrue(testList.hasChild("dir"));
        assertTrue(testList.hasChild("root"));
    }

    @Test
    void getChild()
    {
        assertEquals(testList.getChild("team"),"developer");
        assertNotEquals(testList.getChild("manager"),"dir");
    }

    @Test
    void getHierarchicalId()
    {
        HierarchicalId subId = testList.getHierarchicalId("manager");
        assertTrue(subId.isLeaf("manager"));
        assertEquals(subId.getParent("manager"),"dir");
        assertEquals(subId.getParent("dir"),"root");
    }

    @Test
    void testToString()
    {
        String stringId = testList.toString();
        assert(stringId.equals("root -> dir -> manager -> team -> developer"));
    }
}