package swapk.sorting;

import java.util.Iterator;
import java.util.LinkedList;

public class GraphBFSAndDFS {

	private int V;
    private LinkedList<Integer> adj[];
 
    // Constructor
    GraphBFSAndDFS(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

	public void addEdge(int s, int d) {
		adj[s].add(d);
	}
	
	// prints BFS traversal from a given source s
	void BFS(int s) {
		
		boolean visited[] = new boolean[V];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		visited[s]=true;
		queue.add(s);
		
		while( queue.size() != 0 ) {
			
			s = queue.poll();
            System.out.print(s+" ");
            
            Iterator<Integer> i = adj[s].listIterator();
            
            while( i.hasNext() ) {
            	int n = i.next();
            	if( !visited[n] ) {
            		visited[n] = true;
                    queue.add(n);
            	}
            	
            }
            
		}
		
	}
	
	//prints DFS traversal from a given source s
	public void DFS( int s ) {
		boolean visited[] = new boolean[V];
		DFSUtil(s, visited);
	}

	private void DFSUtil(int s, boolean[] visited) {
		
		visited[s] = true;
		System.out.println(s+" ");
		
		Iterator<Integer> i = adj[s].listIterator();
		while( i.hasNext() ) {
			int n = i.next();
			if( !visited[n] ) {
				DFSUtil(n, visited);
			}
		}
		
	}

	public static void main(String[] args) {
		
		GraphBFSAndDFS g = new GraphBFSAndDFS(4);
		 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println("Following is Breadth First Traversal "+
                           "(starting from vertex 2)");
 
        g.BFS(2);
        System.out.println();
        g.DFS(2);
	}

}
