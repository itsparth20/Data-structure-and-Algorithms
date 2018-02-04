package main.java.practice.revision;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LongestPalindrom {

	public static void main(String[] args) {
		String s = "mydadlikestodriveracecars";				
		LongestPalindrom obj = new LongestPalindrom();
		System.out.print(obj.getLongestPalindrom(s));
	}
	
	public String getLongestPalindrom(String s) {
		String longest = "";		
		for(int i = 0; i < s.length(); i++) {			
			longest = Collections.max(List.of(i < s.length()-1 ? getEvenPalindrom(s, i, i+1) : "",getOddPalindrom(s, i), longest), Comparator.comparing(x -> x.length()));
		}		
		return longest;
	}

	private String getEvenPalindrom(String s, int i, int j) {
		String even = "";
		even = getPalindrom(s, i, j, even);
		return even;
	}

	private String getOddPalindrom(String s, int i) {
		String odd = String.valueOf(s.charAt(i));
		odd = getPalindrom(s, i-1, i+1, odd);
		return odd;
	}
	
	private String getPalindrom(String s, int i, int j, String palindrom) {
		for(int l = i, r = j; l>=0 && r < s.length(); l--, r++) {
			if(s.charAt(l) == s.charAt(r)) 
				palindrom = s.substring(l,r+1);
			else
				break;
		}
		return palindrom;
	}
}
