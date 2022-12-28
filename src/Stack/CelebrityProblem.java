package Stack;

import java.util.Stack;

public class CelebrityProblem {
    static int MATRIX[][] = { { 0, 0, 1, 0 },
            { 0, 0, 1, 0 },
            { 0, 0, 0, 0 },
            { 0, 0, 1, 0 } };

    // Returns true if a knows
    // b, false otherwise
    static boolean knows(int a, int b)
    {
        boolean res = (MATRIX[a][b] == 1) ? true : false;
        return res;
    }
    //Stack Approach
    public static int findCelebrity(int n)
    {
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++)
        {
            st.push(i);
        }
        while(st.size() > 1)
        {
            int a = st.pop();
            int b = st.pop();
            if(knows(a,b))
            {
                st.push(b);
            }else {
                st.push(a);
            }
        }
        if(st.empty())
            return -1;
        int last = st.pop();
        for(int i = 0; i < n; i++)
        {
            if(i!=last && (knows(last,i) || !knows(i, last)))
            {
                return -1;
            }
        }
        return last;
    }
    //two pointer approach
    public static int findCelebrityUsingTwoPointers(int n, int[][] mat)
    {
        int left =0;
        int right = n -1 ;
        while(left < right)
        {
            if(mat[left][right] == 1) // right knows left
            {
                right--; // right is not the celebrity so take the other one
            }else {
                left++; // left is not the celebrity
            }
        }
        int candidate = left;
        for(int i = 0; i < n; i++)
        {
            if( i != candidate && (mat[candidate][i] == 1 || mat[i][candidate] == 0))
            {
                return -1;
            }
        }
        return candidate;
    }
    public static void main(String[] args)
    {
        int n = 4;
        //int result = findCelebrity(n);
        int result = findCelebrityUsingTwoPointers(n, MATRIX);
        if (result == -1) {
            System.out.println("No Celebrity");
        }
        else
            System.out.println("Celebrity ID " + result);
    }
}
