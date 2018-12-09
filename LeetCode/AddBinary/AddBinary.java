/*
67. Add Binary

https://leetcode.com/problems/add-binary/

Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"

*/

class Solution {
    
    public String addBinary(String a, String b) {
        a = a.trim();
        b = b.trim();

        int alen = a.length();
        int blen = b.length();
        if (alen < blen) return addBinary(b, a);
        char carry = '0';
        char aCh, bCh;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= alen; i++){
            aCh = '0';
            bCh = '0';
            if (i <= alen){
                aCh = a.charAt(alen-i);
            }
            if(i <= blen){
                bCh = b.charAt(blen-i);
            }
            List<Character> sumCarry = addTwoBinary(aCh, bCh);
            if (carry == '0'){

                sb.append(sumCarry.get(0));
                carry = sumCarry.get(1);

            }
            else{
                List<Character> sumCarry2 = addTwoBinary(sumCarry.get(0), carry);
                sb.append(sumCarry2.get(0));
                carry = sumCarry.get(1) == '1' ? '1' : sumCarry2.get(1);
            }

        }
        if(carry == '1') sb.append(carry);
        return sb.reverse().toString();
    }

    private List<Character> addTwoBinary(Character a, Character b){
        if(a == '1' && b == '1'){
            return Arrays.asList('0','1');
        }
        else if((a == '1' && b == '0') || (a == '0' && b == '1')) {
            return Arrays.asList('1','0');
        }
        else{
            return Arrays.asList('0','0');
        }
    }

}