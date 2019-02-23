class Gmatrix {
	int V;
	int E;
	// String[] countries;
	int[][] matrix;
	Gmatrix (int V, int E) {
		this.V = V;
		this.E = E;
		matrix = new int[this.V][this.V];
	}
	int c = 0;
	public void addEdge(int v, int e) {
		if (matrix[v][e] == 1) {
			// matrix[v][e] = 1;
			c++;
		}
	}

	public String toString() {
		String str = "";
        // str += V + " vertices, " + E + " edges" + "\n";
        if (E > 0) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    str += matrix[i][j] + " ";
                }
                str += "\n";
            }
        } else {
            str += "No edges";
            System.out.println(str);
        }
        return str.toString();
	}
}