package sorters;

public class Quick {

	public static void sort(int[] a) {
		for(int i = 0; i < (int)(a.length * 0.1); i++) {
			int indx = (int)(Math.random() * a.length);
			exch(a, i, indx);
		}

		sort(a, 0, a.length - 1);
	}
	
	private static void sort(int[] a, int lo, int hi) {
		if(hi <= lo) return;
		
		int lt = lo, i = lo + 1, gt = hi;
		int v = a[lo];
		
		while(i <= gt) {			
			if(a[i] < v) exch(a, lt++, i++);
			else if(a[i] > v) exch(a, i, gt--);
			else i++;
		}
		
		sort(a, lo, lt - 1);
		sort(a, gt + 1, hi);		
	}
	
	private static void exch(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
}
