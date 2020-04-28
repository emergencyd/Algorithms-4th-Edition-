package Chapter_1_5;

public class QuickUnionUF {
	private int[] id;
	private int count;
	int access;

	public QuickUnionUF(int N) {
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}
	
	public int count() {return count;}
	public boolean connected(int p, int q) {return find(p) == find(q);}
	
	public int find(int p) {
		while (p != id[p]) {
			p = id[p];
			access += 2;
		}
		access++;
		return p;
	}
	
	public void union(int p, int q) {
		access = 0;
		int pRoot = find(p);
		int qRoot = find(q);
		
		if (pRoot != qRoot) {
			id[pRoot] = qRoot;
			access++;
			count--;
		}
		
		System.out.print(p + "-" + q + ": ");
		for (int i: id) {
			System.out.print(i + " ");
		}
		System.out.println("; " + access + " access");
	}
	
	public static void main(String[] args) {
		int N = 10;
		QuickUnionUF uf = new QuickUnionUF(N);
		int[] ps = {9, 3, 5, 7, 2, 5, 0, 4};
		int[] qs = {0, 4, 8, 2, 1, 7, 3, 2};
		for (int i = 0; i < 8; i++) {
			uf.union(ps[i], qs[i]);
		}
		System.out.println(uf.count() + " components");
	}
}
