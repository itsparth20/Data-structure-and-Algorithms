package Amazon;

import java.util.ArrayList;
import java.util.List;

public class PrizeProgram{

	public static void main(String[] args) {
		List<List<String>> codeList = new ArrayList<List<String>>();
		List<String> a = new ArrayList<>();
		// List<String> a = new Arraylist<String>();

		a.add("apple");
		a.add("apple");
		List<String> b = new ArrayList<>();
		b.add("banana");
		b.add("anything");
		b.add("banana");
		codeList.add(a);
		codeList.add(b);

		List<String> shoppingCart = new ArrayList<String>();
		shoppingCart.add("orange");
		shoppingCart.add("apple");
		shoppingCart.add("apple");
		shoppingCart.add("banana");
		shoppingCart.add("orange");
		shoppingCart.add("apple");

		System.out.println(checkWinner(codeList, shoppingCart));
	}

	public static int checkWinner(List<List<String>> codeList, List<String> shoppingCart) {
		int begin = 0;
		boolean br = false;
		int shoppingCartSize = shoppingCart.size();
		for (int i = 0; i < codeList.size(); i++) {
			br = false;
			List<String> codeFruit = codeList.get(i);
			for (int k = begin; k < shoppingCart.size(); k++) {
				if (begin + codeFruit.size() > shoppingCartSize)
					return 0;
				for (int j = 0, l = 0; j < codeFruit.size(); j++, l++) {
					if (codeFruit.get(j).equals(shoppingCart.get(begin)) || codeFruit.get(j).equals("anything")) {
						begin += 1;
						if (j == codeFruit.size() - 1)
							br = true;
					} else {
						begin += 1;
						break;
					}
				}
				if (br)
					break;
			}
		}
		return 1;
	}

}
