package practiceProblem.graph;

import java.util.ArrayList;
/*
 * You are given an undirected graph with N vertices and is a tree-like (meaning there are no cycles, no disconnected vertices or disjoined sets). 
If a vertex in the given graph is selected as a root node of a tree, there is an associated height. (The height of a tree is defined as the largest number of nodes in the path from the root to a leaf)
Find the values of vertices, where the associated tree’s height would be a minimum height. If there are ties for minimum, height, return all the values.

There are N vertices, and vertices have values ranging from 0 to N-1

Input:   Integer N denoting number of vertices
	 Array of Two-Item Integers representing edges

Output: Array of Integers representing vertices with minimum height

 */
public class MinimumHeightTrees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int arr[][] = {
				{0,3},
				{1,3},
				{3,2}
		};
		
		int arr1[][] = {
				{0,3},
				{1,3},
				{2,3},
				{4,3},
				{5,4}
		};
		int n1 = 6;
		
		System.out.println(findMinHeightTree(arr, n));
		System.out.println(findMinHeightTree(arr1, n1));
		
	}

	private static ArrayList<Integer> findMinHeightTree(int[][] arr, int n) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> adjacency = new ArrayList<ArrayList<Integer>>();;
		
		for(int i = 0; i<n; i++){
			ArrayList<Integer> neighbour = new ArrayList<Integer>();
			adjacency.add(neighbour);
		}
		
		
		for(int i = 0; i<arr.length; i++){
			
			ArrayList<Integer> neighbour = adjacency.get(arr[i][0]);
			neighbour.add(arr[i][1]);
			adjacency.set(arr[i][0], neighbour);
			
			ArrayList<Integer> neighbourOther = adjacency.get(arr[i][1]);
			neighbourOther.add(arr[i][0]);
			adjacency.set(arr[i][1], neighbourOther);
		}
		
		ArrayList<Integer> degree = new ArrayList<Integer>();
		for(int i = 0; i < n; i++){
			degree.add(adjacency.get(i).size());
		}
		
		ArrayList<Integer> leaves = new ArrayList<Integer>();
		
		for(int i=0; i< degree.size(); i++){
			if(degree.get(i) == 1)
				leaves.add(i);
		}
		
		while(leaves.size() > 2){
			ArrayList<Integer> newLeaves = new ArrayList<Integer>();
			
			for(int i = 0; i < leaves.size(); i++){
//				int node = leaves.get(i);
				int neighb = adjacency.get(leaves.get(i)).get(0);
				degree.set(neighb, degree.get(neighb)-1);
				if(degree.get(neighb) == 1){
					newLeaves.add(neighb);
				}
			}
			leaves = new ArrayList<>(newLeaves);
		}
		return leaves;
	}

}
