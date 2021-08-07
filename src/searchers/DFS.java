package searchers;

import containers.Stack;
import graphs.Graph;

// Depth-first search class.
public class DFS {

	private boolean[] marked;
	private int[] edgeTo;
	private int count, source;
	
	public DFS(Graph g, final int source) {
		marked = new boolean[g.vertices()];
		edgeTo = new int[g.vertices()];
		this.source = source;
		//dfs(g, source);
	}
	
	public boolean hasPathTo(int w) {
		return marked[w];
	}
	
	public int count() {
		return count;
	}
	
	public Iterable<Integer> pathTo(int v){
		if(!hasPathTo(v)) return null;		
		Stack<Integer> path = new Stack<>();
		
		for(int x = v; x != source; x = edgeTo[x]) path.push(x);		
		path.push(source);
		
		return path;		
	}
/*
	private void dfs(Graph g, final int v) {
		marked[v] = true;
		count++;
		
		for(int w : g.adj(v)) {
			if(!marked[w]) {
				edgeTo[w] = v;
				dfs(g, w);
			}
		}
	}	*/
}
