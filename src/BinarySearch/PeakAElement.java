package BinarySearch;

public class PeakAElement {

    public static int BinarySearch(int nums[], int target)
    {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            if(mid > 0 && mid < nums.length -1)
            {
                if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1])
                {
                    return mid;
                }else if(nums[mid] > nums[mid - 1])
                {
                    low = mid + 1;
                }else {
                    high = mid -1;
                }

            }else {
                if(mid == 0 && nums[mid] > nums[mid + 1])
                {
                    return mid;
                }else if(mid == nums.length -1 && nums[mid - 1] < nums[mid])
                {
                    return  mid;
                }

            }
        }
    }
}
