package GoldmanSachs;

public class TravelUpNSteps {

	public static void main(String[] args) {
		//call helper method - recursion method - 1st parameter n, 2nd is how many way he can reach, 3rd parameter is where he is at n 
		
		System.out.println(helper(4, 0, 0));
	}

	private static int helper(int i, int success, int reached) {
		//reached the n step
		if(reached == i)
			return success+1;
		else if(reached < i){
			return helper(i, success, reached+1) + helper(i, success, reached+2) + helper(i, success, reached+3);
		}
		return 0;
		
	}
	
	

}
