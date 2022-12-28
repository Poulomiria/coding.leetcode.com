package Stack;

        import java.util.ArrayList;
        import java.util.Iterator;
        import java.util.List;
        import java.util.Stack;
/*
Peek = returns the top element from stack without removing it.
Pop = returns the top element after removing from stack
Push = insert the element in top position in stack
 */
public class NextSmallerElementToRight {

    public static List<Integer> nextsmallerelements(int[] nums)
    {
        Stack<Integer> s = new Stack();
        List<Integer> result = new ArrayList<>();
        for(int i = nums.length - 1; i>= 0; i--)
        {
            int ele = nums[i];
            if(s.isEmpty())
            {
                result.add(-1);
            }
            else if(s.size() > 0 && ele > s.peek())
            {
                result.add(s.peek());
            }
            else if(s.size() > 0 && ele <= s.peek())
            {
                while(!s.isEmpty() && s.peek() >= ele)
                {
                    s.pop();
                }
                if(s.empty())
                {
                    result.add(-1);
                }else{
                    result.add(s.peek());
                }

            }
            s.push(ele);
        }
        return  result;
    }
    public static void main(String args[])
    {
        int[] arr = new int[] {1,3,2,4,5};
        List<Integer> output =  nextsmallerelements(arr);
        Iterator itr = output.listIterator();
        while(itr.hasNext())
        {
            System.out.println(itr.next() + "\t");
        }

    }
}
