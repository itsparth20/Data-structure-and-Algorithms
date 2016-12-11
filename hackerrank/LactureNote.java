import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LactureNote {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String s = in.next();
        int checkFriend = 1;
        char[] binary = s.toCharArray();
        int friends[] = new int[k];
        for(int friends_i=0; friends_i < k; friends_i++){
            friends[friends_i] = in.nextInt();
            int studentidPostion = friends[friends_i] - 1;
            if(binary[studentidPostion] == '0'){
                System.out.println("YES");
                checkFriend = 0;
                break;
            }            
        }
        if(checkFriend == 1)
            System.out.println("NO");
        
    }
}
