package exam.com.itstudent20;

import java.util.Scanner;

public class Assignment2Q4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your age: ");
		int age = sc.nextInt();
		if(age>17){
			System.out.println("You are authorized to vote.");
		}else{
			System.out.println("You are not authorized to vote.");
		}
	}

}
