package SlidingWindow;
/*
Fixed Size Sliding window
 */
public class MaxSumSubarraySizek {

    public static int maxSum(int[] arr, int k)
    {
        int left = 0;
        int right = 0;
        int max = 0, sum = 0;
        while(right < arr.length)
        {
            sum = sum + arr[right];
            if(right - left + 1 == k)
            {
                max = Math.max(max, sum);
                sum = sum - arr[left++];
                right++;
            }else {
                right++;
            }

        }
        return max;
    }
    public static void main(String args[])
    {
        int[] arr = new int[]{2,3,4,5,67,12,3,4,4};
        System.out.println(maxSum(arr, 3));
    }

}
