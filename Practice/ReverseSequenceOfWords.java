package practiceProblem;

public class ReverseSequenceOfWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Hey how are you doing";
		System.out.println(reverseSequenceOfWord(str));
	}

	private static char[] reverseSequenceOfWord(String str) {
		// TODO Auto-generated method stub
		char[] strArr = str.toCharArray();
		int index = 0;
		
		while(index <= strArr.length/2){
			char temp = strArr[index];
			strArr[index] = strArr[strArr.length-1-index];
			strArr[strArr.length-1-index] = temp;
			index++;
		}
		int indexLeft = 0;
		int indexRight = 0;  
		index = -1;
		while(index < strArr.length){
			indexLeft = ++index;
			while(index < strArr.length && strArr[index] != ' '){
				index++;
				
			}
			indexRight = index-1;
			while(indexLeft <= indexLeft+(indexRight-indexLeft)/2){
				char temp = strArr[indexLeft];
				strArr[indexLeft] = strArr[indexRight];
				strArr[indexRight] = temp;
				indexLeft++;
				indexRight--;
			}
		}
		
		return strArr;
	}

}
