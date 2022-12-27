package Heap;

import java.util.PriorityQueue;

public class KSmallest {
    public static int KSmallest(int[] nums, int k)
    {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> n2-n1);
        for(int i =0; i < nums.length; i++)
        {
            minHeap.offer(nums[i]);
            if(minHeap.size() > k)
            {
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }
    public static void main(String args[])
    {
        int[] arr = new int[]{3,4,5,7,-1,0,6,3};
        int k = 3;
        System.out.println(KSmallest(arr, k));
    }
}
