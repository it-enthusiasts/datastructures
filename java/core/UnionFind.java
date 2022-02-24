package core;

public class UnionFind {
	private int[] id;
	private int[] weight;

	public UnionFind(int N) {
		id = new int[N];
		weight = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
			weight[i]=1;
		}
	}

	public void union(int p, int q) {
		int rootp = getRoot(p);
		int rootq = getRoot(q);
		if (rootp == rootq)
			return;
		if (weight[rootp] > weight[rootq]) {
			weight[rootp] += weight[rootq];
			id[rootq] = rootp;
		} else {
			weight[rootq] += weight[rootp];
			id[rootp] = rootq;
		}

	}

	public boolean isConnected(int p, int q) {
		return getRoot(p) == getRoot(q);
	}

	private int getRoot(int p) {
		while (id[p] != p) {
			p = id[p];
		}
		return p;

	}
}
