package org.lwq;

import org.assertj.core.api.Assertions;

import java.util.*;

/**
 * Created by longweiquan on 15/7/19.
 *
 * Solution : Depth First Search with org.lwq.Trie to optimize the word comparison
 *
 */
public class WordSearchII {

    private Set<String> results;
    private char[][] board;
    private Trie trie;
    boolean[][] visited;

    public List<String> findWords(char[][] board, String[] words) {

        // false input
        if(board == null || board.length == 0 || words == null || words.length == 0){
            return new ArrayList<String>();
        }

        this.board = board;
        int X = board.length;
        int Y = board[0].length;
        visited = new boolean[X][Y];
        results = new HashSet<>();


        // build org.lwq.Trie
        trie = new Trie();
        for(String word: words){
            trie.insert(word);
        }


        // for each character in the table
        for(int i=0; i<X; i++){
            for(int j=0;j<Y;j++){
                dfs("", i, j);
            }
        }

        return new ArrayList<>(results);
    }

    private void dfs(String word, int x, int y){

        if(x<0 || x>=board.length || y<0 || y>=board[0].length || visited[x][y]){
            return;
        }

        word += board[x][y];
        if(trie.startsWith(word)){

            if(trie.search(word)){
                results.add(word);
            }

            visited[x][y] = true;
            dfs(word, x-1, y);
            dfs(word, x+1, y);
            dfs(word, x, y-1);
            dfs(word, x, y+1);
            visited[x][y] = false;
        }
    }

    public static void main(String[] args){
        WordSearchII solution = new WordSearchII();

        char[][] board = {
            {'o','a','a','n'},
            {'e','t','a','e'},
            {'i','h','k','r'},
            {'i','f','l','v'}
        };
        String[] words = {"oath","pea","eat","rain"};
        Assertions.assertThat(solution.findWords(board, words)).containsOnlyElementsOf(Arrays.asList("eat", "oath"));

        board = new char[][]{{'b','a','b','b','a'}};
        words = new String[]{"baa","abba","baab","aba"};
        Assertions.assertThat(solution.findWords(board, words)).containsOnlyElementsOf(Arrays.asList("abba"));
    }
}
