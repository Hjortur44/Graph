package searchers;

import graphs.Graph;

public class TransitiveClosure {

	private DirectedDFS[] all;
	
	public TransitiveClosure(Graph graph){
		all = new DirectedDFS[graph.vertices()];		
		for(int i = 0; i < graph.vertices(); i++) all[i] = new DirectedDFS(graph, i);	
	}
	
	public boolean reachable(int v, int w) {
		return all[v].marked(w);
	}
}
