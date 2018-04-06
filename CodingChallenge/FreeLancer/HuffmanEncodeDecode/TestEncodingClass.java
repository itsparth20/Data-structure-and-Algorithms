public class TestEncodingClass {

	public static void main(String[] args) {

		System.out.println("\nTests for class EncodingData");
		System.out.println("============================");

		// Test 1

		EncodingData h1 = new EncodingData('a',"0101");
		EncodingData h2 = new EncodingData('a',"0101");

		if (h1.getSymbol() == h2.getSymbol() && h1.getEncoding().equals(h2.getEncoding())) {
			System.out.println("Test 1 passed\n");
		}

		// Test 2

		h1.setEncoding("100100");
		h2.setEncoding("100100");

		if (h1.getEncoding().equals(h2.getEncoding())) {
			System.out.println("Test 2 passed\n");
		}
		else {
			System.out.println("Test 2 failed\n");
		}
		
		if(h1.toString().equals(h2.toString()) && h1.toString() != "") {
			System.out.println("Test 3 passed\n");
		}
		else {
			System.out.println("Test 3 failed\n");
		}
	}
}

