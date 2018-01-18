/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
/*
116. Populating Next Right Pointers in Each Node
https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/
/*
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        TreeLinkNode node = root;
        TreeLinkNode curr = null;
        while(node.left != null){
            curr = node;
            while(curr != null){
                curr.left.next = curr.right;
                if(curr.next != null) curr.right.next = curr.next.left;
                curr = curr.next;
            }
            node = node.left;
        }
        
    }
}