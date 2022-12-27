package Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
https://leetcode.com/problems/top-k-frequent-elements/
Time : O(nlogk)
Space : O(k)
 */
public class KMostFrequentElements {

    public static int[] topKFrequent(int[] nums, int k)
    {
        if (k == nums.length) {
            return nums;
        }

        Map<Integer, Integer> countMap = new HashMap<>();

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> (countMap.get(a) - countMap.get(b)));
        //store the frequency of the elements
        for (int n: nums) {
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        }
        for(Integer temp : countMap.keySet())
        {
            minHeap.add(temp);
            if(minHeap.size() > k)
            {
                minHeap.poll();
            }

        }
        int[] output = new int[k];
        for(int i = k - 1; i >= 0; --i)
        {
            output[i] = minHeap.poll();
        }
        return output;
    }

public static void main(String args[])
{    int[] arr = new int[]{1,1,1,1,2,2,2,3,3,4,4,4,4,4,5,5,5};
     int[] result = topKFrequent(arr, 3);
     for(int i : result)
{
    System.out.println(i);
}
}
}