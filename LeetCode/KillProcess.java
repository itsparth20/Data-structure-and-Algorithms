package practiceProblem.leetcode;

/*
 * 582. Kill Process
 * Given n processes, each process has a unique PID (process id) and its PPID (parent process id).

Each process only has one parent process, but may have one or more children processes. This is just like a tree structure. Only one process has PPID that is 0, which means this process has no parent process. All the PIDs will be distinct positive integers.

We use two list of integers to represent a list of processes, where the first list contains PID for each process and the second list contains the corresponding PPID.

Now given the two lists, and a PID representing a process you want to kill, return a list of PIDs of processes that will be killed in the end. You should assume that when a process is killed, all its children processes will be killed. No order is required for the final answer.

Example 1:
Input: 
pid =  [1, 3, 10, 5]
ppid = [3, 0, 5, 3]
kill = 5
Output: [5,10]
Explanation: 
           3
         /   \
        1     5
             /
            10
Kill 5 will also kill 10.

Note:
The given kill id is guaranteed to be one of the given PIDs.
n >= 1.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KillProcess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> pid = new ArrayList<Integer>(Arrays.asList(1, 3, 10, 5));
		ArrayList<Integer> ppid = new ArrayList<Integer>(Arrays.asList(3, 0, 5, 3));
				
		int kill = 3;
		KillProcess o = new KillProcess();
		o.killProcess(pid, ppid, kill).stream().forEach(System.out::println);

	}

	public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
		ArrayList<Integer> output = new ArrayList<Integer>();
		if (pid.size() == 0)
			return output;
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(kill);
		while(queue.size() > 0){
			int killed = queue.poll();
			while(ppid.indexOf(killed) != -1){
				int indexOfppid = ppid.indexOf(killed);
				ppid.set(indexOfppid, 0);
				queue.offer(pid.get(indexOfppid));
			}
			output.add(killed);
		}
		
		
		return output;
	}

}
