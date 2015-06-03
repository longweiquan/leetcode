import org.junit.*;

/**
 * Created by 8002273 on 6/3/2015.
 */
public class MaximalSquareTest {

    @Test
    public void test(){

        char[][] level0 = new char[][]{};

        char[][] level1 = new char[][]{
            {1},
        };

        char[][] level2 = new char[][]{
            {1, 0, 1, 0, 0},
            {1, 0, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 0, 0, 1, 0}
        };

        MaximalSquareSolution solution = new MaximalSquareSolution();
        Assert.assertEquals(0, solution.maximalSquare(level0));
        Assert.assertEquals(1, solution.maximalSquare(level1));
        Assert.assertEquals(4, solution.maximalSquare(level2));
    }
}
