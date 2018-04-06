public class TestHuffmanCoder {

	public static void main(String[] args) {

		System.out.println("\nTests for class HuffmanCoder");
		System.out.println("============================");
		
		HuffmanPair[] h = new HuffmanPair[6];
				
		h[0] = new HuffmanPair('a',5);
		h[1] = new HuffmanPair('b',7);
		h[2] = new HuffmanPair('c',10);
		h[3] = new HuffmanPair('d',15);
		h[4] = new HuffmanPair('e',20);
		h[5] = new HuffmanPair('f',45);
				
		ArrayOrderedList<HuffmanPair> list = new ArrayOrderedList<HuffmanPair>();

		for (int i = 0; i < 6; i++) {
			list.add(h[i]);
		}
		HuffmanCoder coder = new HuffmanCoder(list);
		
		if (coder.encode('a').equals("1010") && coder.encode('f').equals("0")) {
			System.out.println("Test 1 passed\n");
		}
		else {
			System.out.println("Test 1 failed\n"); 
		}
		
		if (coder.encode('e').equals("111") && coder.encode('d').equals("110")) {
			System.out.println("Test 2 passed\n");
		}
		else {
			System.out.println("Test 2 failed\n");
		}
		boolean test3 = false;
		try {
			String s = coder.encode('g');
		}
		catch (Exception e) {
			System.out.println("Test 3 passed\n");
			test3 = true;
		}
		if (!test3) {
			System.out.println("Test 3 failed\n");
		}
		
		if (coder.decode("1010") == 'a' && coder.decode("0") == 'f') {
			System.out.println("Test 4 passed\n");
		}
		else {
			System.out.println("Test 4 failed\n");
		}
		if (coder.decode("111") == 'e' && coder.decode("110") == 'd') {
			System.out.println("Test 5 passed\n");
		}
		else {
			System.out.println("Test 5 failed\n");
		}
		char a = coder.decode("0101");

		if (a == (char)0) {
			System.out.println("Test 6 passed\n");
		}
		else {
			System.out.println("Test 6 failed\n");
		}
	}
}
