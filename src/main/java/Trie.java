/**
 * Created by longweiquan on 15/7/25.
 */
public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        root.insert(word);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        return true;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return true;
    }

    public static class TrieNode {

        private TrieNode[] children;
        private char value;

        public void insert(String word){

        }


    }
}
