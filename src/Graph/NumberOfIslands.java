package Graph;

public class NumberOfIslands {

    public static void DFS(int[][] mat, int row, int col)
    {
        if(row < 0 || row > mat.length || col < 0 || col > mat[0].length || mat[row][col] == 0)
        {
            return;
        }
        mat[row][col] = 0;
        DFS(mat, row -1 , col);
        DFS(mat, row  + 1 , col);
        DFS(mat, row  , col - 1);
        DFS(mat, row  , col + 1);

    }
    public static int numberofIslands(int[][] mat)
    {
        int count = 0;

        for(int i = 0; i < mat.length; i++)
        {
            for(int j = 0; j < mat[0].length ; j++)
            {
                if(mat[i][j] == 1)
                {
                    ++count;
                    DFS(mat, i, j);
                }
            }
        }
        return count;
    }
    public static void main(String args[])
    {
        int[][] mat = new int[][]{
                {1,1,1,1,0},{1,1,0,1,0},{1,1,0,0,0},{0,0,0,0,0}
        };
        System.out.println(numberofIslands(mat));
    }
}
