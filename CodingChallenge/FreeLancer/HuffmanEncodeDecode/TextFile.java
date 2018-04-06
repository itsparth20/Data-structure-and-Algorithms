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
public class TextFile {

	// Method readChar() returns this value when the end of the file has been
	// reached
	public static final char EOF = 0;

	private FileInputStream in; // This variable points to the input file
	// private BufferedWriter out; // This variable points to the output file
	private DataOutputStream out;
	private String accessMode; // Determines whether we wish to read from or to
								// write to the file

	/**
	 * Checks that the specified name corresponds to an existing file and if so
	 * it opens the file
	 * 
	 * @param name
	 *            name of the input file
	 */
	public TextFile(String name, String mode) {
		if (mode.equals("read")) {
			File file;
			file = new File(name);
			accessMode = "read";

			if (!file.exists()) {
				System.out.println("File " + name + " does not exist.");
				System.exit(0); // end program
			}
			if (!(file.isFile() && file.canRead())) {
				System.out.println("file " + file.getName() + " cannot be read from.");
				System.exit(0);
			}
			try {
				in = new FileInputStream(file); // Get ready to read from the
												// file

			} catch (IOException e) {
				System.out.println("Error opening file " + name);
			}
		} else {
			FileOutputStream fw;
			accessMode = "write";

			try {
				fw = new FileOutputStream(name);
				out = new DataOutputStream(fw);
			} catch (IOException e) {
				System.out.println("Error opening output file " + name);
			}
		}
	}

	/**
	 * Writes a character to the output file, except the character used to mark end of file
	 * 
	 * @param c
	 *            Character to write to the output file
	 */
	public void writeChar(char c) {
		char EOF_Marker = (char) 1;
		try {
			if (c != EOF_Marker && c != EOF)
				out.write(c);

		} catch (IOException e) {

			System.out.println("Error writing to output file");
		}
	}

	
		/**
	 * Writes a character to the output file, even the character used to mark end of file
	 * 
	 * @param c
	 *            Character to write to the output file
	 */
	public void writeAllChar(char c) {
		try {
				out.write(c);

		} catch (IOException e) {

			System.out.println("Error writing to output file");
		}
	}
	/**
	 * Reads the next character from the input file. If all the characters have
	 * been read this method returns EOF
	 * 
	 * @return Next character from the input file or EOF if the whole file
	 *         has already been read.
	 */
	public char readChar() {
		char c = 0;
		try {
			if (in.available() > 0) { // We have not reached the end of the file
				c = (char) in.read();
			}
		} catch (IOException e) {
			System.out.println("Error reading from file ");
			System.exit(0); // Terminate the program
		}
		return c;
	}

        /**
         * Reads characters from the current position of the input file until the end of line
         * is reached. The String read is returned. 
         * @return String of characters from current position in input file until the end of line.
         *         returns null if there are no more characters to read from the file.
         */
	public String readLine() {
		String line = "";
		char c;
		try {

			while (in.available() > 0) { // We have not reached the end of the
											// file
				c = (char) in.read();
				if (((int) c != 13) && ((int) c != 10))
					line = line + c;
				if ((int) c == 10)
					break;
			}
			if (in.available() == 0 && line.equals("")) line = null;

		} catch (IOException e) {
			System.out.println("Error reading from file ");
			System.exit(0); // Terminate the program
		}
		return line;
	}

	/**
	 * Close the file to ensure that no information is lost.
	 */
	public void close() {
		try {
			if (accessMode.equals("read"))
				in.close();
			else
				out.close();
		} catch (IOException e) {
			System.out.println("Error closing file ");
			System.exit(0); // Terminate the program
		}
	}
}
