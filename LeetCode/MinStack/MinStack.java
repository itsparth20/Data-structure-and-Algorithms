/*
155. Min Stack
https://leetcode.com/problems/min-stack/description/
*/
class MinStack {

    /** initialize your data structure here. */
    
    private MinStack obj;
    private List<Integer> lst;
    private List<Integer> min;
    public MinStack() {
        min = new ArrayList<Integer>();
        lst = new ArrayList<Integer>();
    }
    
    public void push(int x) {
        if(lst.size() == 0){
            min.add(x);            
        }else{            
            min.add(Math.min(min.get(min.size()-1), x));
        }
        lst.add(x);
        
    }
    
    public void pop() {
        lst.remove(lst.size()-1);
        min.remove(min.size()-1);        
    }
    
    public int top() {        
        return lst.get(lst.size()-1);
    }
    
    public int getMin() {
        return min.get(min.size()-1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */