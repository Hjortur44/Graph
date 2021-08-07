package searchers;

import containers.*;
import edges.Edge;
import graphs.Graph;

// A depthFirstOrder class.
public class DFO {

	private boolean[] marked;
	private Queue<Integer> pre, post;
	private Stack<Integer> reversePost;
	
	public DFO(Graph graph) {
		pre = new Queue<Integer>();
		post = new Queue<Integer>();
		reversePost = new Stack<Integer>();
		marked = new boolean[graph.vertices()];
		
		for(int i = 0; i < graph.vertices(); i++) {
			if(!marked[i]) dfs(graph, i);
		}
	}
	
	public Iterable<Integer> preOrder() {		
		return pre;
	}
	
	public Iterable<Integer> postOrder() {		
		return post;
	}
	
	public Iterable<Integer> reversedPostOrder() {		
		return reversePost;
	}
	
	private void dfs(Graph graph, final int v) {
		pre.enqueue(v);
		marked[v] = true;

		for(Edge w : graph.adj(v)) {
			if(!marked[w.tail()]) dfs(graph, w.tail());
		}
		
		post.enqueue(v);
		reversePost.push(v);
	}
}
