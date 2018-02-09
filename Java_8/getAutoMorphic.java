package freelance.visa;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;

class AutoMorPhicProgram {

	public static void main(String[] args) {
		System.out.println(getAutoMorphic(1,1000));
	} 
	public static List<Integer> getAutoMorphic(int start, int end) {
		return IntStream.range(start, end+1).filter(x ->{
			int sqr = x*x;
			String no1 = String.valueOf(x);
			String no2 = String.valueOf(sqr);
			return no2.endsWith(no1);
		}).mapToObj(x -> x).collect(Collectors.toList());	
	}
	
	@Test
	public void test() {		
		assertEquals(List.of(1, 5, 6, 25, 76, 376, 625), getAutoMorphic(1,1000));		
	}
}
