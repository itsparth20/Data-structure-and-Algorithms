package multithreading.deadlock;

public class DeadlockExample{

	String s1 = "String One";
	String s2 = "String Two";
	
	public static void main(String[] args) {

		DeadlockExample obj = new DeadlockExample();
		DeadlockExample.ThreadClassOne one = obj.new ThreadClassOne();
		DeadlockExample.ThreadClassTwo two = obj.new ThreadClassTwo();
		
		
		one.start();		
		two.start();
	}
	class ThreadClassOne extends Thread{
		public void run(){
			synchronized(s1){
				try {
					System.out.println("Lock on S1");
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Waiting to unLock S2 so S1 can lock s2");
				synchronized(s2){
					System.out.println("Inside threadClassOne");
				}
			}
		}
	}
	class ThreadClassTwo extends Thread{
		public void run(){
			synchronized(s2){
				try {
					System.out.println("Lock on S2");
					Thread.sleep(1000);					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Waiting to unLock S1 so S2 can lock s1");
				synchronized(s1){
					System.out.println("Inside threadClassTwo");
				}
			}
		}
	}
	
}


