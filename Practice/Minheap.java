/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MinHeap;

import java.util.ArrayList;

/**
 *
 * @author itspa
 */
public class Minheap {
    public static ArrayList<Integer> storage;
    public static void main(String[] args){
        storage = new ArrayList<Integer>();
        storage.add(4);
        storage.add(7);
        storage.add(5);
        storage.add(9);
        storage.add(10);
        storage.add(6);
        storage.add(8);
        
        System.out.println(storage);
        removePeek();
        System.out.println(storage);
//        System.out.println(peek());
//        System.out.println(size());
        
        
    }
    
    public static void swap(int index1, int index2){
        int temp = storage.get(index1);        
        storage.set(index1, storage.get(index2));
        storage.set(index2, temp);
        
    }
    
    public static int peek(){
    
        return storage.get(0);
    }
    
    public static int size(){
    
        return storage.size();
    }
    
    public static void insert(int val){
        storage.add(val);
        bubbleUp(storage.size()-1);        
    }
    
    public static void bubbleUp(int childindex){
        int parentindex;
        if(childindex % 2 == 0){
            parentindex = (childindex-2)/2;          
        }else{
            parentindex = (childindex-1)/2;
        }        
        
        while( (childindex > 0) && (storage.get(childindex) < storage.get(parentindex)) ){
            swap(childindex, parentindex);
            childindex = parentindex;
            
            if(childindex % 2 == 0){
            parentindex = (childindex-2)/2;          
            }else{
                parentindex = (childindex-1)/2;
            }
        }
    }
    
    public static int removePeek(){
        swap(0, storage.size()-1);
        int minValue = storage.remove(storage.size()-1);
        bubbleDown(0);
        return minValue;
    }
    
    public static void bubbleDown(int parentIndex){
        int childIndex1 = parentIndex*2+1;
        int childIndex2 = parentIndex*2+2;
        
        int mci;
        if(childIndex1>size()){
            return;
        }else if(childIndex2>storage.size()-1){
            return;
        }else if(storage.get(childIndex1) < storage.get(childIndex2)){
            mci = storage.get(childIndex1);
        }else{
            mci = storage.get(childIndex2);
        }
        
        while(parentIndex < size()-1 && storage.get(parentIndex) > storage.get(mci)){
            swap(parentIndex, mci);
            
            parentIndex=mci;
            childIndex1 = parentIndex*2+1;
            childIndex2 = 2 * parentIndex + 2;
            
            if(childIndex1>storage.size()-1){
                return;
            }else if(childIndex2>storage.size()-1){
                return;
            }else if(storage.get(childIndex1) < storage.get(childIndex2)){
                mci = storage.get(childIndex1);
            }else{
                mci = storage.get(childIndex2);
            }
        }
        
    }
    
    public static void remove(int val){
    
    }
}

