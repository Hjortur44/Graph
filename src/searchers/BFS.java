package searchers;

import containers.*;
import edges.Edge;
import graphs.Graph;

//Breadth-first search class.
public class BFS {
	
	private boolean[] marked;
	private int[] edgeTo;
	private int source;
	
	public BFS(Graph graph, final int source) {
		marked = new boolean[graph.vertices()];
		edgeTo = new int[graph.vertices()];
		this.source = source;
		//bfs(graph, source);
	}
	
	public boolean hasPathTo(int w) {
		return marked[w];
	}
/*
	public Iterable<Edge> pathTo(int v){
		if(!hasPathTo(v)) return null;		
		Stack<Edge> path = new Stack<>();
		
		for(int x = v; x != source; x = edgeTo[x]) path.push(x);		
		path.push(source);
		
		return path;		
	}

	private void bfs(Graph g, int v) {
		Queue<Integer> queue = new Queue<>();
		marked[v] = true;
		
		do {			
			for(int w : g.adj(v)) {
				if(!marked[w]) {
					edgeTo[w] = v;
					marked[w] = true;					
					queue.enqueue(w);
				}
			}
			
			v = queue.dequeue();
		} while(!queue.isEmpty());	
	}	
	*/
}
