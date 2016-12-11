/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author itspa
 */
public class BinaryTree {

    Node root;

    public void addNode(int key, String name) {

        Node newNode = new Node(key, name);
        if (root == null) {
            root = newNode;

        } else {
            Node focusNode = root;
            Node parent;
            while (true) {
                parent = focusNode;
                if (key < focusNode.key) {
                    focusNode = focusNode.leftchild;

                    if (focusNode == null) {
                        parent.leftchild = newNode;
                        return;
                    }
                } else {
                    focusNode = focusNode.rightchild;

                    if (focusNode == null) {
                        parent.rightchild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void inOrderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            inOrderTraverseTree(focusNode.leftchild);
            System.out.println(focusNode);
            inOrderTraverseTree(focusNode.rightchild);
        }
    }

    public void preOrderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            System.out.println(focusNode);
            preOrderTraverseTree(focusNode.leftchild);
            preOrderTraverseTree(focusNode.rightchild);
        }
    }

    public Node findNode(int key) {
        Node focuNode = root;
        while (focuNode.key != key) {
            if (key < focuNode.key) {
                focuNode = focuNode.leftchild;
            } else {
                focuNode = focuNode.rightchild;
            }
            if (focuNode == null) {
                return null;
            }
        }
        return focuNode;
    }

    public static void main(String[] args) {
        BinaryTree theTree = new BinaryTree();

        theTree.addNode(50, "Boss");
        theTree.addNode(25, "Vice Manager");
        theTree.addNode(15, "Office Manager");
        theTree.addNode(30, "Secretory");
        theTree.addNode(75, "Sales Manager");
        theTree.addNode(85, "Salesman 1");

        //  theTree.preOrderTraverseTree(theTree.root);
        System.out.println(theTree.findNode(30));
    }
}

class Node {

    int key;
    String name;

    Node leftchild;
    Node rightchild;

    Node(int key, String name) {
        this.key = key;
        this.name = name;

    }

    public String toString() {
        return name + " has a key " + key;
    }
}
