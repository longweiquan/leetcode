import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by longweiquan on 15/7/25.
 */
public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {

        TrieNode current = root;

        for(int i=0;i<word.length();i++){

            char c = word.charAt(i);
            if(!current.children.containsKey(c)){
                TrieNode newNode = new TrieNode();
                newNode.value = c;
                current.children.put(c, newNode);
            }

            current = current.children.get(c);

            if(i+1 == word.length()){
                current.isLeaf = true;
            }
        }
    }

    public boolean search(String word) {

        TrieNode current = getTrieNodeByPrefix(word);
        return current != null && current.isLeaf;
    }

    public boolean startsWith(String prefix) {
        return getTrieNodeByPrefix(prefix)  != null;
    }

    public TrieNode getTrieNodeByPrefix(String prefix) {
        TrieNode current = root;

        for(int i=0;i<prefix.length();i++){

            char c = prefix.charAt(i);
            current = current.children.get(c);
            if(current == null){
                break;
            }
        }
        return current;
    }

    public class TrieNode {

        char value;
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isLeaf = false;
    }

    public static void main(String[] args) {

        Trie trie = new Trie();
        trie.insert("something");
        Assert.assertTrue(trie.startsWith("some"));
        Assert.assertFalse(trie.search("some"));
        Assert.assertTrue(trie.search("something"));
    }

}
