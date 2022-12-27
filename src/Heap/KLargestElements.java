package Heap;

import java.util.PriorityQueue;

public class KLargestElements {

    public static int[] klargestelements(int[] nums, int k)
    {
        int[] result = new int[k];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(((n1,n2) -> n1 -n2));
        for(int i =0; i < nums.length; i++)
        {
            minHeap.offer(nums[i]);
            if(minHeap.size() > k)
            {
                minHeap.poll();
            }
        }
        for(int i =k - 1; i > 0; i--)
        {
            result[i] = minHeap.poll();
        }
        return  result;
    }
    public static void main(String args[])
    {
        int[] arr = new int[] {4,5,8,9,23,45,67,89,-5,0};
        int[] output = klargestelements(arr, 6);
        for(int i = 0; i < output.length ; i++)
        {
            System.out.printf("K Largest Elements are " + output[i] + "\n");
        }

    }
}
