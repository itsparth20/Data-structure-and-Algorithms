
public void reverse(String s){
    char[] arr = s.toCharArray();
    int left = 0;
    int right = s.length()-1;
    
    while(left <= right){
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = arr[left];        
        left++;
        right--;        
    }
    
    System.out.println(Arrays.toString(temp));
    
}