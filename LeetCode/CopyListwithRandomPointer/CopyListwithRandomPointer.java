/**
 * 138. Copy List with Random Pointer
 * https://leetcode.com/problems/copy-list-with-random-pointer/description/
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {        
        Map<Integer, RandomListNode> map = new HashMap<>();
        RandomListNode temp = null;
        RandomListNode tempHead = null;
        RandomListNode mainHead = head;
        
        while(head != null){
              
            RandomListNode next = new RandomListNode(head.label);
            if(temp == null){
                temp = next;
                tempHead = next;                  
            }else{
                temp.next = next;
                temp = temp.next;
            }            
            map.put(next.label, next);            
            head = head.next;
            
        }
        
        RandomListNode h = tempHead;
        while(mainHead != null){            
            if(mainHead.random != null){
                h.random = map.get(mainHead.random.label);
            }
            mainHead = mainHead.next;
            h = h.next;             
        }
        return tempHead;
    }
}