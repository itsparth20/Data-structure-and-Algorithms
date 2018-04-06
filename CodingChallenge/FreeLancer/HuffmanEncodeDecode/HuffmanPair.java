public class HuffmanPair implements Comparable<HuffmanPair> {
	
	private char symbol;
	private int frequency;
	
	public HuffmanPair(char c, int f) {
		
		symbol = c;
		frequency = f;
	}
	
	public HuffmanPair(int f) {
		
		symbol = (char)0;
		frequency = f;
		
	}
	
	public char getCharacter() {
		
		return symbol;
	}
	
	public int getFrequency() {
		
		return frequency;
	}
	
	public void setCharacter(char c) {
		
		symbol = c;
	}
	
	public void setFrequency(int f) {
		
		frequency = f;
	}
	
	public void incrementFrequency() {
		
		frequency += 1;
	}
	
	public int compareTo(HuffmanPair otherPair) {
		
		return this.frequency - otherPair.getFrequency();
	}

	public boolean equals(Object obj) {
		
		HuffmanPair other = (HuffmanPair) obj;
		if (symbol != other.symbol)
			return false;
		return true;
	}

	public String toString() {
		
		String s = "";
		s = "(" + Character.toString(symbol) + ", " + Integer.toString(frequency) + ")\n" ;
		return s;
	}
}
