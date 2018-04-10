/*
This class is used to create encoding and decoding file. And generate encoding list
This class has init point of huffman tree and encoding list that is generated based on
huffman tree.
 */
public class HuffmanCoder {
    //two instance variable, one is type of huffmantree and another is type of list of encodingdata
    private HuffmanTree huffTree;
    private ArrayUnorderedList<EncodingData> encodingList;

    //constructor to initialize the state of the object
    public HuffmanCoder(ArrayOrderedList<HuffmanPair>
                                pairsList) {
        huffTree = new HuffmanTree(pairsList);
        encodingList = new ArrayUnorderedList<>();
        buildEncodingList(huffTree.getRoot(), "");
    }

    //to decode the code and get the corresponding character
    public char decode(String code) {
        //get the root element of the huffman tree
        BinaryTreeNode<HuffmanPair> treeNode = huffTree.getRoot();
        //go through the code and if the code is 0 then go left and if code is
        //1 then go to right. Repeat the steps to get the end of the code string
        //if tree is leaf node then return the corresponding character.
        for(int i = 0; i < code.length(); i++) {
            if (code.charAt(i) == '0' ){
                if (treeNode.getLeft() != null) {
                    treeNode = treeNode.getLeft();
                }else{
                    return (char) 0;
                }
            }else{
                if (treeNode.getRight() != null) {
                    treeNode = treeNode.getRight();
                }else{
                    return (char) 0;
                }
            }
        }
        return treeNode.isLeaf() ? treeNode.getElement().getCharacter() : (char)0;
    }

    //generate the corresponding encoding string from the encodinglist.
    //so iterate over the list and find the corresponding character and return
    //that value. if value is not there then throws elementnotfoundexception
    public String encode(char c) throws ElementNotFoundException{
        for (int i = 0 ; i < encodingList.size(); i++) {
            if (c == encodingList.getElement(i).getSymbol()) {
                return encodingList.getElement(i).getEncoding();
            }
        }
        throw new ElementNotFoundException(String.format("%c not found", c));
    }

    @Override
    public String toString() {
        return "HuffmanCoder{" +
                "encodingList=" + encodingList +
                '}';
    }

    //this method help use to build the encoding list.
    //we are using recursion to populate the list
    //call the method itself for left and right child with 0 and 1
    //respectively and if node is leaf node then add the corresponding string
    //and character to encoding list
    private void buildEncodingList(BinaryTreeNode<HuffmanPair> nood, String encoding) {
        if (nood.isLeaf()) {
            encodingList.addToFront(new EncodingData(nood.getElement().getCharacter(), encoding));
        } else {
            buildEncodingList(nood.getLeft(), encoding+"0");
            buildEncodingList(nood.getRight(), encoding+"1");
        }
    }
}