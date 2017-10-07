package tries;

import java.time.LocalTime;
import static java.time.temporal.ChronoUnit.MINUTES;

/*
 * Parking problem: First hour charge is 5 dollar [2 dollar for entry charge and 3$ for first hour charge], extra hours 4$/hour
 * 
 * You have given the starting and ending time. Calculate the total fees you need to pay  
 */
public class ParkingProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getPrice("10:00","13:31"));
	}

	public static int getPrice(String entryTime, String stopTime){

		//Used Java 8 date time api
		LocalTime startTime = LocalTime.parse(entryTime);
		LocalTime endTime =  LocalTime.parse(stopTime);

		//calculate the extra time 
		int time = (int) startTime.until(endTime, MINUTES) - 60;

		//if partial minute then add 1 hour to it.
		int remin = time%60 == 0 ? time/60 : (time/60) + 1;		

		return remin > 0 ? 5 + ((remin)*4) : 5;
	}
}
