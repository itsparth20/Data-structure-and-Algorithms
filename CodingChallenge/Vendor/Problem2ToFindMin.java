
public class Problem2ToFindMin {

	public static void main(String[] args) {
		System.out.println(solution(15));
	}
	
	public static int solution(int N) {
        int past = 0;
        int i = 0;
        while(true){
            int sum = past+i;
            if(sum < N){
                past = sum;
                i++;
            }else{
                return i;    
            }
        }
    }

}

