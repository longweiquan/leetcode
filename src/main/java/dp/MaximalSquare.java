package dp;

import org.junit.Assert;

/**
 * Created by 8002273 on 6/3/2015.
 */
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {

        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){

                int v = Character.getNumericValue(matrix[i][j]);

                if(v == 1 && i > 0 && j > 0){
                    int min = Math.min(dp[i-1][j], dp[i][j-1]);
                    min = Math.min(min, dp[i-1][j-1]);
                    dp[i][j] = min + 1;
                } else {
                    dp[i][j] = v;
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        return max * max;
    }

    public static void main(String[] args){

        char[][] level0 = new char[][]{};

        char[][] level1 = new char[][]{
            {'1'},
        };

        char[][] level2 = new char[][]{
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'}
        };

        MaximalSquare solution = new MaximalSquare();
        Assert.assertEquals(0, solution.maximalSquare(level0));
        Assert.assertEquals(1, solution.maximalSquare(level1));
        Assert.assertEquals(4, solution.maximalSquare(level2));
    }
}
