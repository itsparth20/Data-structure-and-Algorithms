package practiceProblem;

public class PowerSet {

	public static String s;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		s = "abc";
		call("", 0);
    }
    
    public static void call(String str, int l){
        if(l < s.length()){
            for(int i = l; i < s.length(); i++){
                System.out.println(str+s.substring(i, i+1));
                call(str+s.substring(i, i+1), i+1);
            }
        }
    }

}
