/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackRock;

/**
 *
 * @author itspa
 */
public class PortFolioManager {
    
    public static void main(String[] args){
        String tree = "1 2 3 # # 4 # # 5";
        int n =5;
        System.out.println(findMax(n,tree));
    }    
    public static int count = 0;
    public static String[][] nodeNeighbour; 
    public static String[][] details; 
    static int findMax(int n, String tree) {
        String[] nodeArr = tree.split(" ");
        count = nodeArr.length;
        nodeNeighbour = new String[count][3];
        int blank = 0;
        for(int i = 0; i < count; i++){
            if(nodeArr[i].equals("#")){
                blank += 2;
                nodeNeighbour[i][2] = "#";
                continue;
            }                        
            nodeNeighbour[i][0] = String.valueOf(i*2+1-blank);
            nodeNeighbour[i][1] = String.valueOf(i*2+2-blank);
            nodeNeighbour[i][2] = nodeArr[i];
        }
        details = new String[count][2];  
        return Math.max(findMax1(0,0),findMax1(0,1));
    }

    public static int findMax1(int nodeNumber, int selected) {
        if(nodeNumber>=count){
            return 0;
        }
        if(nodeNeighbour[nodeNumber][2] == "#"){
            return 0;            
        }
        int leftNode = Integer.valueOf(nodeNeighbour[nodeNumber][0]);
        int rightNode = Integer.valueOf(nodeNeighbour[nodeNumber][1]);
        String nullValue = null;
        if(details[nodeNumber][selected] != null){
            return Integer.valueOf(details[nodeNumber][selected]);
        }
        if(selected == 1){
            details[nodeNumber][selected] = String.valueOf(
                                                            findMax1(leftNode,0) + 
                                                            findMax1(rightNode,0) +
                                                            Integer.valueOf(nodeNeighbour[nodeNumber][2])
                                                            );
            return Integer.valueOf(details[nodeNumber][selected]);
        }else{
            details[nodeNumber][selected] = String.valueOf(
                                                            Math.max(findMax1(leftNode,0), findMax1(leftNode,1)) +
                                                            Math.max(findMax1(rightNode,0), findMax1(rightNode,1))
                                                            );
            return Integer.valueOf(details[nodeNumber][selected]);
        }
    }
       
}
