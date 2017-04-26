/*
 *  3. Given an array of binary values (0 and 1) and N number of flips (convert 
 *     a 0 to a 1), determine the maximum number of consecutive 1's that can be 
 *     made.
 *
 *  Input: An Array of 1's and 0's, and an Integer N denoting the number of 
 *         flips
 *  Output: Integer
 *
 *  Example: bitFlip([0,1,1,1,0,1,0,1,0,0], 2)
 *  Example: bitFlip([0,0,0code,1], 2)
 *  Result: 7
 */

class myCode
{
    public static void main (String[] args) throws java.lang.Exception
    {
        System.out.println("Hello Java");
        int[] arr = {0,0,0};
        int k = 2;
        System.out.println(maxNumConsecutiveOnesWithFlips(arr,k));
    }
    
    private static int maxNumConsecutiveOnesWithFlips(int[] arr, int n){
        int max = 0, streak = 0, start = 0;
        
        for(int i = 0; i< arr.length; i++){
            if(arr[i] == 0){
                if(n > 0){
                    n--;
                }else{
                    int sub = 1;
                    while(arr[start] == 1){
                        sub++;
                        start++;
                    }
                    
                    start++;
                    streak -= sub;
                }
            }
            streak++;
            max = Math.max(streak, max);            
        }
        
        return max;
        
    }
}
