package org.lwq.dp;

import org.assertj.core.api.Assertions;

/**
 * Created by longweiquan on 15/8/16.
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {

        if(nums.length == 0){
            return 0;
        }

        int local = nums[0];
        int global = nums[0];

        for(int i=1;i<nums.length;i++){
            local = Math.max(local+nums[i], nums[i]);
            global = Math.max(global, local);
        }

        return global;
    }

    public static void main(String[] args) {
        MaxSubArray solution = new MaxSubArray();

        Assertions.assertThat(solution.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4})).isEqualTo(6);
        Assertions.assertThat(solution.maxSubArray(new int[]{2,-1,2})).isEqualTo(3);
    }
}
