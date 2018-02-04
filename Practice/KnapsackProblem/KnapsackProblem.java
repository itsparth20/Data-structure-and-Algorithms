package main.java.practice.dynamicProgramming;

public class KnapsackProblem {
	private int maxVal = Integer.MIN_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int weight[] = {10,20,30};
		int value[] = {130, 100, 120};
		int capacity = 50;
		KnapsackProblem obj = new KnapsackProblem();
		System.out.print(obj.getMaxVal(weight, value, capacity));
		
	}
	
	public int getMaxVal(int[] weight, int[] value, int capacity) {
		
		helper(weight, value, capacity, 0, 0, 0);
		
		return maxVal;
	}
	
	public void helper(int[] weight, int[] value, int capacity, int totalWeight, int totalValue, int index) {
		if(totalWeight > capacity) 
			return;
		if(totalValue > maxVal)
			maxVal = totalValue;
		
		for(int i = index; i < weight.length; i++) {
			helper(weight, value, capacity, totalWeight+weight[i], totalValue+value[i], i+1);
			helper(weight, value, capacity, totalWeight, totalValue, i+1);
		}
	}

}
