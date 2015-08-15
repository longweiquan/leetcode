import org.assertj.core.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by longweiquan on 15/8/15.
 *
 * Solutions : DFS using stack to stock temporal results. when string get 0, add temporal results to results set.
 *
 */
public class PalindromePartitioning {

    private List<List<String>> results;
    private Stack<String> histories;

    public List<List<String>> partition(String s) {

        if(s.length()==0){
            return new ArrayList<>();
        }

        results = new ArrayList<>();
        histories = new Stack<>();
        dfs(s);

        return results;
    }

    public void dfs(String s){

        if(s.length() == 0){
            results.add(new ArrayList<>(histories));
        }

        for(int i=1;i<=s.length();i++){
            String first = s.substring(0,i);
            if(isPalindrome(first)){
                histories.push(first);
                dfs(s.substring(i, s.length()));
                histories.pop();
            }
        }
    }

    private boolean isPalindrome(String s){

        if(s.length()<2){
            return true;
        }

        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i) != s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning solution = new PalindromePartitioning();

        Assertions.assertThat(solution.partition("aab")).containsOnlyElementsOf(Arrays.asList(
            Arrays.asList("aa", "b"),
            Arrays.asList("a", "a", "b")
        ));
    }
}
