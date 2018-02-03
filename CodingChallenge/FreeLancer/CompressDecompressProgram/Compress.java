

/*
 * param 1 : textFile name
 * param 2 : codefile name
 * 
 * output: compressed file [.zzz extension]
 * 
 */
public class Compress {
	public static void main(String args[]){
		String fileName = args[0];
		String compressionCodesName = args[1];
		String outputName = args[0].substring(0, args[0].length() - 3) + "zzz";
		
		//create file objects		
		TextFile inputcompressionCodesFile = new TextFile(compressionCodesName, "read");
		TextFile inputTextFile = new TextFile(fileName, "read");
		CompressedFile outputTextFile = new CompressedFile(outputName, "write");
		ArrayCode arrCode = new ArrayCode(100);
		fillCompressCode(inputcompressionCodesFile, arrCode);
		String write = "";
		while (true){
			char c = inputTextFile.readChar();
			if(c == (char)0) break;
			int index = arrCode.findCharacter(c);
			// break the loop if character does not exist in code file
			if(index == -1) {
				System.out.println(" There is no compression code for character ");
				return;
			}
			String code = arrCode.getCode(index);
			// write bit to output file
			for(int i =0; i < code.length(); i++){
				outputTextFile.writeBit(code.charAt(i));
			}
		}
		
		//close all the files
		outputTextFile.close();
		inputTextFile.close();
		inputcompressionCodesFile.close();
	}

	//add codePair to arrCode object
	private static void fillCompressCode(TextFile inputcompressionCodesFile,
			ArrayCode arrCode) {
		char c;
		String code;
		while (true){
			c = inputcompressionCodesFile.readChar();
			if(c == (char)0) break;
			code = inputcompressionCodesFile.readLine();
			arrCode.add(new CodePair(c, code));
		}
	}
	
	
	
	
}
