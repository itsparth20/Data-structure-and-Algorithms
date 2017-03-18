/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telnyx;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author itspa
 */
public class PalindromicNumberBase {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		PalindromicNumberBase obj = new PalindromicNumberBase();
		try {
			int n = sc.nextInt();
			System.out.println(n + ", " + obj.numberBase(n));
		}
	    // if user enter some character
		catch (InputMismatchException e) {
			System.out.println("Please enter positive integer.");
		} catch (Exception e) {
			System.out.println("Please try again after some time");
		}finally {
			sc.close();
		}

	}

	public int numberBase(int number) {
		if(number<0){						
			return -1;			
		}
    	try{	        
	        for(int i = 2 ; i <= 1000; i++){    	        	              
	        	StringBuffer sb = new StringBuffer();
	        	int reminder = 0;	
	        	
	        	//create temp number to find base number
	        	int num = number;
	        	
	        	//This will create number with base i
	        	while(num >= i){
	        		reminder = num%i;
	        		num = num / i;
	        		sb.append(reminder);	        		
	        	}	        
	        	sb.append(num);
	        	
	        	boolean isPalindrom = checkPalindrome(sb.toString());
                                
                //if number is palindrome then return base value.
                if(isPalindrom){
                    return i;                        
                }                
            }                	        
    	}catch(Exception e){
    		System.out.println("Their is some problem. Please try again after some time");    		
    	}         
    	return -1;
    }

	//Palindrom function
	public boolean checkPalindrome(String num) {
		int i = 0;
		int j = num.length()-1;
		while(i<=j){
			if(num.charAt(i) == num.charAt(j)){
				i++;
				j--;
			}else{
				return false;
			}
		}
		return true;
	}
}
