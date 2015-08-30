package org.lwq;

import org.junit.Assert;

/**
 * Created by longweiquan on 15/8/14.
 */
public class ConvertToTitle {
    public String convertToTitle(int n) {

        StringBuilder builder = new StringBuilder();

        while(n > 0){
            // transform org.lwq.number to character
            int i = n % 26;
            if(i > 0){
                builder.insert(0, (char) ('A' + i-1));
                n = n / 26;
            } else {
                builder.insert(0, 'Z');
                n = n / 26 - 1;
            }
        }
        return builder.toString();
    }

    public static void main(String[] args){
        ConvertToTitle solution = new ConvertToTitle();
        Assert.assertEquals("DS", solution.convertToTitle(123));
        Assert.assertEquals("Z", solution.convertToTitle(26));
        Assert.assertEquals("ZZ", solution.convertToTitle(702));
        Assert.assertEquals("AAA", solution.convertToTitle(703));
        System.out.println("OK");
    }
}
