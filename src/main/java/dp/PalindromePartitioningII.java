package dp;

import org.assertj.core.api.Assertions;

/**
 * Created by longweiquan on 15/8/15.
 *
 * Solution : Dynamic Programming
 *
 * DP Equation for cut :
 *          cut[j] represents the minimal cut in string [0..j]
 *          cut[j] = min(cut[j], cut[i-1] + 1) if string[i..j] is palindrome
 *
 * DP Equation for palindrome :
 *          p[i][j] represents if string[i..j] is palindrome or not
 *          p[i][j] = true if s[i] == s[j] && (p[i+1][j-1] = true or there's at most one character between i and j)
 *
 */
public class PalindromePartitioningII {

    public int minCut(String s) {

        int n = s.length();

        boolean p[][] = new boolean[n][n];
        int cut[] = new int[n];

        for(int j=0;j<n;j++){
            cut[j] = j; // init to maximum cut

            for(int i=0;i<=j;i++){
                if(s.charAt(i) == s.charAt(j) && (j-i <= 1 || p[i+1][j-1])){
                    p[i][j] = true;

                    if(i>0){
                        cut[j] = Math.min(cut[j], cut[i-1]+1);
                    } else {
                        cut[j] = 0;
                    }
                }
            }
        }

        return cut[n-1];
    }

    public static void main(String[] args) {
        PalindromePartitioningII solution = new PalindromePartitioningII();
        Assertions.assertThat(solution.minCut("aab")).isEqualTo(1);
        Assertions.assertThat(solution.minCut("ababababababababababababcbabababababababababababa")).isEqualTo(0);
    }
}
