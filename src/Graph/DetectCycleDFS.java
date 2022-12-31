package Graph;

import java.util.Iterator;

/*
detect a cycle in an undirected graph
Time : O (V+E) Space O(v)
We can use DFS using recursion where we will traverse all the nodes when current node = parent then cycle will be detected
 */
public class DetectCycleDFS {

    private static  int v = 9;

    private static boolean IsCycleUtils(Graph g, int s, int parent, boolean[] visited)
    {
        visited[s] = true;
        int temp;
        Iterator<Integer> itr = g.adj[v].listIterator();
        while(itr.hasNext())
        {
            temp = itr.next();
            if(!visited[v])
            {
                if (IsCycleUtils(g, temp, s , visited))
                    return true;

            }else if(temp != parent)
                return false;
        }
       return  false;
    }
    boolean isCycle(Graph g)
    {
        boolean[] visited = new boolean[v];
        for(int i = 0; i < v; i++)
        {
            visited[i] = false;
        }

        // Call the recursive helper
        // function to detect cycle in
        // different DFS trees
        for (int u = 0; u < v; u++) {

            // Don't recur for u if already visited
            if (!visited[u])
                if (IsCycleUtils(g, u,-1, visited))
                    return true;
        }
      return false;
    }

}
