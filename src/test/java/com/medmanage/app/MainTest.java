package com.medmanage.app;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MainTest {
//changes
    @Test
    public void testInsertMax() throws Exception {
        Main.grabFile("Sample");
        int next;
        for (int i = 0; i < Main.n; i++) {
            next = Integer.parseInt(Main.argInput[i]);
            Main.insertMax(next);
        }
        Assert.assertTrue(true);
        int max = Main.lowHeap.get(0);
        int num6 = Main.lowHeap.get(5);
        Assert.assertEquals("The max item should be 90", 90, max);
        Assert.assertEquals("Item 6 should be 7", 7, num6);
    }

    @Test
    public void testGrabFile() throws Exception {
        Main.grabFile("Sample");
        Assert.assertEquals("File length should be 10", 10, Main.n);
        Assert.assertEquals("Second entry should be 7", "7", Main.argInput[1]);
    }

    @Test
    public void testParse() throws Exception {
        Main.grabFile("Sample");
        Main.parse();
        Assert.assertTrue(true);
        Assert.assertEquals("The rolling sum is 122 at the end", 122, Main.sumMedians);
    }

    @Test
    public void testExtractMin() throws Exception {
        Main.grabFile("Sample");
        int next;
        for (int i = 0; i < Main.n; i++) {
            next = Integer.parseInt(Main.argInput[i]);
            Main.insertMin(next);
        }
//        log("Before extracting:");
//        Main.printHigh();
        Main.extractMin();
        Assert.assertTrue(true);
        int check = Main.highHeap.get(2);
//        log("I extracted: " + Main.hold);
//        Main.printHigh();
        Assert.assertEquals("The first extracted value should be 1", 1, Main.hold);
        Assert.assertEquals("The third entry is 17", 17, check);
    }

    @Before
    public void setUp() throws Exception {
        System.gc();
        Main.reset();
    }

    //
    @After
    public void tearDown() throws Exception {
        System.gc();
    }

    @Test
    public void testInsertMin() throws Exception {
        Main.grabFile("Sample");
        int next;
        for (int i = 0; i < Main.n; i++) {
            next = Integer.parseInt(Main.argInput[i]);
            Main.insertMin(next);
        }
        Assert.assertTrue(true);
        int max = Main.highHeap.get(0);
        int num2 = Main.highHeap.get(1);
        Assert.assertEquals("The min item should be 1", 1, max);
        Assert.assertEquals("Item 2 should be 3", 3, num2);
    }
}