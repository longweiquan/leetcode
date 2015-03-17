
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
}
