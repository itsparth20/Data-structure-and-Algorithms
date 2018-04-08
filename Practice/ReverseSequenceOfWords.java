package practiceProblem;

public class ReverseSequenceOfWords {
	public static void main(String[] args) {
		String str = "Hey Love";
		ReverseSequenceOfWords obj = new ReverseSequenceOfWords();
		System.out.println(obj.reverseSequenceOfWord(str));
	}

	private char[] reverseSequenceOfWord(String str) {

		char[] strArr = str.toCharArray();
		int start = 0;
		int last = strArr.length-1;
		reverseArray(strArr, start, last);
		start = 0;
		last = 0;
		int index = -1;
		while(index < strArr.length){
			start = ++index;
			while(index < strArr.length && strArr[index] != ' '){
				index++;
			}
			last = index-1;		
			reverseArray(strArr, start, last);
		}
		return strArr;
	}
	
	private void reverseArray(char[] strArr, int start, int last) {
		while(start < last){
			char temp = strArr[start];
			strArr[start] = strArr[last];
			strArr[last] = temp;
			start++;
			last--;
		}
	}

	@Test
	public void testReverseSequenceOfWord() {
		ReverseSequenceOfWords obj = new ReverseSequenceOfWords();
		assertEquals("Love Hey", new String(obj.reverseSequenceOfWord("Hey Love")));
		assertEquals("Mitt am I", new String(obj.reverseSequenceOfWord("I am Mitt")));
	}

}