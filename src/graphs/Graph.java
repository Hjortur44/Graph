package graphs;

import containers.Bag;
import edges.DirectedEdge;
import edges.Edge;

// A class which creates an undiricted graph.
public class Graph {

	protected Bag<Edge>[] adj;
	private int edges, vertices;

	public Graph(int vertices) {
		this.adj = new Bag[vertices];
		this.vertices = vertices;
		this.edges = 0;

		for(int i = 0; i < vertices; i++) adj[i] = new Bag<>();
	}

	public int edges() {
		return edges;
	}
	
	public int vertices() {
		return vertices;
	}	
	
	public int degree(int v) {
		return adj[v].size();
	}
	
	public int[] maxDegree() {		
		int vert = 0;
		int max = 0;
		
		for(int i = 0; i < vertices; i++) {
			int d = adj[i].size();
			
			if(d > max) {
				max = d;
				vert = i;
			}
		}
		
		int[] res = {vert, max};

		return res;
	}	
	
	public Iterable<Edge> adj(int v) {
		return adj[v];
	}

	public void addEdge(Edge edge) {
		if(!correctEdge(edge)) {
			throw new IllegalArgumentException();
		}else if(!this.exists(edge)) {
			this.adj[edge.head()].add(edge);
		}
	}
	
	protected boolean correctEdge(Edge edge) {
		return edge.getClass() == Edge.class;
	}

	private boolean exists(Edge edge) {
		for(Edge e : adj[edge.head()]) {	
			if(e.tail() == edge.tail()) return true;
		}
		
		return false;	
	}
}
