package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {

    public static int numberofenclaves(int[][] mat)
    {
        Queue<Pair> q = new LinkedList<Pair>();
        int row = mat.length;
        int col = mat[0].length;
        int[][] visited = new int[row][col];
        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < col; j++)
            {
                if(i == 0 || j==0 || i == row - 1|| j == col - 1)
                {
                    if(mat[row][col] == 1)
                    {
                        visited[row][col] = 1;
                        q.add(new Pair(i, j));
                    }
                }
            }
        }
        int[] delrow = { -1, 0, -1, 0};
        int[] delcol = {0, -1, 0 , -1};
        while(!q.isEmpty())
        {
            int rowele =q.peek().first;
            int colele = q.peek().second;
            q.remove();
            for(int i = 0; i < 4; i++)
            {
                int nrow = rowele + delrow[i];
                int ncol = colele + delcol[i];
                if(nrow > 0 && nrow < row && ncol >=0 && ncol < col && visited[nrow][ncol] == 0 && mat[nrow][ncol] == 1){
                q.add(new Pair(nrow, ncol));
                visited[nrow][ncol] = 1;

        }
    }
        }int count = 0;
        for(int i =0; i < row; i++)
        {
        for(int j = 0 ; j < col; j++)
        {
        if(mat[row][col] == 1 && visited[row][col] == 0) count++;
        }
        }
        return count;
}
}


 class Pair{
int first;
int second;
Pair(int first, int second)
{
this.first = first;
this.second = second;
}
}
