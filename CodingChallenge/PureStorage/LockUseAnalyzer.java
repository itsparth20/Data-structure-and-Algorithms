package pureStorage;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LockUseAnalyzer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	

	public int check_log_history(String[] events){		
		Set<String> set = new HashSet<String>();
        Stack<String> stack = new Stack<String>();
        
        for(int i = 0; i < events.length; i++){
            String[] locks = events[i].split(" ");
            
            if(locks[0].equals("ACQUIRE")){
                if(set.add(locks[1]))
                    stack.push(locks[1]);
                else
                    return i+1;
            }
            else{
                if(stack.pop().equals(locks[1]))
                    set.remove(locks[1]);
                else
                    return i+1;
            }            
        }
        if(stack.size() == 0)
            return 0;
        return events.length+1;
		
	}
}
