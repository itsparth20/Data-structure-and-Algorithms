package fileprogram;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Bard {
	static String name = "input.txt";
	static String shakeSpeare = "Shakespeare.txt";
	static String analysis = "analysis.txt";

	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader(name);
			BufferedReader br = new BufferedReader(fr);

			FileWriter fw = new FileWriter(analysis);
			BufferedWriter bw = new BufferedWriter(fw);

			Map<String, Integer> map = getMap();

			String line;
			while ((line = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, " ");
				if (st.countTokens() > 1) {
					int i = Integer.valueOf(st.nextToken());
					int j = Integer.valueOf(st.nextToken());
					Stream<Map.Entry<String, Integer>> sorted = map.entrySet().stream()
							.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()));
					Object[] arr = sorted.filter(q -> q.getKey().length() == i).limit(j).map(d -> d.getKey()).toArray();
					String write = String.valueOf(arr[0]);
					for(int q = 1; q < j; q++){
						write += " " + String.valueOf(arr[q]);
					}					
					bw.write((write));
					bw.newLine();
				} else {
					String word = st.nextToken();
					map.putIfAbsent(word, 0);
					String write = word + " " + map.get(word);					
					bw.write((write+"\n"));
					bw.newLine();
				}
			}
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static Map<String, Integer> getMap() throws IOException {
		FileReader fr = new FileReader(shakeSpeare);
		BufferedReader br = new BufferedReader(fr);
		Map<String, Integer> map = new HashMap<>();
		String line;
		while ((line = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(line, " ");
			while (st.hasMoreTokens()) {
				String word = st.nextToken();
				map.putIfAbsent(word, 0);
				map.compute(word, (k, v) -> v + 1);
			}
		}
		return map;

	}

}
