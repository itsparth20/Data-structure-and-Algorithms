
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FinalPrice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5,1,3,4,6,2};
		finalPrice(arr);
		int[] arr1 = {1,3,3,2,5};
		finalPrice(arr1);
	}
	
	static void finalPrice(int[] prices) {
        List<Integer> list = new ArrayList<>();
        int discount = 0;
        for(int i = prices.length-1; i>=0; i--){
            int max = 0;
            boolean match = false;
            for(int j = i+1; j < prices.length && !match; j++){
                if(prices[j] >= max && prices[j] <= prices[i]){
                    max = Math.max(max, prices[j]);
                    match = true;
                }
            }
            discount += prices[i] - max;
            if(max == 0) list.add(i);
        }
        System.out.println(discount);
        Collections.reverse(list);
        System.out.println(list);

    }

}