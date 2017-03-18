package gigster.testFinal;

public class ParkingCost {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int solution(String E, String L){
        String entry[]= E.split(":");
        int entertime= Integer.parseInt(entry[0])*60 + Integer.parseInt(entry[1]);
        String exit[]= L.split(":");
        int exittime= Integer.parseInt(exit[0])*60 + Integer.parseInt(exit[1]);
        int diffTime = exittime- entertime;
        int finalTime = diffTime%60 != 0 ? (diffTime/60)+1 : diffTime/60;
        int amount = finalTime > 1 ? 2 + 3 + (finalTime-1)*4 : 5;
        return amount;
    }

}
