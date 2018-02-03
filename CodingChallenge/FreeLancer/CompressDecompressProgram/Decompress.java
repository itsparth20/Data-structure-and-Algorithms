
/*
 * param 1 : compressed file name
 * param 2 : codefile name
 * 
 * output: compressed file [.zzz extension]
 * 
 */
public class Decompress {

	public static void main(String[] args) {
		String compressionFileName = args[0];
		String compressionCodesName = args[1];
		String outputName = args[0].substring(0, args[0].length() - 3) + "dec";
		
		//create file objects
		TextFile inputcompressionCodesFile = new TextFile(compressionCodesName, "read");
		CompressedFile compressionTextFile = new CompressedFile(compressionFileName, "read");
		TextFile outputTextFile = new TextFile(outputName, "write");
		ArrayCode arrCode = new ArrayCode(100);
		fillCompressCode(inputcompressionCodesFile, arrCode);
		char c;
		String str = "";
		while(true){
			c = compressionTextFile.readBit();
			if(c == (char)0) break;
			int chIndex = arrCode.findCode(str+c);
			//when match the code then write character to output file
			if(chIndex != -1){
				str = "";				
				outputTextFile.writeChar(arrCode.getCharacter(chIndex));
				continue;
			}
			str += c;			
		}
		
		//close all the files
		outputTextFile.close();
		compressionTextFile.close();
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
