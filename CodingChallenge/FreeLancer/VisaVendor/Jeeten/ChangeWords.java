package freelance.visa;

import javax.net.ssl.SSLContext;

public class ChangeWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(getString("visa printer function dgsdfsdfsd"));
	}
	
	public static String getString(String s) {
		StringBuilder sb = new StringBuilder();
		String[] arr = s.split(" ");
		for(String str: arr) {
			sb.append(str.charAt(0));
			sb.append(str.length()-2);
			sb.append(str.charAt(str.length()-1));
			sb.append(" ");
		}
		return sb.toString();
	}

}
