public class Huffman {
	
	/**
	 * This class contains the main method of the assignments and performs file
	 * compression/decompression using Huffman coding.
	 * 
	 */
	
	private final static int Mode = 0;
	private final static int Frequency_File = 1;
	private final static int Text_File = 2;
	private final static int Compressed_File = 3;
	private final static int Args_Length = 4;
	private final static char EOF_Char = (char) 1;
	private static String padding = "";
	
	public static void main(String[] args) {
		
		if (args.length != Args_Length) {
			System.out.println("Incorrect number of arguments, aborting\n");
			System.exit(0);
		}
		if (args[Mode].equals("-c")) { // Compress mode. Produce Frequency file and compress test file
			produceFrequencyFile(args[Frequency_File],args[Text_File]);
			compress(args[Frequency_File],args[Text_File],args[Compressed_File]);
		}
		else {
			if (args[Mode].equals("-d")) { // Decompress mode
				decompress(args[Frequency_File],args[Text_File],args[Compressed_File]);
			}
			else {
				System.out.println("Invalid arguments, aborting\n");
				System.exit(0);
			}
		}
	}
	
	// Method to compress a text file with the help of its corresponding frequency file
	
	private static void compress(String freqFileName, String textFileName, String compressedFileName) {
		
		ArrayOrderedList<HuffmanPair> orderedPairs;

		TextFile textIn = new TextFile(textFileName,"read");
		CompressedFile compressedOut = new CompressedFile(compressedFileName,"write");
		
		orderedPairs = readFrequencyFile(freqFileName); // Read the frequency pairs in	
		HuffmanCoder encoder = new HuffmanCoder(orderedPairs);
				
		String s;
		char symbol = textIn.readChar();
		while(symbol != (char)0) { // For all the characters in the file
			s = encoder.encode(symbol) ; // Encode the character
			for(int i = 0; i < s.length(); i++) { // Write to compressed file bit by bit
				compressedOut.writeBit(s.charAt(i));
			}
			symbol = textIn.readChar();
		}
		
		symbol = EOF_Char;
		padding = encoder.encode(symbol);
		
		textIn.close();
		compressedOut.close();
	}
	
	private static void decompress(String freqFileName, String textFileName, String compressedFileName ) {
		
		ArrayOrderedList<HuffmanPair> orderedPairs;

		TextFile textOut = new TextFile(textFileName,"write");
		CompressedFile compressedIn = new CompressedFile(compressedFileName,"read");
		
		orderedPairs = readFrequencyFile(freqFileName); // Read the frequency pairs in
		HuffmanCoder encoder = new HuffmanCoder(orderedPairs);
		
		char decoded;
		String s = "";
				
		char c = compressedIn.readBit(); // Read first bit from the file
		while (c != (char)0) { // For all the characters in the file
			s += String.valueOf(c); // Append to string s
			while ((decoded = encoder.decode(s)) == (char)0 && c != (char)0) { // Try to decode
				c = compressedIn.readBit(); // Read another bit
				s += String.valueOf(c); // Append to string s
			}
			if (decoded != (char)0) textOut.writeChar(decoded);
			c = compressedIn.readBit();
			s = "";
		}
		textOut.close();
		compressedIn.close();
	}
	
	// This helper method reads the symbol frequency file and returns an ordered list
		// of Huffman pairs
		
	private static ArrayOrderedList<HuffmanPair> readFrequencyFile(String freqFileName) {
			
		TextFile freqIn = new TextFile(freqFileName,"read");
		ArrayOrderedList<HuffmanPair> orderedPairs = new ArrayOrderedList<HuffmanPair>();
			
		char symbol = freqIn.readChar();
		while (symbol != (char)0) {
			String s = freqIn.readLine();
			orderedPairs.add(new HuffmanPair(symbol,Integer.valueOf(s)));
			symbol = freqIn.readChar();
		}
		freqIn.close();
		return orderedPairs;	
	}

	// This method reads the text file and produces the frequency file
	
	private static void produceFrequencyFile(String freqFileName, String textFileName) {
		
		char c;
		ArrayUnorderedList<HuffmanPair> unorderedPairs = new ArrayUnorderedList<HuffmanPair>();
		ArrayOrderedList<HuffmanPair> orderedPairs = new ArrayOrderedList<HuffmanPair>();
		
		TextFile textIn = new TextFile(textFileName,"read");
		TextFile freqOut = new TextFile(freqFileName,"write");
		HuffmanPair hPair;
		
		c = textIn.readChar();
		while (c != (char)0) {
			hPair = new HuffmanPair(c,1);
			if (unorderedPairs.contains(hPair)) {
				unorderedPairs.getElement(unorderedPairs.find(hPair)).incrementFrequency();
			}
			else {
				unorderedPairs.addToRear(hPair);
			}
			c = textIn.readChar();
		}
		
		c = (char) EOF_Char; // Add sentinel character to mark end of input
		hPair = new HuffmanPair(c,1);
		unorderedPairs.addToRear(hPair);
		
		while (unorderedPairs.size() > 0) { // Order the Huffman pairs list
			orderedPairs.add(unorderedPairs.removeLast());
		}
		
		for (int i = 0; i < orderedPairs.size(); i++) {  // Write the ordered Huffman pairs to the file
			freqOut.writeAllChar(orderedPairs.getElement(i).getCharacter());
			String s = String.valueOf(orderedPairs.getElement(i).getFrequency());
			for (int j = 0; j < s.length(); j++) {
				freqOut.writeAllChar(s.charAt(j));
			}
			freqOut.writeAllChar('\r');
			freqOut.writeAllChar('\n');
		}
				
		textIn.close();
		freqOut.close();
	}
	
	/**
	* Computes the padding bits used to complete the last byte to be written to the compressed
	* file. These bits need not be a prefix of any of the Huffman codes.
	* @return: padding bits to complete last character to write to compressed file
	**/
	
	public static String getPadding() {
		return padding;
	}
}
