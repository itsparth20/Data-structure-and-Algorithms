/* Class to help you test yopur implementation of the classes CodePair and ArrayCode */
public class TestArray {

    public static void main(String[] args) {
	CodePair p;
	ArrayCode list = null;
	boolean test = true;

	System.out.println("\nTests for classes CodePair and ArrayCode");
	System.out.println("========================================");
	p = new CodePair('a',"1000");
	if (p.getCharacter() != 'a') test = false;
	if (!p.getCode().equals("1000")) test = false;
	p.setCharacter('b');
	if (p.getCharacter() != 'b') test = false;
	p.setCode("01010101");
	if (!p.getCode().equals("01010101")) test = false;

	if (test) System.out.println("Test 1 passed");
	else System.out.println("Test 1 failed");

	try {
	    test = true;
	    list = new ArrayCode(20);
	    if(list.getSize() != 20) test = false;
	    if (list.getNumPairs() != 0) test = false;

	    for (int i = 1; i <= 20; ++i)
		list.add(new CodePair((char)i,Integer.toBinaryString(i)));

	    if (list.getSize() != 20) test = false;
	    if (list.getNumPairs() != 20) test = false;	

	    if (test) System.out.println("Test 2 passed");
	    else System.out.println("Test 2 failed");
	}	
	catch (Exception e) {
	    System.out.println("Test 2 failed");
	}

	try {
	    test = true;
	    for (int i = 1; i <= 20; ++i) {
		if (list.findCharacter((char)i) != (i-1)) test = false;
		if (list.findCode(Integer.toBinaryString(i)) != (i-1)) test = false;
	    }

	    if (test) System.out.println("Test 3 passed");
	    else System.out.println("Test 3 failed");
	}
	catch (Exception e) {
	    System.out.println("Test 3 failed");
	}

	try {
	    test = true;
	    for (int i = 1; i <= 20; ++i) {
		if (list.getCharacter(i-1) != (char)i) test = false;
		if (!list.getCode(i-1).equals(Integer.toBinaryString(i))) test = false;
	    }

	    if (list.getCharacter(-1) != (char)0) test = false;
	    if (list.getCode(-1) != null) test = false;

	    if (test) System.out.println("Test 4 passed");
	    else System.out.println("Test 4 failed");
	}
	catch (Exception e) {
	    System.out.println("Test 4 failed");
	}

	try {
	    test = true;
	    list.remove(new CodePair((char)10,"1010"));
	    if (list.findCode("1010") != -1 || list.findCharacter((char)10) != -1)
		test = false;

	    if (list.getSize() != 20 || list.getNumPairs() != 19) test = false;

	    if (test) System.out.println("Test 5 passed");
	    else System.out.println("Test 5 failed");
	}
	catch (Exception e) {
	    System.out.println("Test 5 failed");
	}

	try {
	    int i;
	    test = true;
	    list = new ArrayCode(26);
	    for (i = 1; i <= 27; ++i)
		list.add(new CodePair((char)i,Integer.toBinaryString(i)));

	    if (list.getSize() != 52) test = false;

	    for (i = 28; i <= 53; ++i)
		list.add(new CodePair((char)i,Integer.toBinaryString(i)));
	    if (list.getSize() != 104) test = false;

	    for (i = 54; i <= 105; ++i)
		list.add(new CodePair((char)i,Integer.toBinaryString(i)));
	    if (list.getSize() != 124) test = false;

	    for (i = 1; i <= 101; ++i)
		if (list.findCharacter((char)i) != (i-1)) test = false;

	    if (test) System.out.println("Test 6 passed");
	    else System.out.println("Test 6 failed");
	}
	catch (Exception e) {
	    System.out.println("Test 6 failed");
	}

	try {
	    int i;
	    test = true;
	    list = new ArrayCode(100);
	    for (i = 1; i <= 25; ++i)
		list.add(new CodePair((char)i,Integer.toBinaryString(i)));

	    list.remove(new CodePair((char)5,"101"));
	    if (list.getSize() != 50) test = false;

	    for (i = 1; i <= 4; ++i)
		if (list.findCharacter((char)i) != (i-1)) test = false;

	    if (list.findCharacter((char)5) != -1) test = false;
	    if (list.getCode(51) != null) test = false;

	    if (test) System.out.println("Test 7 passed");
	    else System.out.println("Test 7 failed");
	}
	catch (Exception e) {
	    System.out.println("Test 7 failed");
	}
    }
}