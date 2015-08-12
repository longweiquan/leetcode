/**
 * Created by longweiquan on 15/7/29.
 */
public class DivideTwoInteger {

    public int divide(int dividend, int divisor) {

        if(divisor == 0){
            return Integer.MAX_VALUE;
        }

        boolean positive = !((dividend < 0) ^ (divisor < 0));



        int positiveResult = divide2(Math.abs(dividend), Math.abs(divisor));
        return positive ? positiveResult : -positiveResult;
    }

    private int divide2(int dividend, int divisor){
        if(dividend < divisor){
            return 0;
        } else if(divisor == 1){
          return dividend;
        } else {
            return 1+divide2(dividend-divisor, divisor);
        }
    }
}
