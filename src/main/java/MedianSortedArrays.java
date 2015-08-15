import org.junit.Assert;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by longweiquan on 15/7/18.
 */
public class MedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        List<Integer> A = IntStream.of(nums1).boxed().collect(Collectors.toList());
        List<Integer> B = IntStream.of(nums2).boxed().collect(Collectors.toList());

        int k = (A.size()+B.size()) / 2;
        if((A.size()+B.size())%2 == 0){
            return (findKth(A, B, k) + findKth(A, B, k+1)) * 0.5;
        } else {
            return findKth(A,B,k+1);
        }
    }

    private int findKth(List<Integer> A, List<Integer> B, int k){

        if(A.size() > B.size()){
            // always keep A's size smaller than B
            return findKth(B, A, k);
        }
        if (A.size()==0 && B.size()>0){
            // when no element in A, we return the B's Kth element
            return B.get(k-1);
        }
        if(k == 1){
            // search hit limit
            return Math.min(A.get(0), B.get(0));
        }

        // divide A and B to tow part by K/2
        int i = Math.min(A.size(), k / 2);
        int j = k-i;

        if(A.get(i-1) > B.get(j-1)){
            return findKth(A.subList(0, i), B.subList(j, B.size()), i);
        } else {
            return findKth(A.subList(i, A.size()), B.subList(0, j), j);
        }
    }

    public static void main(String[] args){
        MedianSortedArrays solution = new MedianSortedArrays();

        double median;

        median = solution.findMedianSortedArrays(   new int[]{1, 3, 5, 6, 9}, new int[]{2,4,7,8});
        Assert.assertEquals(median, 5f, 0.01f);

        median = solution.findMedianSortedArrays(new int[]{1,3,5,6,9}, new int[]{2,4,7,8,10});
        Assert.assertEquals(median, 5.5f, 0.01f);

        median = solution.findMedianSortedArrays(new int[]{1}, new int[]{2,3,4});
        Assert.assertEquals(median, 2.5f, 0.01f);
    }
}
