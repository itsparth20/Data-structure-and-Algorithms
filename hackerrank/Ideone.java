import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int one = 1, two = 2, arrayCount =0, sum =0, evenSum =0;
		int MaxNum = 4000000;
                String em = "";
		//int sumThree =0, sumFive = 0;
		int[] data1 = new int[1000];
                
                
                Scanner sc = new Scanner(System.in);
                String inputdata = sc.nextLine();
                char[] ch = inputdata.toCharArray();
                char[] ch1 = new char[ch.length];
                int match =0;
                
                for(int i=0; i<ch.length; i++){
                    //System.out.println("Outside "+ch[i]);
                    for(int j =0; j<arrayCount; j++){
                        
                        if(ch[i] == ch1[j]){
                        
                            match++;}

                    }
                    
                    if(match==0){
                    ch1[arrayCount] = ch[i];
                    arrayCount++;
                    }
                    match=0;
                }
                System.out.println(ch1);
	}
}