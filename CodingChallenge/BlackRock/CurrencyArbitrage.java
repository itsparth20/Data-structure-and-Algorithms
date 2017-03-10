/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackRock;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author itspa
 */
class CurrencyArbitrage {
    public static void main(String[] args){
         String[] quotes = {"0.5795 0.5173 1.2223",
                            "0.7931 0.5663 1.0012",
                            "1.4318 1.4705 1.3352",
                            "1.3413 0.8072 1.0355",
                            "1.2767 1.1696 0.5423",
                            "0.6903 0.7520 0.5195",
                            "1.3832 0.7238 1.4037",
                            "0.5739 1.4304 0.9906",
                            "0.5648 1.0071 1.7581",
                            "0.8033 0.9961 1.2498"};
         System.out.println(Arrays.toString(arbitrage(quotes)));
    }
    
    public static int[] arbitrage(String[] quotes) {
        int[] benefit = new int[quotes.length];
        for(int i =0; i<quotes.length; i++){
            String[] currency = quotes[i].split(" ");
            double result = 100000/Double.valueOf(currency[0]);
            result /= Double.valueOf(currency[1]);
            result /= Double.valueOf(currency[2]);
            int finalValue = (int)result - 100000;
            benefit[i] = finalValue > 0 ? finalValue : 0;            
        }
        return benefit;
    }
}
