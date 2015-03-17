
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 8002273 on 3/17/2015.
 */
public class BitSolutionTest {

    private BitSolution solution = new BitSolution();

    @Test
    public void testHammingWeight(){
        int i = 1 << 31;
        Assert.assertEquals(1, solution.hammingWeight(i));
    }

    @Test
    public void testReverseBits(){
        int i = 1 << 31;
        Assert.assertEquals(i, solution.reverseBits(1));
    }
}
