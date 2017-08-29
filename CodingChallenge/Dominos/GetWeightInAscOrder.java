
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class GetWeightInAscOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getWeight("56 65 74 100 99 68 86 180 90"));
	}

	/*
	 * You are provided a string containing a list of positive integers
	 * separated by a space (" "). Take each value and calculate the sum of its
	 * digits, which we call it's "weight". Then return the list in ascending
	 * order by weight, as a string joined by a space. For example 99 will have
	 * "weight" 18, 100 will have "weight" 1 so in the ouput 100 will come
	 * before 99. Example: "56 65 74 100 99 68 86 180 90" ordered by numbers
	 * weights becomes: "100 180 90 56 65 74 68 86 99" When two numbers have the
	 * same "weight", let's consider them to be strings and not numbers: 100 is
	 * before 180 because its "weight" (1) is less than the one of 180 (9) and
	 * 180 is before 90 since, having the same "weight" (9) it comes before as a
	 * string. All numbers in the list are positive integers and the list can be
	 * empty.
	 * 
	 */
	private static String getWeight(String input) {
		String[] inputArr = input.split(" ");
		Map<Integer, List<String>> map = new TreeMap<>();
		for (String s : inputArr) {
			int number = sumOfDigits(Integer.valueOf(s));
			map.putIfAbsent(number, new ArrayList<String>());
			List<String> list = map.get(number);
			list.add(s);
			map.put(number, list);
		}

		StringBuilder sb = new StringBuilder();
		for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
			for (String numStr : entry.getValue()) {
				sb.append(numStr + " ");
			}
		}
		return sb.toString().trim();
		
	}

	private static int sumOfDigits(int num) {

		int sum = 0;
		while (num > 0) {
			sum = sum + num % 10;
			num = num / 10;
		}		
		return sum;
	}

}
