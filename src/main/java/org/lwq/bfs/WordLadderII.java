package org.lwq.bfs;

import org.assertj.core.api.Assertions;

import java.util.*;

/**
 * Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:
 *
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 *
 * Solution : BFS
 */
public class WordLadderII {

    class Node{
        String word;
        int distance;
        Node prev;
        Node(String word, int distance, Node prev){
            this.word = word;
            this.distance = distance;
            this.prev = prev;
        }
    }

    public List<List<String>> findLadders(String start, String end, Set<String> dict) {

        LinkedList<Node> nodes = new LinkedList<>();
        nodes.add(new Node(start, 1, null));
        dict.add(end);

        Set<String> visited = new HashSet<>();
        List<List<String>> results = new ArrayList<>();
        int currentDistance = 1;
        int endDistance = Integer.MAX_VALUE;

        while (!nodes.isEmpty()){

            Node node = nodes.removeFirst();
            if(node.word.equals(end)){
                List<String> result = new LinkedList<>();
                Node current = node;
                while (current != null){
                    result.add(0, current.word);
                    current = current.prev;
                }
                results.add(result);
                endDistance = node.distance;
                continue;
            }

            if(node.distance > endDistance){
                break;
            }

            if(node.distance > currentDistance){
                currentDistance = node.distance;
                dict.removeAll(visited);
                visited.clear();
            }

            char[] chars = node.word.toCharArray();
            for(int i=0; i<chars.length; i++){
                char temp = chars[i];
                for(char c='a'; c<='z'; c++){
                    if(temp != c){
                        chars[i] = c;

                        String word = String.valueOf(chars);
                        if(dict.contains(word)){
                            visited.add(word);
                            nodes.add(new Node(word, node.distance+1, node));
                        }
                    }
                }
                chars[i] = temp;
            }
        }

        return results;
    }

    public static void main(String[] args) {
        WordLadderII solution =  new WordLadderII();
        Set<String> wordDict = new HashSet<>(Arrays.asList("hot", "dot", "dog", "lot", "log"));
        //Assertions.assertThat(solution.findLadders("hit", "cog", wordDict)).hasSize(2);

        wordDict = new HashSet<>(Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln",
            "tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho",
            "ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb",
            "sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st",
            "er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"));
        Assertions.assertThat(solution.findLadders("qa", "sq", wordDict)).hasSize(51);
    }
}
