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

	public int numberBase(int n) {
		if(n<0){						
			return -1;			
		}
    	try{	        
	        for(int i = 2 ; i <= 1000; i++){    
	        	//Convert int to base
                String NumberInBase = Integer.toString(n, i);
                //reverse number
                String NumberInBaseReverse = new StringBuffer(NumberInBase).reverse().toString();
                //if both string is palindrom then return base
                if(NumberInBase.equals(NumberInBaseReverse)){
                    return i;                        
                }
            }                	        
    	}catch(Exception e){
    		System.out.println("Their is some problem. Please try again after some time");    		
    	}         
    	return -1;
    }
}
