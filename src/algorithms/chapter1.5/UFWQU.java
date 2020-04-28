package Chapter_1_5;

public class UFWQU {
	private int[] id;
	private int[] sz;
	private int count;
	int access;

	public UFWQU(int N) {
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++) {id[i] = i;}
		sz = new int[N];
		for (int i = 0; i < N; i++) {sz[i] = 1;}
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
		int i = find(p);
		int j = find(q);
		
		if (i != j) {
			if (sz[i] < sz[j]) {
				id[i] = j;
				sz[j] += sz[i];
			}
			else {
				id[j] = i;
				sz[i] += sz[j];
			}
			access += 5;
			count--;
		}
		
		System.out.print(p + "-" + q + ": ");
		for (int k: id) {
			System.out.print(k + " ");
		}
		
		System.out.println();
		System.out.print("     ");
		
		for (int k: sz) {
			System.out.print(k + " ");
		}
		System.out.println("; " + access + " access");
	}
	
	public static void main(String[] args) {
		UFWQU uf = new UFWQU(10);
		int[] ps = {9, 3, 5, 7, 2, 5, 0, 4};
		int[] qs = {0, 4, 8, 2, 1, 7, 3, 2};
		for (int i = 0; i < 8; i++) {
			uf.union(ps[i], qs[i]);
		}
		System.out.println(uf.count() + " components");
		
		// worst-case
		UFWQU uf2 = new UFWQU(8);
		int[] ms = {0, 2, 4, 6, 0, 4, 0};
		int[] ns = {1, 3, 5, 7, 2, 6, 4};
		for (int i = 0; i < 7; i++) {
			uf2.union(ms[i], ns[i]);
		}
		System.out.println(uf.count() + " components");
	}
}
