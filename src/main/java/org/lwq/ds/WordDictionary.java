package org.lwq.ds;

import org.assertj.core.api.Assertions;

import java.util.HashMap;
import java.util.Map;

/**
 * Data Structure : Trie
 * Algorithm : Use DFS to deal with character '.'
 */
public class WordDictionary {

    TrieNode root = new TrieNode();

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode current = root;
        for(char c: word.toCharArray()){
            if(!current.children.containsKey(c)){
                TrieNode newNode = new TrieNode();
                newNode.value = c;
                current.children.put(c, newNode);
            }
            current = current.children.get(c);
        }
        current.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return dfs(word, root);
    }

    private boolean dfs(String word, TrieNode node){
        if(word.isEmpty()){
            return node.isWord;
        }

        char c = word.charAt(0);
        if (c == '.') {
            for (TrieNode child : node.children.values()) {
                if (dfs(word.substring(1), child)) {
                    return true;
                }
            }
            return false;
        } else {
            return node.children.containsKey(c) && dfs(word.substring(1), node.children.get(c));
        }
    }

    class TrieNode {
        char value;
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord = false;
    }

    public static void main(String[] args) {
        WordDictionary dict = new WordDictionary();
        dict.addWord("bad");
        dict.addWord("dad");
        dict.addWord("mad");
        Assertions.assertThat(dict.search("pad")).isEqualTo(false);
        Assertions.assertThat(dict.search("bad")).isEqualTo(true);
        Assertions.assertThat(dict.search(".ad")).isEqualTo(true);
        Assertions.assertThat(dict.search("b..")).isEqualTo(true);
    }
}
