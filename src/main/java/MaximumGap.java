/**
 * Algorithm : Bucket Sort
 *
 * Solution :
 *  Suppose there are N elements and they are ranged from A to B.
 *  Then maximum gap will be no smaller than ceiling((B-A)/(N-1)), which is defined as bucket length L.
 *  Then we can divide space from A to B into (B-A)/L + 1 buckets.
 *  Then we put elements into buckets and keep the min and max in each bucket.
 *  The max gap will not be in a bucket but between buckets.
 *  For each no empty bucket, find out next no empty bucket and calculate the potential gaps.
 *  Then find out the maximum gap from all potential gaps.
 *
 *
 */
public class MaximumGap {

    public int maximumGap(int[] nums) {

        if(nums == null || nums.length < 2){
            return 0;
        } else if(nums.length == 2){
            return Math.abs(nums[0] - nums[1]);
        }

        // find out N, A, B
        int N = nums.length;
        int A = nums[0];
        int B = nums[0];

        for(int v : nums){
            A = Math.min(A, v);
            B = Math.max(B, v);
        }

        // Divide A-B space to M buckets
        // Each bucket's range is L
        int L = (B-A)/(N-1) + 1;
        int M = (B-A)/ L + 1;
        int[][] buckets = new int[M][];

        // put elements into buckets
        for(int v : nums){
            int index = (v - A) / L;
            if(buckets[index] == null){
                buckets[index] = new int[]{v,v};
            } else {
                buckets[index][0] = Math.min(buckets[index][0], v);
                buckets[index][1] = Math.max(buckets[index][1], v);
            }
        }

        int maxGap = 0;
        int[] previous = new int[]{A,A};
        for(int[] current : buckets){
            if(current != null){
                maxGap = Math.max(maxGap, current[0] - previous[1]);
                previous = current;
            }
        }

        return maxGap;
    }
}
