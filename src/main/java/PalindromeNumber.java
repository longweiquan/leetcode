/**
 * Created by longweiquan on 15/8/13.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {

        // not negative
        if(x<0){
            return false;
        }

        // find out divisor for the first number
        int div = 1;
        while(x/div >= 10){
            div *= 10;
        }

        // the result is reduced to zero
        while(x != 0){

            int first = x / div; // if x is smaller than div, first becomes 0
            int last = x % 10;
            if(first != last){
                return false;
            }

            // remove first and last
            x = x % div / 10;

            // reduce divisor
            div = div / 100;
        }
        return true;
    }
}
