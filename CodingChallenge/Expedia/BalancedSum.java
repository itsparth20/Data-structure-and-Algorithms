static int balancedSum(int[] sales) {

        int len = sales.length;

        int[] leftSum = new int[len];

        int[] rightSum = new int[len];

        Arrays.fill(leftSum, 0);

        Arrays.fill(rightSum, 0);

        for(int i = 1, j = len-2; i<len; i++, j--){

            leftSum[i] = leftSum[i-1] + sales[i-1];

            rightSum[j] = rightSum[j+1] + sales[j+1];

        }

        

        for(int i = 0; i < len; i++){

            if(leftSum[i] == rightSum[i]){

                return i;

            }

        }

        return -1;



    }