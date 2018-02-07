package freelance.visa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import javax.net.ssl.SSLContext;

public class ChangeWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getString("visa printer function dgsdfsdfsd"));
		
		String x = "racecar";
		IntPredicate p1 = i -> x.charAt(i) == x.charAt(x.length() -1 - i);
		boolean b = IntStream.range(0, x.length()).allMatch(p1);
		System.out.println(b);
	}
	
	public static String getString(String s) {
		StringBuilder sb = new StringBuilder();		
		Arrays.stream(s.split(" ")).forEach(str -> {
			sb.append(str.charAt(0));
			sb.append(str.length()-2);
			sb.append(str.charAt(str.length()-1));
			sb.append(" ");
		});
		
		return sb.toString();
	}
	
	
}
