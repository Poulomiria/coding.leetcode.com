package BinarySearch;

public class BinarySearchOrderUnknown {

    public static int BinarySearch(int[] nums, int ele)
    {
        int low = 0;
        int high = nums.length - 1;
        if(nums[0] > nums[1])
        {
            while(low <= high)
            {
                int mid = low + (high - low)/2;   // Integer overloading problem
                if(nums[mid] == ele)
                {
                    return mid;
                }else if(nums[mid] < ele)
                {
                    low = mid + 1;
                }else {
                    high = mid - 1;
                }
            }

        }else {

            while(low <= high)
            {
                int mid = low + (high - low)/2;
                if(nums[mid] == ele)
                {
                    return mid;
                }else if(nums[mid] < ele)
                {
                    low = mid + 1;
                }else {
                    high = mid -1;

                }
            }
        }

        return -1;

    }
    public static  void main(String args[])
    {
        int[] arr = new int[] {-3,0,3,4,5,67};
        int ele = 2;
        System.out.println(BinarySearch(arr, 4));

    }

}
