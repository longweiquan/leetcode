package string;

import org.assertj.core.api.Assertions;

import java.util.*;

/**
 * Solution : BFS
 */
public class WordLadder {

    class Node{
        String word;
        int distance;
        Node(String word, int distance){
            this.word = word;
            this.distance = distance;
        }
    }

    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {

        LinkedList<Node> nodes = new LinkedList<>();
        nodes.add(new Node(beginWord, 1));
        wordDict.add(endWord);

        while(!nodes.isEmpty()){

            Node node = nodes.removeFirst();

            if(node.word.equals(endWord)){
                return node.distance;
            }

            char[] chars = node.word.toCharArray();
            for(int i=0;i<chars.length;i++){
                char temp = chars[i];
                for(char c='a';c<='z';c++){
                    if(temp != c){
                        chars[i] = c;

                        String word = String.valueOf(chars);
                        if(wordDict.contains(word)){
                            wordDict.remove(word);
                            nodes.add(new Node(word, node.distance+1));
                        }
                    }
                }
                chars[i] = temp;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        WordLadder solution = new WordLadder();
        Set<String> wordDict = new HashSet<>(Arrays.asList("hot", "dot","dog", "lot", "log"));
        Assertions.assertThat(solution.ladderLength("hit", "cog", wordDict)).isEqualTo(5);
    }
}
