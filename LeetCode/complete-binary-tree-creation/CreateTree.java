package com.helper.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class CreateTree<T> {

    /*
     * [0,1,2,3,4,5,6]
     * child left = 2n+1
     * child right = 2n+2
     * odd number parent = n-1/2
     * even number parent = n-2/2
     */

    public <T> TreeNode createTree(List<TreeNode<T>> nodeValues) {
        int n = 0;
        int length = nodeValues.size();
        for (TreeNode<T> node : nodeValues) {
            if (node != null) {
                node.setLeft(2 * n + 1 >= length ? null : nodeValues.get(2 * n + 1));
                node.setRight(2 * n + 2 >= length ? null : nodeValues.get(2 * n + 2));
            }
            n++;
        }
        return nodeValues.get(0);
    }

    public static void main(String[] args) {

        TreeNode<Integer> zero = new TreeNode(0);
        TreeNode<Integer> one = new TreeNode(1);

        ArrayList<TreeNode<Integer>> list = new ArrayList<>();
        list.add(zero);
        list.add(one);
        int[] arr = new int[]{3, 1, 4, Integer.MIN_VALUE, 2,};
        CreateTree<Integer> tree = new CreateTree();

        TreeNode<Integer> root = tree.createTree(list);

    }


    @Test
    public void testRootArray() {
        TreeNode<Integer> zero = new TreeNode(3);
        TreeNode<Integer> one = new TreeNode(1);
        TreeNode<Integer> two = new TreeNode(4);
        TreeNode<Integer> three = new TreeNode(5);
        TreeNode<Integer> four = new TreeNode(2);
        List<TreeNode<Integer>> list = List.of(zero, one, two, three, four);
        CreateTree<Integer> tree = new CreateTree();
        TreeNode<Integer> root = tree.createTree(list);
        assertEquals(zero, root);
        assertEquals(one, root.getLeft());
        assertEquals(two, root.getRight());
        assertEquals(three, root.getLeft().getLeft());
        assertEquals(four, root.getLeft().getRight());
    }

}