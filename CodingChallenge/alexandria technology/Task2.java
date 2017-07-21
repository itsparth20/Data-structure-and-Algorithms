package Alex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

//I have to sort the file first base on date then base on key

public class Task2 {
	private static final String FILENAME = "C:\\Users\\itspa\\Downloads\\inputfilesfortheprogramminginterview\\task2.log";
	private static final String FILENAMEOUT = "C:\\Users\\itspa\\Downloads\\inputfilesfortheprogramminginterview\\task2DailyReport.txt";	
	private static final SimpleDateFormat sdfAmerica = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	private static final SimpleDateFormat dateFmt = new SimpleDateFormat("yyyy-MM-dd");
	private static int oneStart = 0, twoStart = 0, threeStart = 0, fourStart = 0, fiveStart = 0;

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		FileReader fr = null;
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {
			// reader
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			BufferedReader br1 = br;
			// Create String
			String line;
			// Create arraylist to store string
			List<String> list = new ArrayList<>();
			while ((line = br1.readLine()) != null) {
				list.add(line);
			}
			SortList(list);

			fw = new FileWriter(FILENAMEOUT);
			bw = new BufferedWriter(fw);
			br = new BufferedReader(new FileReader(FILENAME));
			
			// ----------------------------------------- Daily Report -----------------------------------------------
			
			//Get daily report
			dailyReport(bw, list);
			
			// ----------------------------------------- Weekly Report -----------------------------------------------
			
			/*
			 * 1. We can get weekly report by using daily report data and store data to List
			 * 2. Sort daily report data by itemKey and date 
			 * 3. Then we will check date and itemKey one by one
			 * 4. if date is in range of 1 week and itemKey is same then we will update our rating 
			 * 5. if date is not in 1 week range or itemKey is not same then we will make new entry for it.
			 * 6. repeat step 3 to 5 until we reach end of line [until we reach end of list]. 			
			 */
			
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

	private static void dailyReport(BufferedWriter bw, List<String> list) throws IOException, ParseException {
		String sCurrentLine;

		String content = "Date \t\t Item \t\t\t\t\t# of 1 # of 2 # of 3 # of 4 # of 5 \n";
		bw.write(content);
		String prevDate = "";
		String prevKey = "";
		setRatesToZero();
		int count = 0;
		while (count < list.size()) {
			sCurrentLine = list.get(count++);
			String arr[] = sCurrentLine.split(" ");			
			String timeAndKey[] = arr[1].split("\t");			

			if (prevDate.equals("")) {
				prevDate = arr[0];
				prevKey = timeAndKey[1];
			}

			sdfAmerica.setTimeZone(TimeZone.getTimeZone("America/New_York"));			
			if (prevDate.equals(arr[0]) && prevKey.equals(timeAndKey[1])) {
				incrementRate(timeAndKey);
			} else {
				StringBuilder sb = new StringBuilder();
				appendValueToStringBulder(prevDate, prevKey, oneStart, twoStart, threeStart, fourStart, fiveStart,
						sb);
				setRatesToZero();
				incrementRate(timeAndKey);
				prevDate = arr[0];
				prevKey = timeAndKey[1];
				// System.out.println(sb.toString());
				bw.write(sb.toString());
			}
		}
		StringBuilder sb = new StringBuilder();
		appendValueToStringBulder(prevDate, prevKey, oneStart, twoStart, threeStart, fourStart, fiveStart, sb);
		bw.write(sb.toString());
		System.out.println("DONE - Daily Report");
	}

	//set variables to zero
	private static void setRatesToZero() {
		oneStart = 0;
		twoStart = 0;
		threeStart = 0;
		fourStart = 0;
		fiveStart = 0;
	}

	// Increase rate
	private static void incrementRate(String[] timeAndKey) {
		if (timeAndKey[2].equals("1"))
			oneStart++;
		if (timeAndKey[2].equals("2"))
			twoStart++;
		if (timeAndKey[2].equals("3"))
			threeStart++;
		if (timeAndKey[2].equals("4"))
			fourStart++;
		if (timeAndKey[2].equals("5"))
			fiveStart++;
	}

	// Append value to StringBuilder
	private static void appendValueToStringBulder(String prevDate, String prevKey, int oneStart, int twoStart,
			int threeStart, int fourStart, int fiveStart, StringBuilder sb) {
		sb.append(prevDate);
		sb.append("   ");
		sb.append(prevKey);
		sb.append("      ");
		sb.append(String.valueOf(oneStart));
		sb.append("      ");
		sb.append(String.valueOf(twoStart));
		sb.append("      ");
		sb.append(String.valueOf(threeStart));
		sb.append("      ");
		sb.append(String.valueOf(fourStart));
		sb.append("      ");
		sb.append(String.valueOf(fiveStart));
		sb.append("\n");
	}

	// sort list based on date and key
	private static void SortList(List<String> list) {
		list.sort((s1, s2) -> {
			String arrS1[] = s1.split(" ");
			String dateStrS1 = arrS1[0];
			String timeAndKeyS1[] = arrS1[1].split("\t");
			Date dateS1 = null;
			try {
				dateS1 = dateFmt.parse(dateStrS1);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			String arrS2[] = s2.split(" ");
			String dateStrS2 = arrS2[0];
			String timeAndKeyS2[] = arrS2[1].split("\t");
			Date dateS2 = null;
			try {
				dateS2 = dateFmt.parse(dateStrS2);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			if (dateS1.compareTo(dateS2) > 0)
				return 1;
			else if (dateS1.compareTo(dateS2) == 0)
				return timeAndKeyS1[1].compareTo(timeAndKeyS2[1]);
			else
				return -1;

		});
	}
}
