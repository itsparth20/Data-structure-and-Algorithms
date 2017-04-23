package practiceProblem.leetcode;

/*
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s = "25525511135";
		String s1 = "010010";
//		System.out.println(getIp(s));
		System.out.println(getIp(s1));
	}

	private static List<String> getIp(String s) {
		// TODO Auto-generated method stub
		int len = s.length();
		List<String> ips = new ArrayList<String>();
		for(int i = 0; i<4 && i<len-2; i++){
			for(int j = i+1; j<i+4 && j<len-1; j++){
				for(int k = j+1; k<j+4 && k<len; k++){
					String s1 = s.substring(0, i);
					String s2 = s.substring(i, j);
					String s3 = s.substring(j, k);
					String s4 = s.substring(k, len);
					if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)){
						ips.add(s1+"."+s2+"."+s3+"."+s4);
					}
				}
			}
		}

	return ips;

	}

	private static boolean isValid(String s){
		int len = s.length();
		if(len>3 || len == 0 || (s.charAt(0) == '0' && len > 1 ) || Integer.parseInt(s) > 255 )
			return false;
		return true;
	}
	
	
}
