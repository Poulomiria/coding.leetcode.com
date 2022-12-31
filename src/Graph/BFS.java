package Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
/*
Approach:
We can take a queue put the elements until its list is not finished
Time (V+E), Space O(E)

 */

public class BFS {

    private static int v = 10;
    public static void BFS(int s, Graph g)
    {
        boolean visited[] = new boolean[v];
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.add(s);
        while(!q.isEmpty())
        {
            int ele = q.poll();
            System.out.println("elements" + ele);
            Iterator<Integer> itr = g.adj[ele].listIterator();
            while(itr.hasNext())
            {
                int temp = itr.next();
                if(!visited[temp])
                {
                    visited[temp] = true;
                    q.add(temp);
                }

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

        BFS(2, g);

    }
}
