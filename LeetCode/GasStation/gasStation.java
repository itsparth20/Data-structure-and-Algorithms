/*
134. Gas Station
https://leetcode.com/problems/gas-station/description/
*/
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i = 0; i < gas.length; i++){
            int gs = 0;
            int count = 0;
            for(int j = i; j < gas.length + i; j++){
                gs += gas[j%gas.length];
                if(cost[j%gas.length] > gs)
                    break;
                gs -= cost[j%gas.length];                
                count++;
                if(count == gas.length){
                    return i;
                }
            }                   
        }
        return -1;
    }
	
	/*
		int start = 0, tank = 0, temp = 0;
        for(int i = 0; i<gas.length; i++){
            tank += gas[i]-cost[i];
            if(tank < 0){
                start = i+1;
                temp += tank;
                tank = 0;
            }
        }
        
        return tank+temp >= 0 ? start : -1;
	*/
}