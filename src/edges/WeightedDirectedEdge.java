package edges;

public class WeightedDirectedEdge extends Edge implements Comparable<WeightedDirectedEdge> {	
	private double weight;
	
	public  WeightedDirectedEdge(int head, int tail, double weight) {
		super(head, tail);
		this.weight = weight;
	}
	
	public double weight() {
		return weight;
	}	
	
	@Override
	public String toString() {
		return String.format("%d->%d : %f", this.head(), this.tail(), weight);
	}

	@Override
	public int compareTo(WeightedDirectedEdge e) {
		if(this.weight < e.weight) return -1;
		if(this.weight > e.weight) return 1;
		else return 0;
	}
}
