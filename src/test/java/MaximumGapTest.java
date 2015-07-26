
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by longweiquan on 15/7/26.
 */
public class MaximumGapTest {

    @Test
    public void test(){
        MaximumGap solution = new MaximumGap();
        Assert.assertEquals(3, solution.maximumGap(new int[]{5, 1, 4, 6, 8}));
        Assert.assertEquals(9999999, solution.maximumGap(new int[]{1, 10000000}));

        Assert.assertEquals(2901, solution.maximumGap(new int[]{
            15252,16764,27963,7817,26155,20757,3478,22602,20404,
            6739,16790,10588,16521,6644,20880,15632,27078,25463,
            20124,15728,30042,16604,17223,4388,23646,32683,23688,
            12439,30630,3895,7926,22101,32406,21540,31799,3768,26679,
            21799,23740
        }));

    }
}
