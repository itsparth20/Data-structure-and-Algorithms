/*
236. Lowest Common Ancestor of a Binary Tree
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Given the following binary search tree:  root = [3,5,1,6,2,0,8,null,null,7,4]

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of of nodes 5 and 1 is 3.
Example 2:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself
             according to the LCA definition.
*/
import com.helper.tree.TreeNode;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> nodesFromRootToPNode = new ArrayList<TreeNode>();
        List<TreeNode> nodesFromRootToQNode = new ArrayList<TreeNode>();
        boolean valuesFromRootToPNodeExist = getAllMiddleValuesFromRootToNode(root, p, nodesFromRootToPNode);
        boolean valuesFromRootToQNodeExist = getAllMiddleValuesFromRootToNode(root, q, nodesFromRootToQNode);
        if(!valuesFromRootToPNodeExist || !valuesFromRootToQNodeExist){
            return null;
        }
        int smallSize = Math.min(nodesFromRootToPNode.size(), nodesFromRootToQNode.size());
        int i = 0;
        for(i =0; i < smallSize; i++){
            if(nodesFromRootToPNode.get(i) != nodesFromRootToQNode.get(i)){
                return nodesFromRootToQNode.get(i-1);
            }
        }
        return nodesFromRootToQNode.get(i-1);
    }

    public boolean getAllMiddleValuesFromRootToNode(TreeNode node, TreeNode expected, List<TreeNode> values){
        if(node == null){
            return false;
        }
        else if(node == expected){
            values.add(node);
            return true;
        }else{
            values.add(node);
            if(getAllMiddleValuesFromRootToNode(node.getLeft(), expected, values) ||
                    getAllMiddleValuesFromRootToNode(node.getRight(), expected, values)){
                return true;
            }
            values.remove(values.size()-1);
            return false;
        }
    }

    LowestCommonAncestor obj = null;

    @Before
    public void setUp() {
        obj = new LowestCommonAncestor();
    }
    @Test
    public void simpleTest() {
        TreeNode<Integer> root = new TreeNode(3);
        TreeNode<Integer> rootL = new TreeNode(5);
        TreeNode<Integer> rootR = new TreeNode(1);
        TreeNode<Integer> rootLL = new TreeNode(6);
        TreeNode<Integer> rootLR = new TreeNode(2);
        TreeNode<Integer> rootLRL = new TreeNode(7);
        TreeNode<Integer> rootLRR = new TreeNode(4);
        TreeNode<Integer> rootRL = new TreeNode(0);
        TreeNode<Integer> rootRR = new TreeNode(8);
        root.setLeft(rootL);
        root.setRight(rootR);
        rootL.setLeft(rootLL);
        rootL.setRight(rootLR);
        rootLR.setLeft(rootLRL);
        rootLR.setRight(rootLRR);
        rootR.setLeft(rootRL);
        rootR.setRight(rootRR);
        assertEquals(3, obj.lowestCommonAncestor(root, rootL, rootR).getValue());
    }


    @Test
    public void testTwoValue() {
        TreeNode<Integer> root = new TreeNode(1);
        TreeNode<Integer> rootL = new TreeNode(2);
        root.setLeft(rootL);
        assertEquals(1, obj.lowestCommonAncestor(root, rootL, root).getValue());
    }
}
