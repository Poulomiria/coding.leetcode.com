package Graph;

/*
if a Matrix is given we can loop through and get the connected components
or else we can store the elements in adajancency list and get the components Time (V+E), Space O(E)
 */
public class NumberOfProvinces {


    public static int numberofprovinces(int[][] mat)
    {
        boolean[] visited = new boolean[mat.length];
        int count = 0;
        for(int i = 0; i < mat.length ; i++)
        {
            if(!visited[i])
            {
                DFSUtil(mat, visited, i);
                count++;
            }
        }
        return count;
    }

    public static void DFSUtil(int[][] mat, boolean[] visited, int i)
    {

        for(int j = 0 ; j < mat.length ; j++)
        {
            if(mat[i][j] == 1 && !visited[j])
            {
                visited[j] = true;
                DFSUtil(mat, visited, i);
            }
        }

    }
    public static void main(String args[])
    {
        int[][] mat = new int[][]{
                {1,1,0},{1,1,0},{0,0,1}
        };

        System.out.println(numberofprovinces(mat));
    }
}
