package searchers;

import containers.IndexMinPQ;
import containers.Stack;
import edges.DirectedEdge;
import edges.Edge;
import edges.WeightedDirectedEdge;
import edges.WeightedEdge;
import graphs.WeightedDigraph;

public class DijkstraSP {

	private WeightedDirectedEdge[] edgeTo;
	private double[] distTo;
	private IndexMinPQ<Double> pq;
	
	public DijkstraSP(WeightedDigraph graph, int source) {
		edgeTo = new WeightedDirectedEdge[graph.vertices()];
		distTo = new double[graph.vertices()];
		pq = new IndexMinPQ<>(graph.vertices());
		pq.insert(source, 0.0);
		
		for(int i = 0; i < graph.vertices(); i++) {
			distTo[i] = Double.POSITIVE_INFINITY;
		}
		
		distTo[source] = 0.0;
		
		while(!pq.isEmpty()) relax(graph, pq.delMin());	
	}
	
	public double distTo(int vertex) {
		return distTo[vertex];
	}
	
	public boolean hasPathTo(int vertex) {
		return distTo[vertex] < Double.POSITIVE_INFINITY;
	}
	
	public Iterable<WeightedDirectedEdge> pathTo(int vertex) {
		if(!hasPathTo(vertex)) return null;
	
		Stack<WeightedDirectedEdge> path = new Stack<>();
		for(WeightedDirectedEdge e = edgeTo[vertex]; e != null; e = edgeTo[e.head()]) {
			path.push(e);
		}

		return path;
	}
	
	private void relax(WeightedDigraph graph, int head) {
		for(Edge e : graph.adj(head)) {
			WeightedDirectedEdge we = (WeightedDirectedEdge) e;
			int tail = e.tail();
			
			if(distTo[tail] > (distTo[head] + we.weight())) {
				distTo[tail] = distTo[head] + we.weight();
				edgeTo[tail] = we;
				
				if(pq.contains(tail)) pq.changeKey(tail, distTo[tail]);
				else pq.insert(tail, distTo[tail]);
			}
		}
	}
}
