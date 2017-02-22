/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursion2;

/**
 *
 * @author itspa
 */
public class LatticePaths {
    public static void main(String args[]){
        int matrixSize = 3;        
        System.out.println(compute(matrixSize));
        

    }
    
  public static int compute(int n) {
		return findTotalWay(n,0,1);
  }
  
  private static int findTotalWay(int matrixSize, int i, int ways) {
        if(i < matrixSize){
            ways *= (matrixSize*2) - i;
            ways /= (i+1);
            return findTotalWay(matrixSize, i+1, ways);
        }
        return ways;              
    }
}
