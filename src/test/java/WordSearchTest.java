import org.junit.Test;

/**
 * Created by longweiquan on 15/7/19.
 */
public class WordSearchTest {

    @Test
    public void test(){
        WordSearch solution = new WordSearch();

        char[][] board = {
            {'o','a','a','n'},
            {'e','t','a','e'},
            {'i','h','k','r'},
            {'i','f','l','v'}
        };
        String[] words = {"oath","pea","eat","rain"};

        solution.findWords(board, words);
    }
}
