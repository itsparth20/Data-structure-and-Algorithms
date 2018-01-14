/*
91. Decode Ways
https://leetcode.com/problems/decode-ways/description/
*/
class Solution {
    public int numDecodings(String message) {
        
        int msgLen = message.length();
        if (msgLen < 2) return msgLen;
		int[] decodeCount = new int[msgLen + 1];
		
		decodeCount[0] =1;
		decodeCount[1] =1;
		
		
		for(int i=2; i< msgLen + 1; i++)
		{
			if(message.charAt(i - 1 ) > '0')
				decodeCount[i] = decodeCount[i-1];
			
			if((message.charAt(i - 2) < '2') || ( message.charAt(i - 2) == '2' &&  message.charAt(i - 1) < '7' ) )
				decodeCount[i] = decodeCount[i] + decodeCount[i-2];
		}
		
		return decodeCount[msgLen];
    }
}