package BinarySearch;

import java.sql.SQLOutput;

public class BinarySearchSortedArray {

    public static int BinarySearch(int[] nums, int ele)
    {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high)
        {
            int mid = low + (high - low)/2;   // Integer overloading problem
            if(nums[mid] == ele)
            {
                return mid;
            }else if(nums[mid] < ele)
            {
                high = mid - 1;
            }else {
                low = mid+1;
            }
        }
        return -1;

    }
    public static  void main(String args[])
    {
        int[] arr = new int[] {-3,0,3,4,5,67};
        int ele = 2;
        System.out.println(BinarySearch(arr, 2));

    }
}
