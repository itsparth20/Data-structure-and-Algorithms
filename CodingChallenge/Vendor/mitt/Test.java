import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.Painter;

public class Test {

	public static void main(String[] args) {
		String s ="aaabbc";  
		find(s,2);
	}

	/**
	 * @param s
	 * @param num
	 */
	private static void find(String s, int num) {
		char [] charArray = s.toCharArray();
		
		Map<Character, Integer> map = new HashMap<>();
		
		for (char c:charArray) {
			map.merge(c, 1, Integer::sum);
		}
		
		
		map.forEach((k,v)->System.out.println("key="+k+" value="+v));
		
		map.forEach((k,v) -> {
			for(int i = 0; i < v && i < num; i++)
				System.out.print(k);
		});
				
	}
}