import org.junit.Assert;

/**
 * Dynamic programming solution
 */
public class DungeonGame {

    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon.length == 0){
            return 0;
        }

        // init m, n and deep first table
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];

        // the most right down dp value
        dp[m - 1][n - 1] = Math.max(1, -dungeon[m - 1][n - 1] + 1);

        // the most right dp value
        for(int i = m - 2; i >= 0; i--){
            dp[i][n - 1] = Math.max(dp[i + 1][n - 1] - dungeon[i][n - 1], 1);
        }

        // the most down dp value
        for(int j = n - 2; j >= 0; j--){
            dp[m - 1][j] = Math.max(dp[m - 1][j + 1] - dungeon[m - 1][j], 1);
        }

        for(int i = m - 2; i >= 0; i--){
            for(int j = n - 2; j >= 0; j--){
                dp[i][j] = Math.max(1, Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args){
        DungeonGame solution = new DungeonGame();

        int result = solution.calculateMinimumHP(new int[][]{
            {-2, -3,  3},
            {-5, -10, 1},
            {10, 30, -5}
        });
        Assert.assertEquals(7, result);
    }

}
