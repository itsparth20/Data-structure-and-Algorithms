package hackerrank;

import java.util.HashSet;
import java.util.Scanner;
/*
 * John has discovered various rocks. Each rock is composed of various elements, and each element is represented by a lower-case Latin letter from 'a' to 'z'. An element can be present multiple times in a rock. An element is called a gem-element if it occurs at least once in each of the rocks.
 * 
 * Given the list of N rocks with their compositions, display the number of gem-elements that exist in those rocks.
 * 
 * Input Format
 * The first line consists of an integer, N , the number of rocks.
 * Each of the next  lines contains a rock's composition. Each composition consists of lower-case letters of English alphabet.
 * 
 * Output Format
 * Print the number of gem-elements that are common in these rocks. If there are none, print 0.
 * 
 * Sample Input
 * 3
 * abcdde
 * baccd
 * eeabg
 * 
 * Sample Output
 * 2
 * 
 * Explanation
 * Only "a" and "b" are the two kinds of gem-elements, since these are the only characters that occur in every rock's composition.
 */
public class Gemstones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int numberOfStone = sc.nextInt();
        if(numberOfStone == 1) {String elements = sc.next(); System.out.println("0"); }
        else{
            HashSet<Character> set = new HashSet<Character>();
            for(int i = 0; i<1; i++){
                String elements = sc.next();
                for(int j = 0; j <  elements.length(); j++)
                    set.add(elements.charAt(j));                
            }

            for(int i = 1; i<numberOfStone; i++){
                String elements = sc.next();
                HashSet<Character> set1 = new HashSet<Character>();
                for(int j = 0; j <  elements.length(); j++){
                    if(set.contains(elements.charAt(j)))
                        set1.add(elements.charAt(j));
                }
                set = (HashSet<Character>) set1.clone();
            }            
            System.out.println(set.size());
        }
	}

}
