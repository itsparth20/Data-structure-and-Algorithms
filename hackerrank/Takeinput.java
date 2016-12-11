
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
public class Takeinput {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = 3;
        int[][] values = new int[3][3];
        int temp = n;        
        for(int i=0; i<n; i++){
            
            for(int j = 0; j<temp; j++){
                values[i][j] = sc.nextInt();
            }
            temp--;
            System.out.println();
        }
        
        temp =n;
        System.out.println();
       for(int i=0; i<n; i++){
            
            for(int j = 0; j<temp; j++){
                System.out.print(values[i][j]);
            }
            temp--;
            System.out.println();
        }
    }
}
