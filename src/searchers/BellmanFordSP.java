package searchers;

import containers.Queue;
import edges.Edge;
import edges.WeightedDirectedEdge;
import graphs.WeightedDigraph;

public class BellmanFordSP {
	private WeightedDirectedEdge[] edgeTo;
	private Queue<Integer> queue;
	private Iterable<WeightedDirectedEdge> cycle;
	
	private double[] distTo;
	private boolean[] onQueue;
	private int cost;
	
	public BellmanFordSP(WeightedDigraph graph, int source) {
		edgeTo = new WeightedDirectedEdge[graph.vertices()];
		distTo = new double[graph.vertices()];		
		onQueue = new boolean[graph.vertices()];
		queue = new Queue<>();
		queue.enqueue(source);
		onQueue[source] = true;
		cost = 0;
		
		for(int i = 0; i < graph.vertices(); i++) {
			distTo[i] = Double.POSITIVE_INFINITY;
		}
		
		distTo[source] = 0.0;
		
		while(!queue.isEmpty() && !hasNegativeCycle()) {
			int v = queue.dequeue();
			onQueue[v] = false;
			relax(graph, v);
		}		
	}
	
	public boolean hasNegativeCycle() {
		return cycle != null;
	}
	
	public Iterable<WeightedDirectedEdge> negativeCycle(){
		return cycle;
	}
	
	private void findNegativeCycle() {
		int length = edgeTo.length;
		WeightedDigraph spt = new WeightedDigraph(length);
		
		for(int i = 0; i < length; i++) {
			if(edgeTo[i] != null) {
				// TODO: Filter out repeated cycles.
				spt.addEdge(edgeTo[i]);
			}
		}
		
		EdgeWeightedDirectedCycle cf = new EdgeWeightedDirectedCycle(spt);
		cycle = cf.cycle();
	}
		
	private void relax(WeightedDigraph graph, int head) {
		for(Edge e : graph.adj(head)) {
			WeightedDirectedEdge we = (WeightedDirectedEdge) e;
			
			if(distTo[we.tail()] > (distTo[head] + we.weight())) {
				distTo[we.tail()] = distTo[head] + we.weight();
				edgeTo[we.tail()] = we;
				
				if(!onQueue[we.tail()]) {
					queue.enqueue(we.tail());
					onQueue[we.tail()] = true;
				}
			}
			
			if(cost++ % graph.vertices() == 0) findNegativeCycle();
		}
	}
}
