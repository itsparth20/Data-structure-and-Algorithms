package googleCodeJam;
/*
 * You are given a scrambled input sentence. Each word is scrambled independently, and the results are concatenated. So
 * 
 * 'hello to the world'
 * might become: 
 * 'ehllotehotwolrd'
 * 
 * You have a dictionary with all words in it. Unscramble the sentence.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UnscrambleTheSentence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> dic= new HashSet<String>(Arrays.asList("hello","to","the","world"));
		String s = "ehllotehotwolrd";
		
		System.out.println(unScramle(dic,s));
	}
	
	private static List<String> unScramle(Set<String> dic, String s){
		List<String> list = new ArrayList<String>();
		if(s.length() == 0) return list;
		Map<String, LinkedList<String>> map = new HashMap<String, LinkedList<String>>();
		int max = 0;
		for(String str : dic){
			max = Math.max(max, str.length());
			char[] arr = str.toCharArray();
			Arrays.sort(arr);
			map.putIfAbsent(String.valueOf(arr), new LinkedList<String>());
			map.get(String.valueOf(arr)).offer(str);		
		}
		
		
		for(int i = 0; i < s.length()-1; i++){
			for(int j = i+1; j <= s.length() && j <= i+max; j++){
				char[] temp = s.substring(i, j).toCharArray();
				Arrays.sort(temp);
				if(map.containsKey(String.valueOf(temp))) {
					list.add(map.get(String.valueOf(temp)).poll());
					i = j-1;
					break;
				}
			}
		}				
		return list;
	}

}
