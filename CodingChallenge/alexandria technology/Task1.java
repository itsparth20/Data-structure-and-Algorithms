package Alex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Task1 {
	
	private static final String FILENAME = "C:\\Users\\itspa\\Downloads\\inputfilesfortheprogramminginterview\\task1.txt";
	private static final String FILENAMEOUT = "C:\\Users\\itspa\\Downloads\\inputfilesfortheprogramminginterview\\taskOut1.txt";
	
	public static void main(String[] args){
		// Reader
		BufferedReader br = null;
		FileReader fr = null;
		// Writter
		BufferedWriter bw = null;
		FileWriter fw = null;
		try {
			//reader
			fr = new FileReader(FILENAME);			
			br = new BufferedReader(fr);
			//writer
			fw = new FileWriter(FILENAMEOUT);
			bw = new BufferedWriter(fw);
			String sCurrentLine;

			br = new BufferedReader(new FileReader(FILENAME));
			int count =0;
			while ((sCurrentLine = br.readLine()) != null) {
				String[] arr = sCurrentLine.split(" ");			
				StringBuilder sb = new StringBuilder();
				boolean smallLetter = false;
				for(int i = arr.length-1; i >= 0; i--){
					char c = arr[i].charAt(0);
					if(c >= 'A' && c <= 'Z'){
						//Check for CEO
						
						if (smallLetter) 
							smallLetter = false;
						sb.append(arr[i]);
						sb.append(" ");
					}
					else if(arr[i].equals("of") || arr[i].equals("&")){
						smallLetter = true;
						sb.append(arr[i]);
						sb.append(" ");
					}else
						break;
				}
				if(smallLetter){
					sb.replace(sb.length()-3, sb.length(), "");
					sb.append(" ");
				}
				String s = sCurrentLine + "\t" + reverseSequenceOfWord(sb.toString().trim())+ "\n";
//				System.out.println(s);
//				System.out.println(++count);
				//to writing in to file
				bw.write(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();			
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	// Get string by reversing sequece of word
	private static String reverseSequenceOfWord(String str) {
		String[] str1 = str.split(" ");
		StringBuilder sb = new StringBuilder();
		for(int i = str1.length-1; i >=0; i--){
			sb.append(str1[i]);	
			sb.append(" ");
		}
		return sb.toString();
	}
}
