package org.lwq.ds;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * Data Structure : Trie derived from Tree, used efficiently for word searching
 */
public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
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

    public boolean search(String word) {
        TrieNode current = getTrieNodeByPrefix(word);
        return current != null && current.isWord;
    }

    public boolean startsWith(String prefix) {
        return getTrieNodeByPrefix(prefix)  != null;
    }

    public TrieNode getTrieNodeByPrefix(String prefix) {
        TrieNode current = root;
        for(char c: prefix.toCharArray()){
            current = current.children.get(c);
            if(current == null){
                break;
            }
        }
        return current;
    }

    class TrieNode {
        char value;
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord = false;
    }

    public static void main(String[] args) {

        Trie trie = new Trie();
        trie.insert("something");
        Assert.assertTrue(trie.startsWith("some"));
        Assert.assertFalse(trie.search("some"));
        Assert.assertTrue(trie.search("something"));
    }
}
