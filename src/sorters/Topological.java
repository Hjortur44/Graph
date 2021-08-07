package sorters;

import graphs.Graph;
import searchers.DFO;
import searchers.DirectedCycle;

public class Topological {

	private Iterable<Integer> order;
	
	public Topological(Graph graph) {
		DirectedCycle cycleFinder = new DirectedCycle(graph);
		
		if(!cycleFinder.hasCycle()) {
			DFO dfo = new DFO(graph);
			order = dfo.reversedPostOrder();
		}
	}
	
	public boolean isDAG() {
		return order != null;
	}	
	
	public Iterable<Integer> order() {
		return order;
	}
}
