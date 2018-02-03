
/*
 * Class store the character and code string
 * This is POJO class 
 */
public class CodePair {

	char character;
	String code;
	public CodePair(char c, String code){
		this.character = c;
		this.code = code;
 	}
	public char getCharacter() {
		return character;
	}
	
	public void setCharacter(char character) {
		this.character = character;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public boolean equals(CodePair obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CodePair other = obj;
		if (character != other.character)
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}
}
