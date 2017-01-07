/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlindData;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author itspa
 */
public class Question2 {
    public static void main(String[] args){
        LinkedList<Integer> listint = new LinkedList<Integer>();
        
        listint.add(3);
        listint.add(10);
        listint.add(17);
        listint.add(91);
        listint.add(6);
        listint.add(1);
        
        ListIterator<Integer> it = listint.listIterator(listint.size());
        
        while(it.hasPrevious()){
            System.out.println(it.previous());
        }
    }
}
