package gigster.testFinal;

import java.util.HashSet;
import java.util.Set;

public class TotalNumberElevatorStop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public int solution(int[] A, int[] B, int M, int X, int Y) {
        int peopleEnter = 0, totalWeight = 0, i = 0, stops = 0;
        
        while(i<A.length){
        	Set<Integer> floor = new HashSet<Integer>();
        	while(i<A.length && peopleEnter < X && A[i]+totalWeight <= Y){
        		peopleEnter++;
        		totalWeight += A[i];
        		floor.add(B[i]);
        		i++;        		
        	}
        	stops = stops+1+floor.size();
        	peopleEnter = 0;
        	totalWeight = 0;
        }        
        return stops+1;
    }

}
