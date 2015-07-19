import java.util.stream.IntStream;

/**
 * KMP String match pattern solution
 *
 * Data Structure :
 *  p is the match degree array
 */
public class ShortestPalindrome {

    public String shortestPalindrome(String s) {

        String reverse = new StringBuilder(s).reverse().toString();
        String l = new StringBuilder(s).append("#").append(reverse).toString();

        int[] p = new int[l.length()];

        for(int i=1; i<l.length(); i++){
            int j = p[i-1];
            while(j>0 && l.charAt(i) != l.charAt(j)){
                j = p[j-1];
            }
            p[i] = j+ (l.charAt(i) == l.charAt(j) ? 1 : 0);
        }

        return new StringBuilder(reverse.substring(0, s.length() - p[p.length - 1])).append(s).toString();
    }
}
