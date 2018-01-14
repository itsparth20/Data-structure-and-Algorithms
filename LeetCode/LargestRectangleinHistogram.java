/*
84. Largest Rectangle in Histogram
https://leetcode.com/problems/largest-rectangle-in-histogram/description/
*/
class Solution {
    public int largestRectangleArea(int[] heights) {
        int rectangle = 0;
        for(int i = 0; i < heights.length; i++){
            int min = heights[i];
            for(int j = i; j < heights.length; j++){
                if(heights[j] < min) min = heights[j];
                int cal = min * (j+1-i);
                if (rectangle < cal) rectangle = cal;
            }
        }        
        return rectangle;
    }
}

/*
Better solution with O(n) time and space complexity.
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int recArea = 0;
        int i = 0;
        for(i = 0; i < heights.length;){
            if(stack.empty() || heights[stack.peek()] <= heights[i]){
                stack.push(i++);
            }else{
                int pop = stack.pop();
                int area = 0;
                
                if(stack.empty()){
                    area = heights[pop] * i;
                }else{
                    area = heights[pop] * (i-stack.peek()-1);
                }
                if(area > recArea){
                    recArea = area;
                }
            }
        }
        while(!stack.empty()){
            int pop = stack.pop();
            int area = 0;

            if(stack.empty()){
                area = heights[pop] * i;
            }else{
                area = heights[pop] * (i-stack.peek()-1);
            }
            if(area > recArea){
                recArea = area;
            }
        }
        return recArea;
    }
}
*/