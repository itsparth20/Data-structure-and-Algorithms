
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author parth
 */
public class TakeinputAsWombats {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int rows = (n*(n+1))/2;
        int[][] values = new int[rows][12];
        
        int sum0 =0;
        int sum1 = 0;
        int sum2 =0;
        int counttemp = 1;
        int temp = 1;                            

        for(int i=0; i<rows; i++){
            //System.out.println("  "+i);
            for(int j = 0; j<temp; j++){
                values[i][j] = sc.nextInt();
               // System.out.print("  "+i+" "+j+"  ");
            }
            temp--;
            if(temp ==0){
                counttemp++;
                temp = counttemp;
            }
            //System.out.println();
        }
        
        //counting for one side
        counttemp = 1;
        temp = 1; 
        for(int i=0; i<rows; i++){
            //System.out.println("  "+i);
            for(int j = 0; j<temp; j++){
                //values[i][j] = sc.nextInt();
               // System.out.print("  "+i+" "+j+"  ");
               if(temp == counttemp){
                   sum0+=values[i][j];
                   
               }
            }                        
            temp--;
            //System.out.println("Temp: "+temp);
            sum1+=values[i][temp];
            if(temp ==0){
                counttemp++;
                temp = counttemp;                
            }
            //System.out.println();
        }

        //sum of another side
        for(int i=0;i<rows;i++){
           sum2+=values[i][0];
           //System.out.println("Sum0 = "+values[i][0]);
        }
        //System.out.println(sum0+" "+sum1+" "+sum2);
        
        if(sum0 > sum1 && sum0 > sum2){
            System.out.print(sum0);
        }
        else if(sum1 > sum0 && sum1 > sum2){
            System.out.print(sum1);
        }
        else{
            System.out.print(sum2);
        }
            /*
        temp =1;
        counttemp=1;
        System.out.println();
       for(int i=0; i<rows; i++){
            
            for(int j = 0; j<temp; j++){
                System.out.print(values[i][j]);
            }
            temp--;
            if(temp ==0){
                    counttemp++;
                    temp = counttemp;
                }
            System.out.println();
        }
            */
    }
}
