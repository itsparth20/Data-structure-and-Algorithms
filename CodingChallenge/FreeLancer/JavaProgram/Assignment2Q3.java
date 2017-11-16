package exam.com.itstudent20;

import java.util.Scanner;

public class Assignment2Q3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Password:");
		String pass = sc.nextLine();
		System.out.println("Enter your Password again:");
		String again = sc.nextLine();
		if (pass.equals(again)) {
			if (pass.length() < 8 || pass.length() > 16 || again.length() < 8 || again.length() > 16) {
				printError();
				System.out.println("The password length must be between 8 and 16");
			} else {
				System.out.println("The Password is accepted");
			}
		}else{
			printError();
			System.out.println("The Passwords do not match!");
		}
		if (pass.length() == again.length()) {
			if (pass.equals(again)) {
				System.out.println();
			} else {

			}
		} else {
			System.out.println("The Passwords do not match!");
		}
	}

	private static void printError() {
		System.out.println("The Password is not accepted.");
	}

}
