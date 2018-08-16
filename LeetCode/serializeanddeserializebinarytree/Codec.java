package com.leetcode.serializeanddeserializebinarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
297. Serialize and Deserialize Binary Tree

https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/

Serialization is the process of converting a data structure or object into a sequence of
bits so that it can be stored in a file or memory buffer, or transmitted across a network
connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction
on how your serialization/deserialization algorithm should work. You just need to ensure
that a binary tree can be serialized to a string and this string can be deserialized
to the original tree structure.

Example:

You may serialize the following tree:

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]"
 */

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        List<String> list = new ArrayList<>();
        populateList(list, root);
        return list.toString();
    }

    private void populateList(List<String> list, TreeNode node) {
        if (node == null) {
            return;
        }
        list.add(node.val + "");

        if (node.left == null) {
            list.add("N");
        } else {
            populateList(list, node.left);
        }

        if (node.right == null) {
            list.add("N");
        } else {
            populateList(list, node.right);
        }
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }
        List<String> lst = Arrays.asList(data.replace("[","").replace("]","").split(","));
        return deserializeList(new ArrayList<String>(lst));
    }

    private TreeNode deserializeList(List<String> lst) {
        String val = lst.remove(0);
        if (val.contains("N")) {
            return null;
        }else{
            TreeNode node = new TreeNode(Integer.valueOf(val.trim()));
            node.left = deserializeList(lst);
            node.right = deserializeList(lst);
            return node;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));