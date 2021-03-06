package Chapter_1_5;

public class QuickFindUF {
	private int[] id;
	private int count;
	int access;

	public QuickFindUF(int N) {
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}
	
	public int count() {return count;}
	public boolean connected(int p, int q) {return find(p) == find(q);}
	
	public int find(int p) {
		access++;
		return id[p];
	}
	
	public void union(int p, int q) {
		access = 0;
		int pID = find(p);
		int qID = find(q);
		
		if (pID != qID) {
			for (int i = 0; i < id.length; i++) {
				access++;
				if (id[i] == pID) {
					id[i] = qID;
					access++;
				}
			}
			count--;
		}
		
		// print information
		System.out.print(p + "-" + q + ": ");
		for (int i: id) {
			System.out.print(i + " ");
		}
		System.out.println("; " + access + " access");
	}
	
	public static void main(String[] args) {
		int N = 10;
		QuickFindUF uf = new QuickFindUF(N);
		int[] ps = {9, 3, 5, 7, 2, 5, 0, 4};
		int[] qs = {0, 4, 8, 2, 1, 7, 3, 2};
		for (int i = 0; i < 8; i++) {
			uf.union(ps[i], qs[i]);
		}
		System.out.println(uf.count() + " components");
	}
}
