package org.lwq;

import org.assertj.core.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by longweiquan on 15/8/16.
 */
public class FindSubstring {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> results = new ArrayList<>();

        for(String word: words){
            results.add(s.indexOf(word));
        }
        return results;
    }

    public static void main(String[] args) {
        FindSubstring solution = new FindSubstring();
        Assertions.assertThat(solution.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}))
            .containsOnlyElementsOf(Arrays.asList(0, 9));
    }
}
