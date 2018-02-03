package main.java.fileReadWrite;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class countWordFrequency {

	public static void countWordFrequency(String file) {

		// Map to store the words and their count
		Map<String, Integer> countMap = new HashMap<>();

		try (Stream<String> lines = Files.lines(Paths.get(file))) {

			lines.map(line -> line.split("\\s")).flatMap(Arrays::stream) // Convert
																			// stream
																			// of
																			// String[]
																			// to
																			// stream
																			// of
																			// String
					//.parallel() // convert the parallel stream for faster
								// execution
					.map(word -> word.replaceAll("[^a-zA-Z0-9]", "") // only keep
																	// words in
																	// the word
																	// stream,
																	// and
																	// filter
																	// punctuation
							.trim()).forEach(word -> {
								countMap.putIfAbsent(word, new Integer(0));
								countMap.put(word, countMap.get(word) + 1);
					});
			countMap.entrySet().stream().sorted((ob1, ob2) -> ob2.getValue() - ob1.getValue()).forEach(System.out::println);
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// change this file location
		String fileURI = "Z:/test.txt";
		countWordFrequency(fileURI);
	}
}