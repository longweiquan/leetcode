
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 8002273 on 3/17/2015.
 */
public class HammingWeightTest {

    private HammingWeight solution = new HammingWeight();

    @Test
    public void test(){
        int i = 1 << 31;
        System.out.println(Long.toString(i & 0xFFFFFFFFL));
        Assert.assertEquals(1, solution.hammingWeight(i));
    }
}
