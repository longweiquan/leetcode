package org.lwq;

import org.junit.Assert;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Max Sliding Window Solution.
 *
 * Data Structure : use deque as temporal summit value in a sliding window
 *
 * Algorithm :
 *  1. If deque is empty or new value is smaller than last element in deque, push element to deque.
 *  2. If element is bigger than last deque element, remove last element from deque and repeat the step
 *  3. When loop index is bigger than window size, get first element from deque as correspondent result
 *  4. When the first element of deque is out of loop index, remove it from deque
 */
public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {

        if(k==0){
            return new int[]{};
        }

        int[] max = new int[nums.length - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=0;i<nums.length;i++){
            while(!deque.isEmpty() && nums[deque.getLast()] <= nums[i]){
                deque.removeLast();
            }
            deque.addLast(i);

            if(i+1 >= k){
                max[i+1-k] = nums[deque.getFirst()];

                if(i+1-k >= deque.getFirst()){
                    deque.removeFirst();
                }
            }
        }

        return max;
    }

    public static void main(){

        MaxSlidingWindow solution = new MaxSlidingWindow();

        Assert.assertArrayEquals(
            new int[]{},
            solution.maxSlidingWindow(new int[]{}, 0));


        Assert.assertArrayEquals(
            new int[]{1},
            solution.maxSlidingWindow(new int[]{1}, 1));


        Assert.assertArrayEquals(
            new int[]{3,3,5,5,6,7},
            solution.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3));

        Assert.assertArrayEquals(
            new int[]{3,3,-1,5,5,6,7},
            solution.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 2));
    }
}
