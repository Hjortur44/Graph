package edges;

public class Edge {

	private int head, tail;

	public Edge(int head, int tail) {
		this.head = head;
		this.tail = tail;
	}

	public int head() {
		return head;
	}	
	
	public int tail() {
		return tail;
	}	
	
	@Override
	public String toString() {
		return String.format("%d-%d", head, tail);
	}
}
