package org.lwq.dp;

import org.assertj.core.api.Assertions;

/**
 * Best Time to Buy and Sell Stock.
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 */
public class MaxProfitI {

    public int maxProfit(int[] prices) {

        int profit = 0;
        int min = Integer.MAX_VALUE;

        for(int price:prices){
            profit = Math.max(profit, price - min);
            min = Math.min(min, price);
        }

        return profit;
    }

    public static void main(String[] args) {
        MaxProfitI solution = new MaxProfitI();
        Assertions.assertThat(solution.maxProfit(new int[]{1,3,5,4,3,6,8})).isEqualTo(7);
        Assertions.assertThat(solution.maxProfit(new int[]{2,3,5,4,1,6,8})).isEqualTo(7);
    }
}
