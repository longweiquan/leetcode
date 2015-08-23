package dp;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;

import java.util.*;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 *
 * Return all such possible sentences.
 */
public class WordBreakII {

    public List<String> wordBreak(String s, Set<String> wordDict) {

        int maxWordLength = 0;
        for(String word: wordDict){
            maxWordLength = Math.max(maxWordLength, word.length());
        }
        int n = s.length();

        if(n == 0 || maxWordLength == 0 || !isValid(s, wordDict)){
            return new ArrayList<>();
        }

        Map<Integer, List<String>> dp = new HashMap<>();

        for(int j=1;j<=n;j++){
            for(int i=j-1; i>=j-maxWordLength; i--){
                if((i==0 || dp.get(i) != null) && wordDict.contains(s.substring(i,j))){

                    // init list
                    if(dp.get(j) == null){
                        dp.put(j, new ArrayList<>());
                    }

                    String word = s.substring(i, j);
                    if(i == 0){
                        dp.get(j).add(word);
                    } else {
                        for(int k=0; k<dp.get(i).size();k++){
                            dp.get(j).add(dp.get(i).get(k) + " " + word);
                        }
                    }
                }
            }
        }

        if(dp.get(n) != null){
            return dp.get(n);
        } else {
            return new ArrayList<>();
        }
    }

    private boolean isValid(String s, Set<String> wordDict) {

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
        WordBreakII solution = new WordBreakII();

        String s = "catsanddog";
        Set<String> wordDict = new HashSet<>(Arrays.asList("cat", "cats", "and", "sand", "dog"));

        Assertions.assertThat(solution.wordBreak(s, wordDict))
            .containsOnlyElementsOf(Arrays.asList("cats and dog", "cat sand dog"));

        s = "aaaaaaa";
        wordDict = new HashSet<>(Arrays.asList("aaaa","aa"));
        Assertions.assertThat(solution.wordBreak(s, wordDict))
            .containsOnlyElementsOf(Lists.emptyList());

        s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        wordDict = new HashSet<>(Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"));
        Assertions.assertThat(solution.wordBreak(s, wordDict))
            .containsOnlyElementsOf(Lists.emptyList());

    }
}
