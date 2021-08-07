package graphs;

import edges.DirectedEdge;
import edges.Edge;

public class Digraph extends Graph {

	public Digraph(int vertices) {
		super(vertices);
	}

	@Override
	protected boolean correctEdge(Edge edge) {
		return edge.getClass() == DirectedEdge.class;
	}
}
