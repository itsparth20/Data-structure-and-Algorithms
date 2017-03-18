
package gigster.demo;

public class Equilibrium {
	public static void main(String[] args){
		Equilibrium s = new Equilibrium();
		int[] A = {-1,3,-4,5,1,-6,2,1};
		s.solution(A);		
	}
	public int solution(int[] A){		
		int[] arr = new int[A.length];
		int i = 0;
		int sum =0;
		while(i<A.length){
			arr[i] = sum;
			sum += A[i];
			i++;
		}		
		i=0;
		while(i<A.length){
			if(arr[i] == sum-A[i]-arr[i]){
				System.out.println(i);
				
			}
			i++;
		}
		return -1;
	}
}

