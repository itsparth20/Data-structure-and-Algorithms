
public class SecureCardNumber {

	public static void main(String[] args) {
		System.out.println(secureCard("56451215"));
	}

	/*
	 * Task Usually when you buy something, you're asked whether your credit
	 * card number, phone number or answer to your most secret question is still
	 * correct. However, since someone could look over your shoulder, you don't
	 * want that shown on your screen. Instead, we mask it. Your task is to
	 * write a function maskify, which changes all but the last four characters
	 * into '#'. Examples Input Output Comments "4556364607935616"
	 * "############5616" "64607935616" "#######5616" "1" "1" No #s if less than
	 * 4 characters "" "" Make sure to handle empty strings "Skippy" "##ippy"
	 * 
	 */
	private static String secureCard(String cc) {

		if (cc.trim().length() <= 4) {
			return cc;
		} else {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < cc.length() - 4; i++) {
				sb.append("#");
			}
			sb.append(cc.substring(cc.length() - 4));
			return sb.toString();
		}
	}

}
