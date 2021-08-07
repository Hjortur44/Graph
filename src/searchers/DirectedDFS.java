package searchers;

import edges.Edge;
import graphs.Graph;

public class DirectedDFS {

	private boolean[] marked;
	
	public DirectedDFS(Graph graph, int source) {
		marked = new boolean[graph.vertices()];
		ddfs(graph, source);
	}
	
	public DirectedDFS(Graph graph, Iterable<Integer> sources) {
		marked = new boolean[graph.vertices()];
		
		for(int s : sources) {
			if(!marked[s]) ddfs(graph, s);
		}
	}
	
	public boolean marked(int vertix) {
		return marked[vertix];
	}
	
	private void ddfs(Graph graph, int vertix) {
		marked[vertix] = true;
		
		for(Edge w : graph.adj(vertix)) {
			if(!marked[w.tail()]) ddfs(graph, w.tail());
		}
	}
}
