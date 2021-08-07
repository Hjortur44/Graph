package searchers;

import containers.Stack;
import edges.Edge;
import graphs.Graph;

public class DirectedCycle {

	private Stack<Integer> cycle;
	private boolean[] marked, onStack;
	private int[] edgeTo;


	public DirectedCycle(Graph graph) {
		onStack = new boolean[graph.vertices()];
		marked = new boolean[graph.vertices()];
		edgeTo = new int[graph.vertices()];
		
		for(int i = 0; i < graph.vertices(); i++) {
			if(!marked[i]) dfs(graph, i);
		}
	}

	public boolean hasCycle() {
		return cycle != null;
	}
	
	public Iterable<Integer> cycle(){
		return cycle;
	}	
	
	private void dfs(Graph graph, final int v) {
		marked[v] = true;
		onStack[v] = true;

		for(Edge w : graph.adj(v)) {
			if(this.hasCycle()) return;
			else if(!marked[w.tail()]) {
				edgeTo[w.tail()] = v;
				dfs(graph, w.tail());
			}
			else if(onStack[w.tail()]) {
				cycle = new Stack<>();
				
				for(int x = v; x != w.tail(); x = edgeTo[x]) cycle.push(x);
				
				cycle.push(w.tail());
				cycle.push(v);				
			}
		}
		
		onStack[v] = false;
	}
}
