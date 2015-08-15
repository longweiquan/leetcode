import java.util.List;

/**
 * Created by longweiquan on 15/7/19.
 */
public class WordSearch {

    public List<String> findWords(char[][] board, String[] words) {

        // TODO

        return null;
    }

    public static void main(String[] args){
        WordSearch solution = new WordSearch();

        char[][] board = {
            {'o','a','a','n'},
            {'e','t','a','e'},
            {'i','h','k','r'},
            {'i','f','l','v'}
        };
        String[] words = {"oath","pea","eat","rain"};

        // TODO complete test
        solution.findWords(board, words);
    }
}
