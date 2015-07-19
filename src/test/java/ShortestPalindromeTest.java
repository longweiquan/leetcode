
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by longweiquan on 15/7/18.
 */
public class ShortestPalindromeTest {

    @Test
    public void test(){
        ShortestPalindrome solution = new ShortestPalindrome();
        Assert.assertEquals("aaacecaaa", solution.shortestPalindrome("aacecaaa"));
        Assert.assertEquals("dcbabcd", solution.shortestPalindrome("abcd"));
    }
}
