package org.lwq.number;

import org.assertj.core.api.Assertions;

import java.util.Arrays;

/**
 * Created by longweiquan on 15/8/29.
 */
public class LargestNumber {

    public String largestNumber(int[] nums) {

        String result = Arrays.stream(nums)
            .mapToObj(String::valueOf)
            .sorted((x, y)-> -(x+y).compareTo(y+x))
            .reduce(String::concat)
            .get();

        if(result.charAt(0) == '0'){
            return "0";
        } else {
            return result;
        }
    }

    public static void main(String[] args) {
        LargestNumber solution = new LargestNumber();

        Assertions.assertThat(solution.largestNumber(new int[]{0,0})).isEqualTo("0");
        Assertions.assertThat(solution.largestNumber(new int[]{3, 30, 34, 5, 9})).isEqualTo("9534330");
    }

}
