package org.lwq.dp;

import org.assertj.core.api.Assertions;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 */
public class MaxProfitIII {

    public int maxProfit(int[] prices) {

        int n = prices.length;
        if(n == 0){
            return 0;
        }

        int[][] profits = new int[3][n];
        int[][] currents = new int[3][n];

        for(int i=1;i<=2;i++){
            for(int j=1;j<n;j++){

                int diff = prices[j]-prices[j-1];

                // If we sell on ith day, on have two approach to reach it from previous state
                // 1. with i-1 transactions in j-1 day add the transaction in the jth day
                // 2. with i transactions in the j-1 day knowing that ith transaction was in j-1,
                // so replace last transaction by j day
                currents[i][j] = Math.max(profits[i-1][j-1], currents[i][j-1]) + diff;

                // Compare profits with the last transaction in the last day or not
                profits[i][j] = Math.max(profits[i][j-1], currents[i][j]);
            }
        }

        return profits[2][n-1];
    }

    public static void main(String[] args) {
        MaxProfitIII solution = new MaxProfitIII();
        Assertions.assertThat(solution.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4})).isEqualTo(6);
    }
}
