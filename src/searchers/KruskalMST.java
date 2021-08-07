package searchers;

import containers.MinPQ;
import containers.Queue;
import edges.Edge;
import graphs.WeightedGraph;

public class KruskalMST {

	private Queue<Edge> mst;
	
	public KruskalMST(WeightedGraph graph) {
		mst = new Queue<>();
		MinPQ<Edge> pq = new MinPQ<>();
		UF uf = new UF(graph.vertices());
		
		for(int i = 0; i < graph.vertices(); i++) {
			for(Edge e : graph.adj(i)) {
				pq.insert(e);
			}		
		}
		
		while(!pq.isEmpty() && mst.size() < (graph.vertices() - 1)) {
			Edge e = pq.delMin();
			int head = e.head();
			int tail = e.tail();
			
			if(uf.find(head) != uf.find(tail)) {
				uf.union(head, tail);
				mst.enqueue(e);
			}
		}
	}
	
	public Iterable<Edge> edges() {
		return mst;
	}	
}
