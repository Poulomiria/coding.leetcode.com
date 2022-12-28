package Stack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/*
Peek = returns the top element from stack without removing it.
Pop = returns the top element after removing from stack
Push = insert the element in top position in stack
Java Pair or tuple can be used but need to import external package -- check on this
 */
public class StockSpanProblem {

    public static List<Integer> nextgreaterelements(int[] nums)
    {
        Stack<List<Integer>> s = new Stack();
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++)
        {
            int ele = nums[i];
            if(s.isEmpty())
            {
                result.add(-1);
            }
            else if(s.size() > 0 && ele < s.peek().get(0))
            {
                result.add(s.peek().get(1));
            }
            else if(s.size() > 0 && ele >= s.peek().get(0))
            {
                while(!s.isEmpty() && s.peek().get(0) <= ele)
                {
                    s.pop();
                }
                if(s.empty())
                {
                    result.add(-1);
                }else{
                    result.add(s.peek().get(1));
                }

            }
            List<Integer> temp = new ArrayList<>();
            temp.add(ele);
            temp.add(i);
            s.push(temp);
        }
        return  result;
    }
    public static void main(String args[])
    {
        int[] arr = new int[] {100,80,60, 70,60,75,85};
        List<Integer> output =  nextgreaterelements(arr);
        Iterator itr = output.listIterator();
        while(itr.hasNext())
        {
            System.out.println(itr.next() + "\t");
        }

    }
}
