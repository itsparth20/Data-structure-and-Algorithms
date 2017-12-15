package finalproject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class FinalProject {
	private static final String habitatsFileName = "habitats.txt";
	private static final String animalFileName = "animals.txt";

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// Create a scanner for later user input
		Scanner scnr = new Scanner(System.in);

		// Create integer variable to store the users navigation choices
		int navigator;

		// Use a while loop to contain a switch statement calling methods for
		// the monitoring process
		while (true) {
			// Create the initial text dialog for the user
			System.out.println("Welcome to the Southern New Hampshire Zoo Monitoring System");
			System.out.println("Please select an option below:");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("To monitor an animal, press the number 1");
			System.out.println("To monitor a habitat, press the number 2");
			System.out.println("To exit the application, press the number 3");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

			// assign the user's input to the navigator int
			navigator = scnr.nextInt();

			// create a switch statement to contain the user's choice and
			// corresponding method calls
			switch (navigator) {
			case 1:
				Animal();
				break;
			case 2:
				Habitat();
				break;
			case 3:
				System.exit(0);
			default:
				System.out.println("Please enter a valid number");
			}
		}

	}

	//Print Animal menu
	private static void Animal() throws FileNotFoundException, IOException {
		System.out.println("Animals currently on exibit:");
		executeUserChoice(animalFileName);
		
	}

	//Execute user request.
	private static void executeUserChoice(String fileName) throws FileNotFoundException, IOException {
		Scanner sc = new Scanner(System.in);
		int op = 0, blankL = 0, i = -1;
		boolean flag = false;
		// read .txt file
		BufferedReader aReader = new BufferedReader(new FileReader(fileName));
		// declare array for text strings
		String[] fileData = null;
		String line;
		// read line from the files
		while ((line = aReader.readLine()) != null) {
			int area = 0;
			if (line.equals("")) {
				blankL++;
				i++;
				flag = true;
				area = 1;
				if (blankL == 1) fileData = new String[op];				
			}				
			if (blankL != 0 && area == 0) {
				if (!flag) 
					fileData[i] = fileData[i] + "\n" + line;
				else{
					fileData[i] = line;
					flag = false;
				} 
			}
			else if (blankL == 0) System.out.println((++op) + " to see " + line);
		}

		int userChoice = sc.nextInt();
		System.out.println(fileData[userChoice - 1]);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		//show dialog box if it contain ****
		if (fileData[userChoice - 1].contains("****")) 
			JOptionPane.showMessageDialog(null, getMsg(fileData, userChoice));
		
		aReader.close();
	}
	//Get ***** msg from the line
	private static String getMsg(String[] animalText, int nextAnimal) {
		String message = animalText[nextAnimal - 1];
		String[] arr = message.split("\n");
		for (String s : arr) {
			if (s.startsWith("*****")) {
				message = s.substring(5);
				break;
			}
		}
		return message;
	}

	//Print Habitat menu
	private static void Habitat() throws FileNotFoundException, IOException {
		System.out.println("Habitats currently in use:");
		executeUserChoice(habitatsFileName);
	}
}
