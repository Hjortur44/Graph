package edges;

public class DirectedEdge extends Edge{	

	public DirectedEdge(int head, int tail) {
		super(head, tail);
	}

	@Override
	public String toString() {
		return String.format("%d->%d", this.head(), this.tail());
	}

}
