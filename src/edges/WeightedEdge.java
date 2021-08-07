package edges;

public final class WeightedEdge extends Edge implements Comparable<WeightedEdge> {	
	private double weight;
	
	public WeightedEdge(int head, int tail, double weight) {
		super(head, tail);
		this.weight = weight;
	}
	
	public double weight() {
		return weight;
	}

	public Iterable<WeightedEdge> adj(int v) {
		return this.adj(v);
	}
	
	@Override
	public int compareTo(WeightedEdge e) {
		if(this.weight < e.weight) return -1;
		if(this.weight > e.weight) return 1;
		else return 0;
	}
	
	@Override
	public String toString() {
		return String.format("%d-%d : %f", this.head(), this.tail(), weight);
	}
}
