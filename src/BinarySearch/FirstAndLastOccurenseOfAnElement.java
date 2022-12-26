package BinarySearch;
/*
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
Poulomi Roy Chowdhury
 */
public class FirstAndLastOccurenseOfAnElement {

    public static int BinarySearchFirstOccurence(int[] nums, int ele)
    {
        int low = 0;
        int high = nums.length - 1;
        int result = 0;
        System.out.println("element is" +ele);
        while(low <= high)
        {
            int mid = low + (high - low)/2;   // Integer overloading problem
            if(nums[mid] == ele)
            {
                result = mid;
                high = mid - 1;
            }else if(ele < nums[mid])
            {
                high = mid - 1;
            }else {
                low = mid+1;
            }
        }
        return result;
    }
    public static int BinarySearchLastOccurence(int[] nums, int ele)
    {
        int low = 0;
        int high = nums.length - 1;
        int result = 0;
        while(low <= high)
        {
            int mid = low + (high - low)/2;   // Integer overloading problem
            if(mid == low || nums[mid -1] != ele)
            {
                result = mid;
                low = mid + 1;

            }else if(ele < nums[mid] )
            {
                high = mid - 1;
            }else {
                low = mid+1;
            }
        }
        return result;

    }
    public static int BinarySearchCountAnElement(int[] nums, int ele)
    {
        int first = BinarySearchFirstOccurence(nums, 3);
        int second = BinarySearchLastOccurence(nums, 3);

        System.out.println("First occurence" + BinarySearchFirstOccurence(nums, 3));
        System.out.println("Last occurence" + BinarySearchLastOccurence(nums, 3));
        return second - first + 1;
    }
    public static  void main(String args[])
    {
        int[] arr = new int[] {-3,0,3,3,3,4,5,67};
        int ele = 2;
        System.out.println(BinarySearchCountAnElement(arr, 3));

    }

}
