/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package googlequestion;

import static java.lang.Math.random;
import java.util.Random;

/**
 *
 * @author itspa
 * 
 * Random generate a NxN matrix with only four types of element: 1,2,3,4. 
However, no column or row can have same type of element appears 3 times or above continuously (three same type of elements are connected) 

ex: 

valid: 
1 2 1 1 
3 1 4 2 
1 2 4 2 
3 1 2 3 

invalid because the first column has element 1 appears three times and all 1s are connected to each other : 

1 2 1 3 
1 3 4 2 
1 2 4 4 
2 3 2 2
 */
public class GenerateMatrixWithNoSameTypeofElement {
    public static void main(String[] args){
        int a[][] = generateMatrix(4);
      
        for(int i = 0; i<4; i++ ){
            for(int j =0; j<4; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
       // System.out.println(validMatrix(a));
    }
    
    private static int[][] generateMatrix(int p) {
        int a[][] = new int[p][p];
        int i=0,j;
        while(i<p){
            j=0;
            while(j<p){
                Random rand = new Random();
                boolean lop = true;
                int x = rand.nextInt(p);
                while(lop && (j >=2 || i >=2)){
                    if(j>=2){
                        if(x == a[i][j-1] && x == a[i][j-2]){
                            x = rand.nextInt(p);
                            lop = true;
                        }
                        else
                            lop = false;
                    }
                    if(i>=2){
                        if(x == a[i-1][j] && x == a[i-2][j]){
                            x = rand.nextInt(p);
                            lop = true;
                        }
                        else{
                            lop = false;
                        }
                    }
                    
                }
                a[i][j] = x;
                j++;
            }
            i++;
        }
        
        return a;
    }

//    private static boolean validMatrix(int[][] a) {
//        int row = a.length;
//        int col = row;
//        int i=0,j = row-1;
//        while(i<row){
//            j = row-1;
//            while(j>=0){
//                if(j >= 2){
//                    if(a[i][j] == 1 && a[i][j-1] == 1 && a[i][j-2] == 1){
//                        return false;
//                    }
//                    if(a[i][j] == 2 && a[i][j-1] == 2 && a[i][j-2] == 2){
//                        return false;
//                    }
//                    if(a[i][j] == 3 && a[i][j-1] == 3 && a[i][j-2] == 3){
//                        return false;
//                    }
//                    if(a[i][j] == 4 && a[i][j-1] == 4 && a[i][j-2] == 4){
//                        return false;
//                    }
//                    if(a[i][j] == 4 && a[i][j-1] == 4 && a[i][j-2] == 4){
//                        return false;
//                    }
//                }
//                if(i >= 2){
//                    if(a[i][j] == 1 && a[i-1][j] == 1 && a[i-2][j] == 1){
//                        return false;
//                    }
//                    if(a[i][j] == 2 && a[i-1][j] == 2 && a[i-2][j] == 2){
//                        return false;
//                    }
//                    if(a[i][j] == 3 && a[i-1][j] == 3 && a[i-2][j] == 3){
//                        return false;
//                    }
//                    if(a[i][j] == 4 && a[i-1][j] == 4 && a[i-2][j] == 4){
//                        return false;
//                    }
//                    if(a[i][j] == 4 && a[i-1][j] == 4 && a[i-2][j] == 4){
//                        return false;
//                    }
//                }
//                j--;
//            }
//            i++;
//        }
//        
//        return true;
//    }

    
}
