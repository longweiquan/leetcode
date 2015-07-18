
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by longweiquan on 15/7/18.
 */
public class NQueensTest {

    @Test
    public void test(){
        NQueens solution = new NQueens();

        Assert.assertEquals(0, solution.totalNQueens(0));
        Assert.assertEquals(1, solution.totalNQueens(1));
        Assert.assertEquals(0, solution.totalNQueens(2));
        Assert.assertEquals(0, solution.totalNQueens(3));
        Assert.assertEquals(2, solution.totalNQueens(4));
        Assert.assertEquals(10, solution.totalNQueens(5));
        Assert.assertEquals(92, solution.totalNQueens(8));
    }
}
