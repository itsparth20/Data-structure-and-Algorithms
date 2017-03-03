/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C3IOT;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 *
 * @author itspa
 */

/*
Verify the price with items and prices

origItem [rice, vegy]
origPrice [10, 20]
item [vegy, rice]
prices [30, 10]

Here vegy price is wrong so we have to print 1.
*/
public class verifyItems {
    public static void main(String[] args){
    
    }
    
    public static int verifyItems(String[] origItems, float[] origPrices, String[] items, float[] prices) {
        int count = 0;
        HashMap<String,Float> map = new LinkedHashMap<>();
        
        for(int i =0; i< origItems.length; i++){
            map.put(origItems[i], origPrices[i]);
        }
        
        for(int i =0; i< items.length; i++){
            float itemPrice = map.get(items[i]);
            if(itemPrice != prices[i]){
                count++;
            }
        }
        
        return count;
    }
}
