package org.lwq.dp;

import org.assertj.core.api.Assertions;

/**
 * Created by longweiquan on 15/8/20.
 */
public class MinCoin {

    public int minCoin (int[] coins, int sum){

        int[] min = new int[sum+1];
        min[0] = 0;

        for(int i=1; i<=sum; i++){
            min[i] = Integer.MAX_VALUE;
            for(int coin: coins){
                if(i >= coin && min[i-coin] != Integer.MAX_VALUE && min[i-coin]+1<min[i]){
                    min[i] = min[i-coin]+1;
                }
            }
        }
        return min[sum];
    }

    public static void main(String[] args) {
        MinCoin solution = new MinCoin();
        Assertions.assertThat(solution.minCoin(new int[]{3,5}, 11)).isEqualTo(3);
    }

}
