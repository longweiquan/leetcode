package org.lwq.dp;

import org.assertj.core.api.Assertions;

/**
 * Created by longweiquan on 15/8/30.
 */
public class DecodeWays {

    public int numDecodings(String s) {

        int n = s.length();
        if(n == 0){
            return 0;
        }

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for(int i=2;i<=n;i++){

            String p1 = s.substring(i-1, i);
            if(dp[i-1] > 0 && p1.compareTo("1") >= 0 && p1.compareTo("9") <= 0){
                dp[i] += dp[i-1];
            }

            String p2 = s.substring(i-2, i);
            if(dp[i-2] > 0 && p2.compareTo("10") >= 0 && p2.compareTo("26") <= 0){
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        DecodeWays solution = new DecodeWays();
        Assertions.assertThat(solution.numDecodings("0")).isEqualTo(0);
        Assertions.assertThat(solution.numDecodings("00")).isEqualTo(0);
        Assertions.assertThat(solution.numDecodings("010")).isEqualTo(0);
        Assertions.assertThat(solution.numDecodings("12")).isEqualTo(2);
        Assertions.assertThat(solution.numDecodings("10")).isEqualTo(1);
        Assertions.assertThat(solution.numDecodings("1020")).isEqualTo(1);
        Assertions.assertThat(solution.numDecodings("123")).isEqualTo(3);
        Assertions.assertThat(solution.numDecodings("1220")).isEqualTo(2);
    }
}
