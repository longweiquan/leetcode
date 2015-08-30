package org.lwq.dp;

import org.assertj.core.api.Assertions;

/**
 * Created by longweiquan on 15/8/16.
 */
public class EditDistance {

    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        if(m == 0 || n == 0){
            return m+n;
        }

        int[][] dp = new int[m+1][n+1];

        for(int i=0;i<=m;i++){
            dp[i][0] = i;
        }
        for(int j=0;j<=n;j++){
            dp[0][j] = j;
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(word1.charAt(i-1) != word2.charAt(j-1)){
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                } else {
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        EditDistance solution = new EditDistance();
        Assertions.assertThat(solution.minDistance("word", "news")).isEqualTo(4);
        Assertions.assertThat(solution.minDistance("a", "ab")).isEqualTo(1);
    }
}
