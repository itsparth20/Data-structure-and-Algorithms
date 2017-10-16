package com.program.test.solution.amee;

public class EmailPhoneHide {

	public static void main(String[] args) {
		String email = "parthpatelcs36@gmail.com";
		String number = "6506609514";
		// number = "+91 (333) 444-5678";
		// number = "+111 (111) 444-1234";
		String num = number.replaceAll("[-() ]", "");

		String numberFormate = "***-***-";
		String emailFormate = "*****";
		String star = "*";
		char plus = '+';
		int start = 0;
		StringBuffer sb = new StringBuffer();
		if (num.charAt(0) == plus) {
			sb.append(plus);
			start = 1;
		}
		for (int i = start; i < num.length() - 10; i++) {
			sb.append(star);
		}
		if (start != 0) {
			sb.append("-");
		}
		sb.append(numberFormate + num.substring(num.length() - 4));
		System.out.println(sb.toString());
		System.out.println(email.charAt(0) + emailFormate + email.substring(email.indexOf("@") - 1));
	}

}
