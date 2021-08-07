package searchers;

import graphs.Graph;

// Cycle searching class.
public class Cycle {

	private boolean[] marked;
	private boolean hasCycle;
	
	public Cycle(Graph graph) {
		marked = new boolean[graph.vertices()];
		
		for(int i = 0; i < graph.vertices(); i++) {
			//if(!marked[i]) dfs(graph, -1, i);
		}
	}
	
	public boolean hasCycle() {
		return hasCycle;
	}
	/*
	private void dfs(Graph graph, int u, int v) {
		marked[v] = true;
		
		for(int w : graph.adj(v)) {
			if(!marked[w]) dfs(graph, v, w);
			else if(w != u) hasCycle = true;
		}
	}*/
}
