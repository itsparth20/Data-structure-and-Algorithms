/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlindData;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author itspa
 */
public class Question3 {
    public static void main(String[] args){
        Queue<String> readyQue = new LinkedList<String>();
        HashMap<String, String> processOne = new HashMap<String, String>();
        HashMap<String, String> processTwo = new HashMap<String, String>();
        HashMap<String, String> processThree = new HashMap<String, String>();
        
        processTwo.put("printer", "install driver");
        processTwo.put("display", "change resolution");
        
        processThree.put("system", "restore");
        processThree.put("display", "shutdown");
        
        readyQue.add(processTwo.get("printer"));
        readyQue.add(processThree.get("display"));
        readyQue.add(processTwo.get("display"));
        readyQue.remove();
        readyQue.add(processThree.get("system"));
        
        while(!readyQue.isEmpty()){
            System.out.println(readyQue.remove());
            
        }
    }
}
