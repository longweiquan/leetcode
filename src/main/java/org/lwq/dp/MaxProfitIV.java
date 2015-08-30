package org.lwq.dp;

import org.assertj.core.api.Assertions;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 *
 * Solution : Dynamic Programming
 *
 * If we force last transaction on the last day, we have two approaches :
 *
 * 1- do a new transaction on the last day
 * 2- replace the last transaction if it was made yesterday
 *
 * And then the best profits will be between making the last transaction in the last day or before.
 *
 */
public class MaxProfitIV {

    public int maxProfit(int k, int[] prices) {

        int n = prices.length;
        if (n < 2 || k <= 0){
            return 0;
        }

        // Dynamic Programming Data Array

        // Best profit array with last transaction on the last day
        int[][] lastMax = new int[n][k + 1];

        // Best profit array
        int[][] globalMax = new int[n][k + 1];

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                int diff = prices[i] - prices[i - 1];

                // do a new transaction on the last day
                // or replace the last transaction if it was made yesterday
                lastMax[i][j] = Math.max(globalMax[i - 1][j - 1], lastMax[i - 1][j]) + diff;

                // Make the last transaction on the last day or not
                globalMax[i][j] = Math.max(globalMax[i - 1][j], lastMax[i][j]);
            }
        }

        return globalMax[n - 1][k];
    }

    public static void main(String[] args) {
        MaxProfitIV solution = new MaxProfitIV();
        Assertions.assertThat(solution.maxProfit(2, new int[]{3,3,5,0,0,3,1,4})).isEqualTo(6);
        Assertions.assertThat(solution.maxProfit(3, new int[]{3,7,5,0,0,3,1,4})).isEqualTo(10);
    }
}
