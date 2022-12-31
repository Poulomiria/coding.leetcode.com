package Graph;

import java.util.Iterator;
/*
Approach:

Time (V+E), Space O(E)
 */

public class DFS {

    private static  int v = 9;
    public static void DFS(Graph g, int s)
    {
        //mark all the vertices as false
        boolean[] visited = new boolean[v];
        DFSUtil(g, s, visited);
    }
    //Recursive traversal
    //Auxiliary space is required 
    // one vertex will take one adjacent vertex will take and go to next once its reach to end then will take the another vertex
    //Using stack also it can be achieved
    public static void DFSUtil(Graph g, int s, boolean visited[])
    {
        visited[s] = true;
        System.out.println(s);
        Iterator<Integer> itr = g.adj[s].listIterator();
        if(itr.hasNext())
        {
            int temp = itr.next();
            if(!visited[temp])
            {
                DFSUtil(g,temp,visited);
            }
        }
    }
    public static void main(String args[])
    {
        v = 10;
        Graph g = new Graph(v);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 6);
        g.addEdge(7, 8);
        g.addEdge(6, 9);
        System.out.println(
                "Following is Breadth First Traversal "
                        + "(starting from vertex 2)");

        DFS(g, 2);

    }

}
