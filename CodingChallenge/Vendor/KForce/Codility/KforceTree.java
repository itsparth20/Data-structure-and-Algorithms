/*
Task description
In this problem we consider binary trees, represented by pointer data-structures. A pointer is called a binary tree if:
it is an empty pointer (it is then called an empty tree); or
it points to a structure (called a node) that contains a value and two pointers that are binary trees (called the left subtree and the right subtree).
A figure below shows a tree consisting of six nodes.
A path in a binary tree is a sequence of nodes one can traverse by following the pointers. More formally, a path is a sequence of nodes P[0], P[1], ..., P[K], such that node P[L] contains a pointer pointing to P[L + 1], for 0 ≤ L < K. K is called the length of such a path.
The height of a binary tree is defined as the length of the longest possible path in the tree. In particular, a tree consisting only of just one node has height 0 and the height of an empty tree is undefined.
For example, consider the following tree:

Subtrees of nodes D, E and F are empty trees. Sequence A, B, E is a path of length 2. Sequence C, F is a path of length 1. Sequence E, B, D is not a valid path. The height of this tree is 2.
Assume that the following declarations are given:
class Tree {
  public int x;
  public Tree l;
  public Tree r;
}
Write a function:
class Solution { public int solution(Tree T); }
that, given a non-empty binary tree T consisting of N nodes, returns its height.
For example, given tree T shown in the example above, the function should return 2.
Assume that:
N is an integer within the range [1..1,000].
Complexity:
expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N).
 */
public class KforceTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Tree TLL = new Tree(20, null, null);
		Tree TLR = new Tree(21, null, null);
		Tree TRL = new Tree(1, null, null);
		Tree TR = new Tree(10, TRL);
		
		Tree TL = new Tree(3, TLL, TLR);
		Tree T = new Tree(5, TL, TR);
		System.out.println(solution(T));
	}
	
	public static int solution(Tree T){		
		
		if(T == null) return -1;
		Val val = new Val();
		helper(T, T.x, val);
		return val.count;
		
	}
	
	public static void helper(Tree t, int x, Val val){
		if(t == null){
			return; 
		}
		if(t.x >= x){
			val.count++;
		}
		int p = x > t.x ? x : t.x;
		helper(t.l, p, val);
		helper(t.r, p, val);
	}
	
	

}

class Val{
	int count = 0;
}

class Tree{
	public int x;
	public Tree l;
	public Tree r;
	/**
	 * @param x
	 * @param l
	 * @param r
	 */
	public Tree(int x, Tree l, Tree r) {
		super();
		this.x = x;
		this.l = l;
		this.r = r;
	}
	/**
	 * @param x
	 */
	public Tree(int x) {
		super();
		this.x = x;
	}
	/**
	 * @param l
	 */
	public Tree(Tree l) {
		super();
		this.l = l;
	}
	
	/**
	 * @param l
	 * @param r
	 */
	public Tree(Tree l, Tree r) {
		super();
		this.l = l;
		this.r = r;
	}
	/**
	 * @param x
	 * @param l
	 */
	public Tree(int x, Tree l) {
		super();
		this.x = x;
		this.l = l;
	}
}
