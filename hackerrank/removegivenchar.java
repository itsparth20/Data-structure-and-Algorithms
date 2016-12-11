
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author itspa
 */
public class removegivenchar {
    public static void main(String arg[]){
        Scanner sc = new Scanner(System.in);
        
        int i = 0;
        String fullstring = sc.nextLine();
        char ch = sc.next().charAt(0);
        
        char[] chararray = fullstring.toCharArray();
        for(i =0; i<chararray.length; i++){
            if(ch == chararray[i])
                break;
        }
        
        System.out.print(fullstring.substring(0, i));
        System.out.println(fullstring.substring(++i));
        
    }
    
}
