class Solution {
    public String longestPalindrome(String s) {
		// TODO Auto-generated method stub
        if (s.length() == 1) return s;
		int max = 0;
		String palindrom = "";
        palindrom = String.valueOf(s.charAt(0));
		for(int i = 0; i< s.length(); i++){
			
			//Odd
			int index = 1;
			while(i-index >= 0 && i+index < s.length()){
				if(s.charAt(i-index) == s.charAt(i+index)){					
					if(max < (index*2+1) ){
						max = index*2+1;
						palindrom = s.substring(i-index, i+index+1);				
					}
					index++;
				}else
					break;
			}
						
			//Even
			int leftIndex = i;
			int rightIndex = i+1;			
			while(leftIndex >= 0 && rightIndex < s.length()){
				if(s.charAt(leftIndex) == s.charAt(rightIndex)){					
					if(max < (rightIndex - leftIndex + 1) ){
						max = rightIndex - leftIndex + 1;
						palindrom = s.substring(leftIndex, rightIndex+1);
					}
					leftIndex--;
					rightIndex++;
				}else
					break;
			}
		}
		//System.out.println(palindrom);
		return palindrom;
	}
}