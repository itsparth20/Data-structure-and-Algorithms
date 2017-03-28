package alice;

import java.util.Scanner;

class ShortestPath {
	public static int shortestpath(int[][] matrix, int Node) {
		int dist[][] = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				dist[i][j] = matrix[i][j];
			}
		}
		for (int k = 0; k < matrix.length; k++) {
			for (int a = 0; a < matrix.length; a++) {
				for (int b = 0; b < matrix.length; b++) {
					if (dist[a][k] + dist[k][b] < dist[a][b])
						dist[a][b] = dist[a][k] + dist[k][b];
				}
			}
		}
		if (dist[0][Node - 1] > 0) {
			return dist[0][Node - 1];
		}
		if (dist[0][Node - 1] == 0) {
			return -1;
		}
		return 0;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Node = sc.nextInt();
		int edge = sc.nextInt();
		int[][] matrix = new int[Node][Node];
		for (int i = 0; i < edge; i++) {
			int to = sc.nextInt();
			int from = sc.nextInt();
			int weight = sc.nextInt();
			matrix[to - 1][from - 1] = weight;
		}
		System.out.println(shortestpath(matrix, Node));
		/*
		 * for(int i = 0 ; i < matrix.length ; i++){ for(int j = 0 ; j <
		 * matrix[0].length ; j++){ System.out.print(matrix[i][j]+ " "); }
		 * System.out.println(" "); } }
		 */

	}
}