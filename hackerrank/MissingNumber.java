/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
Numeros, the Artist, had two lists  and , such that  was a permutation of . Numeros was very proud of these lists. Unfortunately, while transporting them from one exhibition to another, some numbers were left out of . Can you find the missing numbers?

Notes

If a number occurs multiple times in the lists, you must ensure that the frequency of that number in both lists is the same. If that is not the case, then it is also a missing number.
You have to print all the missing numbers in ascending order.
Print each missing number once, even if it is missing multiple times.
The difference between maximum and minimum number in  is less than or equal to .
Input Format

There will be four lines of input:

 - the size of the first list 
This is followed by  space-separated integers that make up the first list. 
 - the size of the second list 
This is followed by  space-separated integers that make up the second list.

Constraints

Output Format

Output the missing numbers in ascending order.

Sample Input

10
203 204 205 206 207 208 203 204 205 206
13
203 204 204 205 206 207 205 208 203 206 205 206 204
Sample Output

204 205 206
Explanation

 is present in both arrays. Its frequency in  is , while its frequency in  is . Similarly,  and  occur twice in , but thrice in . So, these three numbers are our output. The rest of the numbers have thesame frequency in both lists.
*/
package hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author itspa
 */
public class MissingNumber {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> a = new ArrayList<Integer>();
        for(int i=0; i<n; i++){
            a.add(sc.nextInt());
        }
        int n1 = sc.nextInt();
        List<Integer> b = new ArrayList<Integer>();
        for(int i=0; i<n1; i++){
            b.add(sc.nextInt());
        }
        List<Integer> copyB = new ArrayList<Integer>();
        copyB = b;
        for(int i=0;i<a.size();i++){
            boolean match = false;
            int temp = a.get(i);
            for(int j=0;j<b.size();j++){
                if(temp==b.get(j)){
//                    a.remove(i);
//                    b.remove(i);
                    copyB.remove(j);
                    match = true;
                    break;
                }
            }
            if(match == false){
                copyB.add(temp);
            }
        }
        
        Set<Integer> hs = new HashSet<>();
        hs.addAll(copyB);
        copyB.clear();
        copyB.addAll(hs);
        Collections.sort(copyB);
        System.out.println(copyB);
    }
}
