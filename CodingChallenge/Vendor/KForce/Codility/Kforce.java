import java.util.Map;
import java.util.TreeMap;

public class Kforce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(225));
	}

	public static int solution(int N) {
		Map<Integer, Integer> map = new TreeMap<>((o1, o2) -> o2 > o1 ? 1 : o2 == o1 ? 0 : -1);		
		int rem = 0;
		while (N != 0) {
			rem = N % 10;
			map.putIfAbsent(rem, 0);
			map.put(rem, map.get(rem) + 1);
			N = N / 10;
		}
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			for (int x = 0; x < entry.getValue(); x++) {
				sb.append(entry.getKey());
			}
		}

		return Integer.valueOf(sb.toString());
	}

	public static Integer getReverse(int number) {
		int reverse = 0;
		int rem = 0;
		while (number != 0) {
			rem = number % 10;
			number = number / 10;
			reverse = (reverse * 10) + rem;
		}
		return reverse;
	}

}
