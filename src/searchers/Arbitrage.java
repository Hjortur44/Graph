package searchers;

import edges.WeightedDirectedEdge;
import graphs.WeightedDigraph;

public class Arbitrage {

	public Arbitrage(String[] keys, double[][] values) {
		WeightedDigraph graph = new WeightedDigraph(keys.length);
		
		for(int i = 0; i < keys.length; i++) {
			for(int j = 0; j < keys.length; j++) {
				double rate = 1.0;
				if(j != i) rate = Math.random();
				if(rate < 0.3) rate += 1.0;
				WeightedDirectedEdge e = new WeightedDirectedEdge(i, j, -Math.log(rate));
				graph.addEdge(e);
			}
		}
		
		for(int i = 0; i < keys.length; i++) {
			BellmanFordSP spt = new BellmanFordSP(graph, i);
			if(spt.hasNegativeCycle()) {
				double stake = 1000.0;
				
				for(WeightedDirectedEdge edge : spt.negativeCycle()) {
					System.out.printf("%10.5f -> ", stake);				
					stake *= Math.exp(-edge.weight());
					System.out.printf("%10.5f", stake);
					System.out.println();
				}
				
				System.out.println();
			}
		}
	}
}
