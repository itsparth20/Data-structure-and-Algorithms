package hackerrank;

import java.util.HashSet;
import java.util.Scanner;
/*
 * Program: Is Fibo
 * You are given an integer, . Write a program to determine if  is an element of the Fibonacci sequence.

The first few elements of the Fibonacci sequence are . A Fibonacci sequence is one where every element is a sum of the previous two elements in the sequence. The first two elements are  and .

Formally: 
Input Format 
The first line contains , number of test cases. 
 lines follow. Each line contains an integer .

Output Format 
Display IsFibo if  is a Fibonacci number and IsNotFibo if it is not. The output for each test case should be displayed in a new line.

Constraints 
 

Sample Input

3
5
7
8
Sample Output

IsFibo
IsNotFibo
IsFibo

More Details: https://www.hackerrank.com/challenges/is-fibo?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
 */
public class IsFibo {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner sc = new Scanner(System.in);
        int tries = sc.nextInt();
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(0); set.add(1); set.add(2);
        int x = 1, y = 2, q = 2;        
        for(int i = 0; i < tries; i++){
            int fib = sc.nextInt();
            if(set.contains(fib)){
                System.out.println("IsFibo");
                continue;
            }else{
                
                for(int j = q; j < fib; j++){
                	q = j;
                    int temp = x+y;
                    x=y;
                    y=temp;
                    set.add(y);
                    if(y == fib){
                        System.out.println("IsFibo");
                        break;
                    }
                    if(y > fib){
                        System.out.println("IsNotFib");
                        break;
                    }
                }
            }
        }
    }
}