
public int count(String str, String s){
	int count = 0;
	for(int i = 0; i < str.length()-s.length(); i++){
		boolean match = true;
		for(int j = 0; j < s.length(); j++){
			if(str.charAt(i+j) != s.charAt(j)){
				match = false;
				break;
			}
		}
		if(match == true){
			count++;
		}
	}
	return count;
}
System.out.println(count("abcabcabcabbbbbbc","abc"));
