/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outco;

/**
 *
 * @author itspa
 */
public class SortedRotatedArraySearch {
    public static void main(String[] args){
        int a[] = {3,5,1};
        int target = 3;
        System.out.println(findElement(a,target));
    }

    private static int findElement(int[] a, int target) {
        int low = 0;
        int high = a.length-1;
        
        while(high>=low){
            int mid = (low+high)/2;
            if(a[mid] == target){
                return mid;
            }
            if(a[mid]<a[high]){
                if(target > a[mid] && target <= a[high]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
            else{
                if(target >= a[low] && target < a[mid]){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }
        }
        
        return -1;
    }
}
