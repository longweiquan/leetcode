import org.junit.Assert;
import org.junit.Test;

/**
 * Created by longweiquan on 15/7/18.
 */
public class MaxSlidingWindowTest {

    @Test
    public void test(){

        MaxSlidingWindow solution = new MaxSlidingWindow();

        Assert.assertArrayEquals(
                new int[]{},
                solution.maxSlidingWindow(new int[]{}, 0));


        Assert.assertArrayEquals(
                new int[]{1},
                solution.maxSlidingWindow(new int[]{1}, 1));


        Assert.assertArrayEquals(
                new int[]{3,3,5,5,6,7},
                solution.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3));

        Assert.assertArrayEquals(
                new int[]{3,3,-1,5,5,6,7},
                solution.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 2));
    }
}
