static int maxDifference(int[] a) {
        int max = -1;
        for(int i = 0; i < a.length-1; i++){
            for(int j = i+1; j < a.length; j++){
                if(a[i] < a[j]){
                    max = Math.max(max, Math.abs(a[i] - a[j]));
                }
            }
        }
        return max;
    }