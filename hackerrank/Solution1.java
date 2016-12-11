
import java.util.Arrays;
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
public class Solution1 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int backsideRow = ((n*(n-1))/2)+1;
        int rows = n ;
        if (n>1){
            rows = (n*(n+1))/2;
        }
        System.out.println(rows);
        int[][] values = new int[rows][];
        System.out.println(values.length);
        for(int i = 0; i < values.length; i++)
        {
            values[i] = new int[i+1];

            for(int j = 0; j < values[i].length; j++)
            {
                values[i][j] = sc.nextInt();
                
            }
            System.out.println(Arrays.deepToString(values));
        }
        
   }
}
