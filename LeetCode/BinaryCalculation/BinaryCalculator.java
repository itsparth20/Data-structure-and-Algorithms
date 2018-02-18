package freelance.binarycalculation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BinaryCalculator {

	private static List<String> lst = new ArrayList<>(Arrays.asList("A) Binary to Decimal", "B) Decimal to binary",
			"C) Addition", "D) Substraction", "E) Multiplication", "F) Division", "G) Quit"));
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
				
		displayMenu();
		String choice = sc.nextLine().trim().toUpperCase();
		while (!choice.equals("G")) {			
			switch (choice) {
			case "A":
				binaryToDecimal();
				displayMenu();
//				sc.nextLine();
				choice = sc.nextLine().trim().toUpperCase();
				break;
			case "B":
				decimalToBinary();
				displayMenu();
//				sc.nextLine();
				choice = sc.nextLine().trim().toUpperCase();
				break;
			case "C":
				addition();
				displayMenu();
				sc.nextLine();
				choice = sc.nextLine().trim().toUpperCase();
				break;
			case "D":
				subtraction();
				displayMenu();
				sc.nextLine();
				choice = sc.nextLine().trim().toUpperCase();
				break;
			case "E":
				multiplication();
				displayMenu();
				sc.nextLine();
				choice = sc.nextLine().trim().toUpperCase();
				break;
			case "F":
				division();
				displayMenu();
				sc.nextLine();
				choice = sc.nextLine().trim().toUpperCase();
				break;
			case "G":				
				break;
			default:	
				System.out.println("\n\nPlease select from A to G\n");
				displayMenu();
				choice = sc.nextLine().trim().toUpperCase();
				break;
			}
		}
		System.out.println("\nBye");
	}

	private static void division() {
		System.out.print("Enter a number: ");
		int no1 = sc.nextInt();
		System.out.print("Enter another number: ");
		int no2 = sc.nextInt();		
		if(no2 == 0) {
			System.out.println("Can not divide by 0");
			return;			
		}
		System.out.println("Multiplication: " + (no1 / no2));
	}

	private static void multiplication() {
		System.out.print("Enter a number: ");
		int no1 = sc.nextInt();
		System.out.print("Enter another number: ");
		int no2 = sc.nextInt();
		System.out.println("Multiplication: " + (no1 * no2));
	}

	private static void subtraction() {
		System.out.print("Enter a number: ");
		int no1 = sc.nextInt();
		System.out.print("Enter another number: ");
		int no2 = sc.nextInt();
		System.out.println("Subtraction: " + (no1 - no2));
	}

	private static void addition() {
		System.out.print("Enter a number: ");
		int no1 = sc.nextInt();
		System.out.print("Enter another number: ");
		int no2 = sc.nextInt();
		System.out.println("Addition: " + (no1 + no2));		
	}

	private static void decimalToBinary() {
		System.out.println("Enter Decimal Number: ");
		String no = sc.nextLine().trim();
		String noArr[] = no.split("\\.");
		StringBuilder sb = new StringBuilder();
		int no1 = Integer.valueOf(noArr[0]);
		String no1Binary = "0";
		if(no1 > 0) {
			no1Binary = getBinary(no1);
			no1Binary = "0"+ no1Binary;
		}else {
			no1Binary = getBinary(no1 * -1);
			no1Binary = flip(no1Binary);			
			no1Binary = "1" + no1Binary;
			//do 1 plus here.
		}
		if(noArr.length > 1) {
			String decimalPoint = getBinary(Integer.valueOf(noArr[1]));
			no1Binary += "." + decimalPoint;
		}
		System.out.println(no1Binary);		
	}

	private static String flip(String no1Binary) {
		StringBuilder sb = new StringBuilder();
		for(char ch : no1Binary.toCharArray()) {
			sb.append(ch == '0' ? '1' : '0');
		}		
		return sb.toString();
	}

	private static String getBinary(int no1) {
		StringBuilder sb = new StringBuilder();
		while(no1 > 0) {
			sb.append(no1%2);
			no1 /= 2;			
		}		
		return sb.reverse().toString();
	}

	private static void binaryToDecimal() {
		System.out.println("Enter Binary Number: ");
		String binaryString = sc.nextLine();
		String[] binaryStrArr = binaryString.split("\\.");
		
		StringBuilder sb = new StringBuilder();
		int no1 = Integer.valueOf(binaryStrArr[0]);
		int decimal = 0;
		int p = 0;
		while(no1 != 0) {
			decimal+=((no1%10)*Math.pow(2,p));
            no1=no1/10;
            p++;
		}
		sb.append(decimal);
		if(binaryStrArr.length > 1) {
			no1 = Integer.valueOf(binaryStrArr[1]);
			decimal = 0;
			p = 0;
			while(no1 != 0) {				
				decimal+=((no1%10)*Math.pow(2,p));
	            no1=no1/10;
	            p++;
			}
			sb.append('.');
			sb.append(decimal);
		}
		System.out.println(sb.toString());
	}

	public static void displayMenu() {
		lst.forEach(System.out::println);
	}

}
