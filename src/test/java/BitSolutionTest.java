
import org.junit.Assert;
import org.junit.Test;
import org.lwq.BitSolution;

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

    @Test
    public void testRotate(){
        int[] nums = new int[]{1,2,3,4,5,6,7};
        int[] expected = new int[]{5,6,7,1,2,3,4};
        solution.rotate(nums, 3);
        Assert.assertArrayEquals(expected, nums);
    }
}
