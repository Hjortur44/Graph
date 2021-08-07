import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import containers.Bag;
import graphs.*;
import edges.*;
import searchers.*;
import sorters.*;

public class Driver {

	public static void main(String[] args) {
    Graph g = Graph(100); // creating the graph
    DFS(g, 0);            // searching for the shortest path.
	}

	// Creates an undirected graph.
  // @param size: the size of the graph.
  // @return undirected graph.
	private static Graph graph(int size) {
		Graph graph = new Graph(size);
		Map<Integer, Set<Integer>> map = new HashMap<>();

		for(int i = 0; i < size; i++) {
			Set<Integer> set = new HashSet<>();
			int w = (int)(Math.random() * size);

			for(int j = 0; j < w; j++) {
				int vert = (int)(Math.random() * size);
				set.add(vert);
			}

			map.put(i, set);
		}

		map.forEach((k, set) ->{
			set.forEach((v) ->{
				graph.addEdge(new Edge(k, v));
			});
		});

		return graph;
	}

	// Creates a weighted directed graph.
  // @param size: the size of the graph.
  // @return weighted digraph (weighted directed graph).
	private static WeightedDigraph WeightedDigraph(int size) {
		Graph graph = new WeightedDigraph(size);

		// Filling the graph with random edges and weights.
		for(int i = 0; i < size; i++) {
			int amount = (int)(Math.random() * size);

			for(int j = 0; j < amount; j++) {
				double w = Math.random();
				if(w < 0.2) w *= (-1.0);

				int o = (int)(Math.random() * size);
				Edge ew = new WeightedDirectedEdge(i, o, w);
				graph.addEdge(ew);
			}
		}

		// Making sure that all vertices are connected
		// and all the edges have a weigth.
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				Edge ew = new WeightedDirectedEdge(i, j, 0.5);
				graph.addEdge(ew);
			}
		}

		return (WeightedDigraph)graph;
	}

 	// Creates a weighted undirected graph.
  // @param size: the size of the graph.
  // @return weighted undirected graph.
	private static WeightedGraph WeightedGraph(int size) {
		WeightedGraph graph = new WeightedGraph(size);

		// Filling the graph with random edges and weights.
		for(int i = 0; i < size; i++) {
			int amount = (int)(Math.random() * size);

			for(int j = 0; j < amount; j++) {
				double w = Math.random();
				int o = (int)(Math.random() * size);
				Edge ew = new WeightedEdge(i, o, w);
				graph.addEdge(ew);
			}
		}

		// Making sure that all vertices are connected
		// and all the edges have a weigth.
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				Edge ew = new WeightedEdge(i, j, 0.5);
				graph.addEdge(ew);
			}
		}

		return graph;
	}

  // @param graph: undirected graph.
	private static void TransitiveClosure(Graph graph) {
		TransitiveClosure trans = new TransitiveClosure(graph);
		for(int i = 0; i < graph.vertices(); i++) {
			for(int j = 0; j < graph.vertices(); j++) {
			  String str = i + " -> " + j + ": " + trans.reachable(i, j);
				System.out.println(str);
			}
		}
	}

  // @param graph: directed graph.
	private static void Topological(Graph graph) {
		Topological topo = new Topological(graph);

		// If null, then the graph is not a DAG.
		if(topo.order() != null) {
			for(int v : topo.order()) System.out.println(v);
		}
	}

  // @param graph: undirected graph.
	private static void DFO(Graph graph) {
		DFO dfo = new DFO(graph);
		Iterable<Integer> it = dfo.preOrder();

		it.forEach((v) -> {
			System.out.println(v);
		});
	}

  // @param graph: directed graph.
	private static void DirectedCycle(Graph graph) {
		DirectedCycle cycle = new DirectedCycle(graph);
		Iterable<Integer> it = cycle.cycle();

		it.forEach((v) -> {
			System.out.println(v);
		});
	}

  // @param graph: directed graph.
	private static void DirectedDFS(Graph graph) {
		Bag<Integer> sources = new Bag<>();
		int count = (int)(Math.random() * graph.vertices());

		for(int i = 0; i < count; i++) {
			sources.add((int)(Math.random() * graph.vertices()));
		}

		DirectedDFS reachable = new DirectedDFS(graph, sources);

		for(int i = 0; i < graph.vertices(); i++) {
			if(reachable.marked(i)) System.out.print(i + " ");
		}

		System.out.println();
	}

  // @param graph: (un)directed graph.
	private static void Cycle(Graph graph) {
		Cycle cycle = new Cycle(graph);
		System.out.println(cycle.hasCycle());
	}

  // @param graph: (un)directed graph.
	private static void CC(Graph graph) {
		CC cc = new CC(graph);

		for(int i = 0; i < graph.vertices(); i++) {
			for(int j = 0; j < graph.vertices(); j++) {
			  String str = i + " -> " + j + ": " + cc.connected(i, j);
				System.out.println(str);
			}
		}
	}

  // Depth-first search.
  // @param graph: (un)directed graph.
  // @param source: the starting vertex.
	private static void DFS(Graph graph, int source) {
		DFS dfs = new DFS(graph, source);

		for(int i = 0; i < graph.vertices(); i++) {
			System.out.println(dfs.hasPathTo(i));
		}
	}

  // Breadth-first search.
  // @param graph: (un)directed graph.
  // @param source: the starting vertex.
	private static void BFS(Graph graph, int source) {
		BFS bfs = new BFS(graph, source);

		for(int i = 0; i < graph.vertices(); i++) {
			System.out.println(bfs.hasPathTo(i));
		}
	}
}
