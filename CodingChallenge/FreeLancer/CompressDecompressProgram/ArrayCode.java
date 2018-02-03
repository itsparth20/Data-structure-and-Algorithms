
/*
 * Class contain array of the CodePair object and integer size
 */

public class ArrayCode {
	CodePair[] arr;
	int size;
	
	public ArrayCode(int size){
		arr = new CodePair[size];
		this.size = 0;
	}
	
	// add pair of CodePair to array
	public void add(CodePair pair){
		if(size < arr.length){
			arr[size] = pair;
			size++;
		}else{
			if(size <= 100){
				CodePair[] newArr = new CodePair[size*2];
				System.arraycopy(arr, 0, newArr, 0, size);
				arr = newArr;
			}else{
				CodePair[] newArr = new CodePair[size+20];
				System.arraycopy(arr, 0, newArr, 0, size);
				arr = newArr;
			}
			arr[size] = pair;
			size++;
		}
	}
	
	//remove CodePair from array
	public void remove(CodePair pair){
		for(int i = 0; i < size; i++){
			if(pair.equals(arr[i])){				
				remove(i);
				break;
			}
		}
	}

	// helper method to remove CodePair from array
	private void remove(int i) {
		if(size-1 < (arr.length/4)){
			CodePair[] newArr = new CodePair[arr.length/2];
			System.arraycopy(arr, 0, newArr, 0, i);
			System.arraycopy(arr, i+1, newArr, i, size-i-1);
			arr = newArr;
		}
		else{
			System.arraycopy(arr, i+1, arr, i, size-i-1);
		}
		size--;
	}
	
	//Find the ondex of the code in array
	public int findCode(String code){
		int i = 0;
		for(i = 0; i < size;){
			if(arr[i].getCode().equals(code)) return i;
			i++;
		}
		return -1;
	}

	//Find the ondex of the character in array	
	public int findCharacter(char c){
		int i = 0;
		for(i = 0; i < size;){
			if(arr[i].getCharacter() ==c) return i;
			i++;
		}
		return -1;
	}
	
	//get code at particular index
	public String getCode(int i){
		if(i < size && i > -1){
			return arr[i].getCode();
		}
		return null;
	}
	
	//get character at particular index
	public char getCharacter(int i){
		if(i < size && i > -1){
			return arr[i].getCharacter();
		}
		return (char)0;
	}
	
	//get size of the array
	public int getSize(){
		return arr.length;
	}
	
	//get total number of object in array
	public int getNumPairs(){
		return size;
	}
}
