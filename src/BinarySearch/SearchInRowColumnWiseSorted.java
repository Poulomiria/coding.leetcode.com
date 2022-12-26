package BinarySearch;

public class SearchInRowColumnWiseSorted {

    public static int[] BinarySearch(int[][] nums, int key)
    {
        int left = 0;
        int right = nums[0].length -1;
        while(left >= 0 && left < nums.length && right >=0 && right < nums[0].length)
        {
            if(nums[left][right] == key)
            {
                return new int[]{left, right};
            }else if(key < nums[left][right])
            {
                right--;
            }else {
                left++;
            }
        }
        return new int[]{-1, -1};
    }
    public static  void main(String args[])
    {
        int[][] matrix = new int[][]{
                1,3,4,5
                6,5,8,0
        };

    }
}
