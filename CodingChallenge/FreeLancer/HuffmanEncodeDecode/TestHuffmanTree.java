import java.util.Iterator; 

public class TestHuffmanTree {
	
	public static void main(String[] args) {

		System.out.println("\nTests for class HuffmanTree");
		System.out.println("===========================");
		
		HuffmanTree tree = new HuffmanTree() ;
		if (tree.getRoot() == null) {
			System.out.println("Test 1 passed\n");
		}
		
		HuffmanPair pair1 = new HuffmanPair('a',5);
		HuffmanTree tree1 = new HuffmanTree(pair1);
		if (tree1.size() == 1 && tree1.getRoot().getLeft() == null && tree1.getRoot().getRight() == null) {
			System.out.println("Test 2 passed\n");
		}
		
		HuffmanPair pair2 = new HuffmanPair('b',3);
		HuffmanPair pair3 = new HuffmanPair((char)0,8);
		HuffmanTree tree2 = new HuffmanTree(pair2);
		HuffmanTree tree3 = new HuffmanTree(pair3,tree1,tree2);
		
		if(tree3.getRoot().getLeft() == tree1.getRoot() && tree3.getRoot().getRight() == tree2.getRoot()) { 
			System.out.println("Test 3 passed\n");
		}
		else {
			System.out.println("Test 3 failed\n");
		}
		
		HuffmanPair[] h = new HuffmanPair[6];
				
		h[0] = new HuffmanPair('a',5);
		h[1] = new HuffmanPair('b',7);
		h[2] = new HuffmanPair('c',10);
		h[3] = new HuffmanPair('d',15);
		h[4] = new HuffmanPair('e',20);
		h[5] = new HuffmanPair('f',45);
				
		ArrayOrderedList<HuffmanPair> list = new ArrayOrderedList<HuffmanPair>();

		for (int i = 0; i < 6; i++) {
			list.add(h[i]);
		}
		HuffmanTree tree4 = new HuffmanTree(list);
		Iterator<HuffmanPair> iter = tree4.iteratorPreOrder();
		int sum = 0;
		while (iter.hasNext() ) {
			sum += iter.next().getFrequency() ;
		}
		if (sum == 330) {
			System.out.println("Test 4 passed\n");	
		}
		else {
			System.out.println("Test 4 failed\n");
		}
	}
}
