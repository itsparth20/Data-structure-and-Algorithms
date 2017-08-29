
public class GetMiddleString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getMiddleStr("aba"));
	}
	/*
	 * abc -> b
	 * aa -> aa
	 * "" -> ""
	 * abba -> bb
	 */
	public static String getMiddleStr(String str) {
		return str.length() % 2 == 0 ? str.substring((str.length() / 2) - 1, (str.length() / 2) + 1)
				: str.substring((str.length() / 2), (str.length() / 2) + 1);		
	}
}
