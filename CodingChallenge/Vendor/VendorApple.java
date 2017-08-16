package tries;

import java.util.HashMap;
import java.util.Map;

public class VendorApple {

	public static class TextInput {
		public StringBuffer sb = new StringBuffer();

		public void add(char ch) {
			sb.append(ch);
		}

		public String getValue() {
			return sb.toString();
		}
	}

	public static class NumericInput extends TextInput {
		public void add(char ch) {
			if (ch >= '0' && ch <= '9')
				sb.append(ch);
		}
	}

	public static void main(String[] args) {
		 TextInput input = new NumericInput();
		 input.add('1');
		 input.add('a');
		 input.add('0');
		 System.out.println(input.getValue());
	}

	//Two Sum Program
	public static int[] findTwoSum(int[] list, int sum) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < list.length; i++) {

			if (map.containsKey(list[i])) {
				return new int[] { map.get(list[i]), i };
			}
			int complement = sum - list[i];
			map.put(complement, i);
		}
		return null;
	}
}
