package pureStorage;

public class CountPalindrome {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(count_palindromes("hellolle"));
	}
	static int count_palindromes(String S){
int count = 0, i = 1;
        
        while(i<S.length()){
            int j = 1;
            while(i-j >= 0 && i+j<S.length() && S.charAt(i-j) == S.charAt(i+j)){
                count++;                
                j++;
            }
            int even = i, evenLeft = i-1;
            while(even < S.length() && evenLeft >= 0 && S.charAt(even) == S.charAt(evenLeft)){
                count++;
                even++;
                evenLeft--;
            }
            i++;            
        }
        count += S.length();
        return count;		
	}
}
