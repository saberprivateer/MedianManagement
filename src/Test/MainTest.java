import medmanage.Main;
import org.junit.Assert;
import org.junit.Test;
public class MainTest {

    @Test
    public void testInsertMax() throws Exception {
        Main main = new Main();
        String[] args = new String[0];
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