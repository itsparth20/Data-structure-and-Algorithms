/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package googlequestion.FooBar;

import java.util.HashMap;

/**
 *
 * @author itspa
 */
class Answer {
    private static HashMap<Answer, Integer> dictionary;
    public int height;
    public int bricks;
    
    public static void main(String[] args) {
        dictionary = new HashMap<>();
        int brick = 200;                
        System.out.println(answer(brick));        
    }
    
    public static int answer(int n) { 

        // Your code goes here.
        dictionary = new HashMap<>();
        Answer level = new Answer(1, n);
        return level.NoOfways() - 1;
    }

    public Answer(int h, int b) {
        height = h;
        bricks = b;
    }

    public int NoOfways() {
        if (dictionary.containsKey(this)) 
            return dictionary.get(this);
        
        int totalWays;
        if (bricks == 0) 
            totalWays = 1;
        else if (bricks < height) 
            totalWays = 0;
        else {
            Answer IncreaseHeight = new Answer(height + 1, bricks);
            Answer decreaseBricksIncreaseHeight = new Answer(height + 1, bricks - height);            
            totalWays = IncreaseHeight.NoOfways() + decreaseBricksIncreaseHeight.NoOfways();
        }
        dictionary.put(this, totalWays);
        return totalWays;
    }

    @Override
    public int hashCode() {
        int hashCode = 31;
        hashCode = 17 * hashCode + bricks;
        hashCode = 17 * hashCode + height;
        return hashCode;
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Answer) ) 
            return false;
        if (((height != ((Answer) o).height)) || (bricks != ((Answer) o).bricks)) 
            return false;            
        return true;                
    }

//    public static void main(String [] args)
//    {
//        System.out.println(answer(8));
//    }
//    public static int answer(int n) { 
//        return bricks(1,n) -1;
//    }
//    public static int bricks(int height, int brick)
//    {
//
//        if(brick == 0)
//        {
//            return 1;
//        }
//        else if(brick < height)
//        {
//            return 0;
//        }
//        else
//        {
//            return bricks(height +1, brick - height) + bricks(height +1, brick);
//        }
//    }
}

