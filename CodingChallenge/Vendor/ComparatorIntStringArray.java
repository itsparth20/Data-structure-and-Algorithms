import java.util.Arrays;

class Comparator{
	
	public boolean compare(int a, int b){
		return a == b ? true : false;
	}
	
	public boolean compare(String a, String b){
		return a.equals(b)? true : false;
	}
	
	public boolean compare(int[] a, int[] b){
		return Arrays.equals(a, b);
	}
	
}