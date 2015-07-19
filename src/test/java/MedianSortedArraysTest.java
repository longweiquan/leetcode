import org.junit.Assert;
import org.junit.Test;

/**
 * Created by longweiquan on 15/7/19.
 */
public class MedianSortedArraysTest {

    @Test
    public void test(){
        MedianSortedArrays solution = new MedianSortedArrays();

        double median;

        median = solution.findMedianSortedArrays(new int[]{1, 3, 5, 6, 9}, new int[]{2,4,7,8});
        Assert.assertEquals(median, 5f, 0.01f);

        median = solution.findMedianSortedArrays(new int[]{1,3,5,6,9}, new int[]{2,4,7,8,10});
        Assert.assertEquals(median, 5.5f, 0.01f);

        median = solution.findMedianSortedArrays(new int[]{1}, new int[]{2,3,4});
        Assert.assertEquals(median, 2.5f, 0.01f);

    }

}
