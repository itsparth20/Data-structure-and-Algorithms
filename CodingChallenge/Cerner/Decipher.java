package cerner;

public class Decipher {

	public static void main(String[] args) {		
		System.out.println(getDeCipher("abc"));
	}
	
	public static String getDeCipher(String cipher){
		StringBuffer sb = new StringBuffer(); 
		for(char s : cipher.toCharArray()){
			if(s >= 97 && s <=122){
				sb.append((char)(s-49));
			}else{
				return "None";
			}
		}
		return sb.toString();
	}

}
