package org.lwq.dp;

import org.assertj.core.api.Assertions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by longweiquan on 15/8/23.
 */
public class WordBreak {

    public boolean wordBreak(String s, Set<String> wordDict) {

        int n = s.length();
        boolean[] dp = new boolean[n+1];

        for(int j = 1; j<=n;j++){
            for(int i=j-1; i>=0; i--){
                if((i==0 || dp[i]) && wordDict.contains(s.substring(i,j))){
                    dp[j] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        WordBreak solution = new WordBreak();
        String s = "leetcode";
        Set<String> dict = new HashSet(Arrays.asList("leet", "code"));
        Assertions.assertThat(solution.wordBreak(s, dict)).isEqualTo(true);
    }
}
