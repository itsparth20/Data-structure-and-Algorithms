package token;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;


public class HostAndRequest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String FILENAME = "Z:\\Study\\Practice\\workspace\\Practice\\src\\main\\java\\token\\"+input+".txt";
		String OutputFileName = "Z:\\Study\\Practice\\workspace\\Practice\\src\\main\\java\\token\\records_"+input+".txt";
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {

			String sCurrentLine;
			
			while ((sCurrentLine = br.readLine()) != null) {
//				System.out.println(sCurrentLine);
				String[] arr = sCurrentLine.split(" ");
				if(map.containsKey(arr[0]))
					map.put(arr[0], map.get(arr[0])+1);
				else
					map.put(arr[0], 1);
			}
			
			

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(OutputFileName))) {
			
			for(Entry<String, Integer> ent : map.entrySet()){
				System.out.print(ent.getKey()+ " ");
				System.out.print(ent.getValue()+ "\n");
				String content = ent.getKey() + " " + ent.getValue() + "\n"; 
				bw.write(content);
			}

			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		}

		
		
				
	}

}
