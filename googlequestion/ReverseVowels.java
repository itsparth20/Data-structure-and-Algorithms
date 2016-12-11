/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package googlequestion;

import java.util.ArrayList;

/**
 *
 * @author itspa
 */
public class ReverseVowels {
    static String sentence = "earth";
    public static String reverseVowels(String s) {
        ArrayList<Character> vowList = new ArrayList<Character>();
        vowList.add('a');
        vowList.add('e');
        vowList.add('i');
        vowList.add('o');
        vowList.add('u');
        vowList.add('A');
        vowList.add('E');
        vowList.add('I');
        vowList.add('O');
        vowList.add('U');

        char[] arr = s.toCharArray();

        int i=0; 
        int j=s.length()-1;

        while(i<j){
            if(!vowList.contains(arr[i])){
                i++;
                continue;
            }

            if(!vowList.contains(arr[j])){
                j--;
                continue;
            }

            char t = arr[i];
            arr[i]=arr[j];
            arr[j]=t;

            i++;
            j--; 
        }

        return new String(arr);
    }
    public static void main(String[] args) {
        System.out.println(sentence);
        System.out.println(reverseVowels(sentence));
//        char[] letters = sentence.toCharArray();
//        int left = 0;
//        int right = letters.length - 1;
//        char temp;
//        boolean left_visit = false;
//        boolean right_visit = false;
//        for(int i=0; i<letters.length; i++) {
//            if(letters[left] == 'a' || 
//            letters[left] == 'e' || 
//            letters[left] == 'i' || 
//            letters[left] == 'o' || 
//            letters[left] == 'u') {
//                left_visit = true;
//            } else {
//                if(left_visit == false) {
//                left++;
//                } 
//            }
//
//            if(letters[right] == 'a' || 
//            letters[right] == 'e' || 
//            letters[right] == 'i' || 
//            letters[right] == 'o' || 
//            letters[right] == 'u') {
//                right_visit = true;
//            } 
//            else {
//                if(right_visit == false) {
//                right--;
//                }
//            }
//
//            if(left_visit == true && right_visit == true && left < right) {
//                temp = letters[right];
//                letters[right] = letters[left];
//                letters[left] = temp;
//                left++;
//                right--;
//                left_visit = false;
//                right_visit = false;
//            }
//        }
//
//        System.out.println(new String(letters));

    }
}
