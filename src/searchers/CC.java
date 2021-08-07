package searchers;

import graphs.Graph;

//Connected components search class.
public class CC {

	private boolean[] marked;
	private int[] id;
	private int count;
	
	public CC(Graph graph) {
		marked = new boolean[graph.vertices()];
		id = new int[graph.vertices()];
		
		for(int i = 0; i < graph.vertices(); i++) {
			if(!marked[i]) {
				//dfs(graph, i);
				count++;
			}
		}
	}
	
	public boolean connected(int v, int w) {
		return id[v] == id[w];
	}
	
	public int id(int v) {
		return id[v];
	}
	
	public int count() {
		return count;
	}
	/*
	private void dfs(Graph graph, int v) {
		marked[v] = true;
		id[v] = count;
		
		for(int w : graph.adj(v)) {
			if(!marked[w]) dfs(graph, w);
		}
	}*/
}
