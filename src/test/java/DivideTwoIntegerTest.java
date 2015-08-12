import org.junit.Assert;
import org.junit.Test;

/**
 * Created by longweiquan on 15/7/29.
 */
public class DivideTwoIntegerTest {

    private DivideTwoInteger solution = new DivideTwoInteger();

    @Test
    public void test(){
        Assert.assertEquals(Integer.MAX_VALUE, solution.divide(30, 0));
        Assert.assertEquals(30, solution.divide(30, 1));
        Assert.assertEquals(3, solution.divide(30, 9));
        Assert.assertEquals(-3, solution.divide(-30, 9));
        Assert.assertEquals(-3, solution.divide(30, -9));
        Assert.assertEquals(3, solution.divide(30, 9));
    }

}
