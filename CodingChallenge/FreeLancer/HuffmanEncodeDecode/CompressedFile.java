import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Class to open a file and either read information from it or write information
 * to it. If a file is opened in "read" mode we can only read information from
 * it. Otherwise, we can only write information to it.
 *
 */
public class CompressedFile {

	// Method readChar() returns this value when the end of the file has been
	// reached
	public static final char EOF = 0;

	private FileInputStream in; // This variable points to the input file
	// private BufferedWriter out; // This variable points to the output file
	private DataOutputStream out;
	private String accessMode; // Determines whether we wish to read from or to
								// write to the file

	private int bitsRead;
	private int bitsWritten;
	private char buffer;

	/**
	 * Checks that the specifed name corresponds to an existing file and if so
	 * it opens the file
	 * 
	 * @param name
	 *            name of the input file
	 */
	public CompressedFile(String fileName, String fileMode) {
		if (fileMode.equals("read")) {
			File file;
			file = new File(fileName);
			accessMode = "read";

			if (!file.exists()) {
				System.out.println("File " + fileName + " does not exist.");
				System.exit(0); // end program
			}
			if (!(file.isFile() && file.canRead())) {
				System.out.println("file " + fileName + " cannot be read from.");
				System.exit(0);
			}
			try {
				in = new FileInputStream(file); // Get ready to read from the
												// file
				bitsRead = 8; // Forces a new character to be read when method
								// readChar is invoked
			} catch (IOException e) {
				System.out.println("Error opening file " + fileName);
				System.exit(0);
			}
		} else {
			FileOutputStream fw;
			accessMode = "write";
			bitsWritten = 0;

			try {
				fw = new FileOutputStream(fileName);
				out = new DataOutputStream(fw);
			} catch (IOException e) {
				System.out.println("Error opening output file " + fileName);
			}
		}
	}

	/**
	 * Writes a character to the output file
	 * 
	 * @param bit
	 *            Bit to write to the output file
	 */
	public void writeBit(char bit) {
		int b;
		try {
			// Convert the character "bit" to a bit. Bits are stored in "buffer"
			if (bit == '0')
				buffer = (char) (2 * (int) buffer);
			else
				buffer = (char) (2 * (int) buffer + 1);
			b = buffer;
			++bitsWritten;
			if (bitsWritten == 8) {
				out.write(buffer);
				bitsWritten = 0;
				buffer = 0;
			}

		} catch (IOException e) {

			System.out.println("Error writing to output file");
		}
	}

	/**
	 * Reads the next bit from the input file. If all the bits have been read
	 * this method returns EOF. Bit returned is first converted to a char, so
	 * this method returns a bit as either '0' or '1'.
	 * 
	 * @return Next bit from the input file or EOF if there are no more bits in
	 *         it.
	 */
	public char readBit() {
		char c = 0;

		if (bitsRead == 8)
			try {
				if (in.available() > 0) { // We have not reached the end of the
											// file
					buffer = (char) in.read();
					bitsRead = 0;
				} else
					return 0;
			} catch (IOException e) {
				System.out.println("Error reading from file ");
				System.exit(0); // Terminate the program
			}

		// return next bit from the buffer; bit is converted first to char
		if ((buffer & 128) == 0)
			c = '0';
		else
			c = '1';
		buffer = (char) (buffer << 1);
		++bitsRead;

		return c;
	}

	/**
	 * Close the file to ensure that no information is lost.
	 */
	public void close() {
		String padding = Huffman.getPadding();

		try {
			if (accessMode.equals("read"))
				in.close();
			else {
				int i = 0;
				int b;
				
				if (padding == null || padding.length() == 0) {
					padding = "00000000";
					System.out.println("Something is wrong. File will not decompress correctly");
				}
				else 
					// The padding needs to be of length at least 7
					while (padding.length() < 7) padding += padding;
				
				while (bitsWritten < 8) {
					buffer = (char) (buffer << 1);
					b = buffer;
					if (padding.charAt(i) == '1')
						buffer = (char) (buffer + 1);
					b = buffer;
					++i;
					++bitsWritten;
				}
				out.write(buffer);
				out.close();
			}
		} catch (IOException e) {
			System.out.println("Error closing file ");
			System.exit(0); // Terminate the program
		}
	}
}
