/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Navisens;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author itspa
 */
public class ListsNodesAtSameDepth {
    private static Map<Integer,ArrayList<Integer>> lists;
    
    public static void main(String[] args){
        lists = new HashMap<Integer, ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        Node root = new Node(1);
        root.leftChild = new Node(2);
        root.rightChild = new Node(3);
        root.leftChild.leftChild = new Node(4);
        root.leftChild.rightChild = new Node(5);
        root.rightChild.leftChild = new Node(8);
        
        listNode(root, 0, list);
        System.out.println(lists);
    }

    private static void listNode(Node root, int depth, ArrayList<Integer> list) {
        if(root == null){
            return;
        }
        list.add(root.value);        
        lists.put(depth, list);
        
        if(lists.containsKey(depth+1)){
            listNode(root.leftChild, depth+1, lists.get(depth+1));
            
        }else{
            listNode(root.leftChild, depth+1, new ArrayList<Integer>());
        }        
        if(lists.containsKey(depth+1)){
            listNode(root.rightChild, depth+1, lists.get(depth+1));            
        }else{
            listNode(root.rightChild, depth+1, new ArrayList<Integer>());
        }                
    }
}
