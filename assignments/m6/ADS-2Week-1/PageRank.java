class PageRank {
	Digraph digraph;
	double[] vertex;
	PageRank(Digraph digraph1) {
		this.digraph = digraph1;
		vertex = new double[digraph.V()];
		for (int i = 0; i < vertex.length; i++) {
			vertex[i] = 1.0/digraph.V();
		}
	}
	public double getPR(int v) {
		double PR = vertex[v];
		for(int j = 0; j < 1000; j++) {
			for (int i: digraph.adj(v)) {
				PR = getPR(i) / digraph.outdegree(i);
			}
		}
		return PR;
	}
	public String toString() {
		String str = "";
		str += digraph + "\n";
		for (int i = 0; i < digraph.V(); i++) {
			str += i + " - " + getPR(i) + "\n";
		}
		return str;
	}
}