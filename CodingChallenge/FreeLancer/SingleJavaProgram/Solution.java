
import java.util.Arrays;

public class Solution {
    public static long[][] m;
    public static void main(String[] args) {
        int[] p = {5, 10, 12, 5, 50, 6};
        m = new long[p.length][p.length];

        System.out.println(recursiveMatrixChain(p,1, 2));

    }


    private static long recursiveMatrixChain(int[] p, int i, int j) {
        if(i == j){
            return 0;
        }
        m[i][j] = Long.MAX_VALUE;
        for(int k = i; k<j-1; k++){
            long q = recursiveMatrixChain(p,i,k) + recursiveMatrixChain(p,k+1,j) + (p[i-1] * p[k] * p[j]);
            if (q < m[i][j]){
                    m[i][j] = q;
            }
        }
        return m[i][j];
    }
}
