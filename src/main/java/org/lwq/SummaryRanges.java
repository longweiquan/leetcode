package org.lwq;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by longweiquan on 15/8/12.
 *
 * [0,1,2,4,5,7] => ["0->2","4->5","7"]
 */
public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> results = new ArrayList<>();

        if(nums.length > 0){

            // use start and end pointer
            int start = 0;
            int end = 0;

            // loop on end pointer
            while(end < nums.length){
                // two break conditions
                if(end+1 == nums.length || nums[end]+1 < nums[end+1]){
                    if(start == end){
                        results.add(Integer.toString(nums[start]));
                    } else {
                        results.add(nums[start]+"->"+nums[end]);
                    }
                    start = end+1;
                }
                end++;
            }
        }
        return results;
    }
}
