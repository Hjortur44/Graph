package searchers;

import edges.WeightedDirectedEdge;
import graphs.WeightedDigraph;

public class DijkstraAllPairsSP {
	private DijkstraSP[] all;
	
	public DijkstraAllPairsSP(WeightedDigraph graph) {
		all = new DijkstraSP[graph.vertices()];
		
		for(int i = 0; i < graph.vertices(); i++) {
			all[i] = new DijkstraSP(graph, i);
		}
	}
	
	public double dist(int s, int t) {
		return all[s].distTo(t);
	}
	
	public Iterable<WeightedDirectedEdge> path(int s, int t){
		return all[s].pathTo(t);
	}
	
	public DijkstraSP path(int s) {
		return all[s];
	}
}
