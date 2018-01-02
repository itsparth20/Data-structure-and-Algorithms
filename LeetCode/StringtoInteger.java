class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        if(str == null || str.equals("")) return 0;
        return valid(str);
    }
    
    public int valid(String str){
        if (str.length() == 1) {
            return (str.charAt(0) == '+' || str.charAt(0) == '-') ? 0 : isValid(str).intValue();
        }
        else if(str.charAt(0) == '-'){
            if(str.charAt(1) < '0' || str.charAt(1) > '9') return 0;
            Long x = isValid(str.substring(1));
            return x > Integer.MAX_VALUE ? Integer.MIN_VALUE : -(x.intValue());
        }
        else if(str.charAt(0) == '+'){
            if(str.charAt(1) < '0' || str.charAt(1) > '9') return 0;
            Long x = isValid(str.substring(1));
            return x > Integer.MAX_VALUE ? Integer.MAX_VALUE : x.intValue(); 
        }
        else if(str.charAt(0) < '0' || str.charAt(0) > '9') return 0;
        else {
            Long x = isValid(str);
            return x > Integer.MAX_VALUE ? Integer.MAX_VALUE : x.intValue(); 
        }
    }
    
    public Long isValid(String str){
        char[] arr = str.toCharArray();
        Long number = new Long(0);
        int mul = 1;
        for(int i = 0; i < arr.length; i++){    
            if(arr[i] < '0' || arr[i] >'9' || i > 10){                
                return number;
            }
            number *= mul;
            mul = 10;
            number += Integer.valueOf(Character.getNumericValue(arr[i]));
            
        }
        return number;
    }
}