package graphs;

import edges.Edge;
import edges.WeightedDirectedEdge;
import edges.WeightedEdge;

public final class WeightedGraph extends Graph {

	public WeightedGraph(int vertices) {
		super(vertices);
	}
	
	@Override
	protected boolean correctEdge(Edge edge) {
		return edge.getClass() == WeightedEdge.class;
	}
}
