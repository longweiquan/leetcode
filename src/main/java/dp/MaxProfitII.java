package dp;

import org.assertj.core.api.Assertions;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions
 * at the same time (ie, you must sell the stock before you buy again).
 */
public class MaxProfitII {

    public int maxProfit(int[] prices) {

        int profit = 0;
        int previous = Integer.MAX_VALUE;

        for(int price: prices){
            profit += Math.max(0, price - previous);
            previous = price;
        }

        return profit;
    }

    public static void main(String[] args) {
        MaxProfitII solution = new MaxProfitII();
        Assertions.assertThat(solution.maxProfit(new int[]{1,3,6,4,6,2,1,7,5})).isEqualTo(13);
    }
}
