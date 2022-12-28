package Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
/*
https://leetcode.com/problems/largest-rectangle-in-histogram/ */
public class MaxAreaHistogram {

    public static int maxarea(int[] nums)
    {
        List<Integer> left = nextsmallerelementsleft(nums);
        List<Integer> right = nextsmallerelementsright(nums);
        int[] width = new int[nums.length];
        int[] area = new int[nums.length];

        for(int i = 0 ;i < nums.length; i++)
        {
            width[i] = right.get(i) - left.get(i) - 1;
            area[i] = width[i] * nums[i];
        }
        Arrays.sort(area);

        return area[nums.length - 1];
    }
    public static List<Integer> nextsmallerelementsright(int[] nums)
    {
        Stack<int[]> s = new Stack();
        List<Integer> result = new ArrayList<>();
        for(int i = nums.length - 1; i>= 0; i--)
        {
            int ele = nums[i];
            if(s.isEmpty())
            {
                result.add(-1);
            }
            else if(s.size() > 0 && ele > s.peek()[0])
            {
                result.add(s.peek()[1]);
            }
            else if(s.size() > 0 && ele <= s.peek()[0])
            {
                while(!s.isEmpty() && s.peek()[0] >= ele)
                {
                    s.pop();
                }
                if(s.empty())
                {
                    result.add(-1);
                }else{
                    result.add(s.peek()[1]);
                }

            }
            s.push(new int[] {ele, i});
        }
        return  result;
    }
    public static List<Integer> nextsmallerelementsleft(int[] nums)
    {
        Stack<int[]> s = new Stack();
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++)
        {
            int ele = nums[i];
            if(s.isEmpty())
            {
                result.add(-1);
            }
            else if(s.size() > 0 && ele > s.peek()[0])
            {
                result.add(s.peek()[1]);
            }
            else if(s.size() > 0 && ele <= s.peek()[0])
            {
                while(!s.isEmpty() && s.peek()[0] >= ele)
                {
                    s.pop();
                }
                if(s.empty())
                {
                    result.add(-1);
                }else{
                    result.add(s.peek()[1]);
                }

            }
            s.push(new int[] { ele, i});
        }
        return  result;
    }

    public static void main(String args[])
    {
        int[] arr = new int[]{2,1,5,6,2,3};
        System.out.println(maxarea(arr));
    }
}
