import java.util.ArrayList;
import java.util.List;

public class BitSolution {

    /**
     * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).
     *
     * For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
     *
     * @param n : you need treat n as an unsigned value
     * @return result
     *
     */
    public int hammingWeight(int n) {

        int result = 0;
        while(n != 0){
            result += (n & 1);
            n = n >>> 1;
        }
        return result;
    }

    /**
     * Reverse bits of a given 32 bits unsigned integer.
     *
     * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).
     *
     * @param n : you need treat n as an unsigned value
     * @return results
     */
    public int reverseBits(int n) {
        int result = 0;
        int left = 1;
        int right = 1 << 31;
        for(int i=0; i<32;i++){
            if((n & right) != 0){
                result |= left;
            }
            left <<= 1;
            right >>>= 1;
        }
        return result;
    }

    /**
     * Rotate an array of n elements to the right by k steps.
     *
     * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
     *
     * @param nums array
     * @param k position to rotate
     */
    public void rotate(int[] nums, int k) {
        int[] copy = new int[nums.length];

        for(int i=0;i<nums.length;i++){
            copy[i] = nums[i];
        }

        for(int i=0; i<nums.length; i++){
            nums[(i+k)%nums.length]=copy[i];
        }
    }

    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.
     *
     * Design an algorithm to find the maximum profit. You may complete at most k transactions.
     *
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {

        if(prices.length < 3 && k < 2){
            return 0;
        }

        List<Integer> peaks = new ArrayList<Integer>();
        List<Integer> hollows = new ArrayList<Integer>();

        for(int i=0; i<prices.length; i++){

            if(i==0 || i==prices.length-1){
                peaks.add(i);
                hollows.add(i);
            } else {
                if(isPeak(prices[i-1], prices[i], prices[i+1], true)){
                    peaks.add(i);
                }
                if(isPeak(prices[i-1], prices[i], prices[i+1], false)){
                    hollows.add(i);
                }
            }
        }

        int max = 0;
        for(int peak: peaks){
            for(int hollow:hollows){
                if(peak > hollow && prices[peak] - prices[hollow] > max){
                    max = prices[peak] - prices[hollow];
                }
            }
        }

        return max;
    }

    public boolean isPeak(int i1, int i2, int i3, boolean peak){
        return (i2 >= i1 && i2 <= i3) == peak;
    }

}
