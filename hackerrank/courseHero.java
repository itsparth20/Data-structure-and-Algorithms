
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author itspa
 */
public class courseHero {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int numberofvalue = sc.nextInt();
        int smallvalue, largevalue = 0;
        int change = 2;
        int[] arrvalue = new int[numberofvalue];
        for (int i = 0; i < numberofvalue; i++) {
            arrvalue[i] = sc.nextInt();
        }
        smallvalue = arrvalue[0];
        for (int i = 0; i < numberofvalue; i++) {
            if (smallvalue > arrvalue[i]) {
                smallvalue = arrvalue[i];
            } else if (largevalue < arrvalue[i]) {
                largevalue = arrvalue[i];
            }
        }

        while (change != 1) {
            change = 0;
            for (int i = 0; i < numberofvalue; i++) {
                if (arrvalue[i] > 0) {
                    arrvalue[i] -= smallvalue;
                    change++;
                }
            }
            System.out.println(change);

            largevalue = 0;
            for (int i = 0; i < numberofvalue; i++) {
                if (arrvalue[i] > 0) {
                    if (smallvalue > arrvalue[i]) {
                        smallvalue = arrvalue[i];
                    }
                }
                if (largevalue < arrvalue[i]) {
                    largevalue = arrvalue[i];
                }

            }

        }

    }

}
