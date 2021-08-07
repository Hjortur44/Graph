package searchers;

import java.util.Iterator;

import containers.MinPQ;
import containers.Queue;
import edges.Edge;
import edges.WeightedEdge;
import graphs.WeightedGraph;

public class LazyPrimMST {

	private boolean[] marked;
	private Queue<WeightedEdge> mst;
	private MinPQ<WeightedEdge> pq;
	
	public LazyPrimMST(WeightedGraph graph) {
		pq = new MinPQ<>();
		marked = new boolean[graph.vertices()];
		mst = new Queue<>();
		
		visit(graph, 0);
		while(!pq.isEmpty()) {
			WeightedEdge edge = pq.delMin();
			int head = edge.head();
			int tail = edge.tail();
			boolean isHeadMarked = marked[head];
			boolean isTailMarked = marked[tail];
			
			if(!isHeadMarked) {
				mst.enqueue(edge);
				visit(graph, head);
			}else if(!isTailMarked) {
				mst.enqueue(edge);
				visit(graph, tail);
			}				
		}
	}
	
	public double weight() {
		double weight = 0.0;
		
		Iterator<WeightedEdge> it = mst.iterator();
		while(it.hasNext()) {
			weight += it.next().weight();
		}
		
		return weight;
	}
	
	public Iterable<WeightedEdge> edges(){
		return mst;
	}
	
	private void visit(WeightedGraph graph, int head) {
		marked[head] = true;
		
		for(Edge edge : graph.adj(head)) {
			if(!marked[edge.tail()]) pq.insert((WeightedEdge)edge);
		}
	}
}
