import org.junit.Assert;
import org.junit.Test;

/**
 * Created by longweiquan on 15/7/27.
 */
public class DungeonGameTest {

    @Test
    public void test(){
        DungeonGame solution = new DungeonGame();

        int result = solution.calculateMinimumHP(new int[][]{
            {-2, -3,  3},
            {-5, -10, 1},
            {10, 30, -5}
        });
        Assert.assertEquals(7, result);
    }
}
