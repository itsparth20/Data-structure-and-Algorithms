package alice.cupcake;

class MaxCupCakes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String arr[] = {
				"10 2 5",
				
				};
		maximumCupcakes(arr);
	}
	
	static void maximumCupcakes(String[] trips) {
		for(String s : trips){
			String[] trip = s.split(" ");
			int n = Integer.valueOf(trip[0]);
			int c = Integer.valueOf(trip[1]);
			int m = Integer.valueOf(trip[2]);
			int wraper = n/c;
			int cake = wraper;
			int remWra = 0;
			int pastWra = 0;
			while(wraper>=m){
				cake += wraper/m;
				remWra = wraper%m;
				wraper = wraper/m;
				wraper += remWra;
				//pastWra = wraper;
			}
			System.out.println(cake);	
		}

    }

	
}


