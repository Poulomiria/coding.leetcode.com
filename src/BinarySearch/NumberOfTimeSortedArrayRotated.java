package BinarySearch;

public class NumberOfTimeSortedArrayRotated {

    public static int BinarySearch(int[] nums, int ele)
    {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high)
        {
            int mid = low + (high - low)/2;
            if(nums[mid] == ele)
            {
                return  mid;
            }else if(nums[mid] >= nums[low])
            {
             if(ele >= nums[low] && ele < nums[mid])
                 high = mid - 1;
             else
                 low = mid + 1;
            }else {
                if(ele >= nums[high] && ele < nums[mid])
                {
                    low = mid +1;
                }else {
                    high = mid - 1;
                }
            }
        }
        return  -1;
    }
}
