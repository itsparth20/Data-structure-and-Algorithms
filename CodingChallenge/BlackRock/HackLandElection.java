/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackRock;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author itspa
 */
class HackLandElection {
    public static void main(String[] args){
        String[] votes = {
                            "Alex",
                            "Michael",
                            "Harry",
                            "Dave",
                            "Michael",
                            "Victor",
                            "Harry",
                            "Alex",
                            "Mary",
                            "Mary"
                         };
//        String[] votes = {
//                            "Victor",
//                            "Veronica",
//                            "Ryan",
//                            "Dave",
//                            "Maria",
//                            "Maria",
//                            "Farah",
//                            "Farah",
//                            "Ryan",
//                            "Veronica"        
//                         };
        System.out.println(electionWinner(votes));
    }

    private static String electionWinner(String[] votes) {
        Map<String, Integer> dictionary = new HashMap<String, Integer>();
        int max = 0;
        String winner = "";
        for(String i : votes){
            if(dictionary.containsKey(i)){
                dictionary.put(i, dictionary.get(i)+1);
                if(dictionary.get(i) > max){
                    max = dictionary.get(i);                   
                }
            }else{
                dictionary.put(i,1);
            }            
        }
        for(String i : votes){
            if(max == dictionary.get(i) && 0 > winner.compareTo(i)){
                winner = i;                
            }            
        }
        
        return winner;

    }

}
