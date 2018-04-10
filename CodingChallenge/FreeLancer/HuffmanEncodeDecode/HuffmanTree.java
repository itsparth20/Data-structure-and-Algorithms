
/*
this class help to generate the huffmantree class.
it extend the LinkedBinaryTree and implements Comparable
to sort the the huffmantree in ascending order base on frequency of the
character
 */
public class HuffmanTree extends LinkedBinaryTree<HuffmanPair>
        implements Comparable<HuffmanTree> {

    //this method help to make the huffmantree in ascending order
    @Override
    public int compareTo(HuffmanTree otherTree) {
        return this.getRoot().getElement().getFrequency() - otherTree.getRoot().getElement().getFrequency();
    }

    //constructor to initialize the huffmantree
    public HuffmanTree() {
        super();
    }
    //constructor to initialize the huffmantree and root is element
    public HuffmanTree(HuffmanPair element) {
        super(element);
    }

    //constructor to initialize the huffmantree root is element and
    //left is leftsubtree and right is rightsubtree
    public HuffmanTree(HuffmanPair element,
                       HuffmanTree leftSubtree,
                       HuffmanTree rightSubtree) {
        super(element);
        BinaryTreeNode<HuffmanPair> root = getRoot();
        root.setLeft(leftSubtree.getRoot());
        root.setRight(rightSubtree.getRoot());
    }

    //initialize the huffmantree using huffmanpair list.
    public HuffmanTree(ArrayOrderedList<HuffmanPair> pairsList) {
        super();
        //init the order list of huffmantree
        ArrayOrderedList<HuffmanTree> buildList = new ArrayOrderedList<>();
        //populate the buildlist
        for (int i = 0; i < pairsList.size(); i++) {
            HuffmanTree tree = new HuffmanTree(pairsList.getElement(i));
            buildList.add(tree);
        }

        //if buildlist only has one element then make the root and *, (frequency)
        // and left child is the element inside the buildlist
        if (buildList.size() == 1) {
            HuffmanTree first = buildList.removeFirst();
            HuffmanPair rootPair = new HuffmanPair(
                    first.getRoot().getElement().getFrequency()
            );
            HuffmanTree rootHuffmanTree = new HuffmanTree(rootPair);
            rootHuffmanTree.getRoot().setLeft(first.getRoot());
            buildList.add(rootHuffmanTree);
        }
        //if buildlist size is greater then 1 and this will generate the tree
        //by first remove the first two element from the buildlist and then
        //create one huffmanpair where the character is 0 and frequency is sum
        //of first and second element frequency
        //create huffmanTree using where the first and right is left and right
        //child of the huffmaanpair, respectively
        while(buildList.size() > 1) {
            HuffmanTree first = buildList.removeFirst();
            HuffmanTree second = buildList.removeFirst();
            HuffmanPair rootPair = new HuffmanPair(
                    first.getRoot().getElement().getFrequency() +
                            second.getRoot().getElement().getFrequency()
            );
            buildList.add(new HuffmanTree(rootPair, first, second));
        }

        //set the root of the huffmantree as first element in the list.
        setRoot(buildList.removeFirst().getRoot());
    }
}
