package org.lwq.dp;

import org.assertj.core.api.Assertions;

/**
 * Created by longweiquan on 15/8/16.
 */
public class MaxProduct {

    public int maxProduct(int[] nums) {

        int n = nums.length;
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return nums[0];
        }

        int localMax = nums[0];
        int localMin = nums[0];
        int globalMax = nums[0];

        for(int i=1;i<n;i++){

            int n1 = nums[i]*localMax;
            int n2 = nums[i]*localMin;

            localMax = Math.max(Math.max(n1, n2), nums[i]);
            localMin = Math.min(Math.min(n1, n2), nums[i]);
            globalMax = Math.max(globalMax, localMax);
        }

        return globalMax;
    }

    public static void main(String[] args) {
        MaxProduct solution = new MaxProduct();
        Assertions.assertThat(solution.maxProduct(new int[]{2,3,-2,4})).isEqualTo(6);
        Assertions.assertThat(solution.maxProduct(new int[]{-4,-3})).isEqualTo(12);
    }
}
