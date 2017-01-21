/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package googlequestion;

/**
 *
 * @author itspa
 */
public class OneEditAway {
    public static void main(String[] args) {
        System.out.println(oneEditAway("pale","pal"));
        System.out.println(oneEditAway("pale","pald"));
        System.out.println(oneEditAway("pale","palep"));
        System.out.println(oneEditAway("pale","palepp"));
    }

    private static boolean oneEditAway(String first, String second) {
        boolean oneEdit = false;
        
        if(first.length() == second.length()){
            oneEdit = oneEdit(first,second);
        }
        if(first.length() == second.length()-1){
            oneEdit = oneInsert(first,second);
        }
        if(first.length() == second.length()+1){
            oneEdit = oneInsert(second,first);
        }
        return oneEdit;
    }

    private static boolean oneEdit(String first, String second) {
        int x = 0;
        boolean change = false;
        while(x<first.length()){
            if(first.charAt(x) != second.charAt(x)){
                if(!change){
                change = true;
                }
                else{
                    return false;
                }
            }
            x++;
        }
        return true;
    }

    private static boolean oneInsert(String first, String second) {
        int firstIndex = 0, secondIndex = 0;        
        boolean change = false;
        while(firstIndex<first.length()){
            if(first.charAt(firstIndex) == second.charAt(secondIndex)){
                firstIndex++;
                secondIndex++;
            }
            else{
                if(!change){
                    secondIndex++;
                    change = true;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}
