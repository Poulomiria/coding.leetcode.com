package SlidingWindow;

import java.util.*;

/*

First negative number when window size is k
fixed size sliding window approach
 */
public class FirstNegativeNumberWindowSizeK {

    public static List<Integer> firstnagatives(int[] arr, int k)
    {
        Queue<Integer> q = new LinkedList<>();
        int left = 0;
        int right = 0;
        List<Integer> ans = new ArrayList<>();
        while(right < arr.length)
        {
            if(arr[right] < 0)
            {
                q.add(arr[right]);
            }
            if(right - left + 1 == k)
            {
                if(q.isEmpty())
                {
                    ans.add(0);

                }else {
                    ans.add(q.poll());
                }

                left++;
            }else {
                right++;
            }
        }
        return ans;
    }
    public static void main(String args[])
    {
        int[] input = new int[] {4,-1,-3,-4,0,9,-5,0,-3,-6};
int k = 3;
        System.out.println(firstnagatives(input, k));
    }
}
