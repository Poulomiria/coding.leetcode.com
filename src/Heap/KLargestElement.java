package Heap;

import java.util.PriorityQueue;

public class KLargestElement {
    public static int Klargest(int[] nums, int k)
    {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1,n2) -> n1-n2);
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
        System.out.println(Klargest(arr, k));
    }
}
