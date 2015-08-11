package medmanage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class MainTest {

    @Test
    public void testInsertMax() throws Exception {
        Main main = new Main();
//        String[] args = new String[0];
        main.grabFile("Sample");
        int next;
        for (int i = 0;i<main.n;i++){
            next = Integer.parseInt(main.argInput[i]);
            main.insertMax(next);
        }
        Assert.assertTrue(true);
        int max = main.lowHeap.get(0);
        int num6 = main.lowHeap.get(5);
        Assert.assertEquals("The max item should be 90", 90, max);
        Assert.assertEquals("Item 6 should be 7", 7, num6);
    }

    @Test
    public void testGrabFile() throws Exception {
        Main main = new Main();
        main.grabFile("Sample");
        Assert.assertEquals("File length should be 10", 10, main.n);
        Assert.assertEquals("Second entry should be 7", "7", main.argInput[1]);
    }

//    @Test
//    public void testInsertMax2() throws Exception {
////        Main main = new Main();
////        String[] args = new String[0];
//        Main.grabFile("Sample");
//        int next;
//        for (int i = 0;i<Main.n;i++){
//            next = Integer.parseInt(Main.argInput[i]);
//            Main.insertMax(next);
//        }
//        Assert.assertTrue(true);
//        int max = Main.lowHeap.get(0);
//        int num6 = Main.lowHeap.get(5);
//        Assert.assertEquals("The max item should be 90", 90, max);
//        Assert.assertEquals("Item 6 should be 7", 7, num6);
//    }

    @Before
    public void setUp() throws Exception {


    }

    @After
    public void tearDown() throws Exception {


    }

    @Test
    public void testInsertMin() throws Exception {
        Main main = new Main();
        String[] args = new String[0];
        main.grabFile("Sample");
        int next;
        for (int i = 0;i<main.n;i++){
            next = Integer.parseInt(main.argInput[i]);
            main.insertMin(next);
        }
        Assert.assertTrue(true);
        int max = main.highHeap.get(0);
        int num2 = main.highHeap.get(1);
        Assert.assertEquals("The min item should be 1", 1, max);
        Assert.assertEquals("Item 2 should be 3", 3, num2);
    }
}