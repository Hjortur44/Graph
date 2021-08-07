package searchers;

import containers.IndexMinPQ;
import edges.Edge;
import edges.WeightedEdge;
import graphs.WeightedGraph;

public class PrimMST {

	private Edge[] edgeTo;
	private double [] distTo;
	private boolean[] marked;
	private IndexMinPQ<Double> pq;
	
	public PrimMST(WeightedGraph graph) {
		edgeTo = new Edge[graph.vertices()];
		distTo = new double[graph.vertices()];
		marked = new boolean[graph.vertices()];
		pq = new IndexMinPQ<>(graph.vertices());
	
		for(int i = 1; i < graph.vertices(); i++) {
			distTo[i] = Double.POSITIVE_INFINITY;
		}
		
		pq.insert(0, 0.0);
		while(!pq.isEmpty()) {
			visit(graph, pq.delMin());
		}
	}
	
	public double weight() {
		double weight = 0.0;

		for(double dist : distTo) {
			weight += dist;
		}
		
		return weight;
	}
	
	public Edge[] edges() {
		return edgeTo;
	}
	
	private void visit(WeightedGraph graph, int vertex) {
		marked[vertex] = true;
		
		for(Edge e : graph.adj(vertex)) {
			WeightedEdge we = (WeightedEdge)e;
			int w = e.tail();

			if(!marked[w] && we.weight() < distTo[w]) {
				edgeTo[w] = e;
				distTo[w] = we.weight();
				
				if(pq.contains(w)) pq.changeKey(w, distTo[w]);
				else pq.insert(w, distTo[w]);
			}
		}	
	}
}
