package tries;

import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

		Runnable task = () -> {
			System.out.println("Scheduling FixedRate: " + LocalTime.now() );
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};

		int initialDelay = 0;
		int period = 1;
		executor.scheduleAtFixedRate(task, initialDelay, period, TimeUnit.SECONDS);
		ScheduledExecutorService executorr = Executors.newScheduledThreadPool(1);

		Runnable taskk = () -> {
		    try {
		        TimeUnit.SECONDS.sleep(2);
		        System.out.println("Scheduling FixedDelay: " + LocalTime.now());
		    }
		    catch (InterruptedException e) {
		        System.err.println("task interrupted");
		    }
		};

		executorr.scheduleWithFixedDelay(taskk, 0, 1, TimeUnit.SECONDS);
	}
	public static void method(){
		
		
	}

}
