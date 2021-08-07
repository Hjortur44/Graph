package graphs;

import edges.Edge;
import edges.WeightedDirectedEdge;

public class WeightedDigraph extends Graph {

	public WeightedDigraph(int vertices) {
		super(vertices);
	}

	@Override
	protected boolean correctEdge(Edge edge) {
		return edge.getClass() == WeightedDirectedEdge.class;
	}
}
