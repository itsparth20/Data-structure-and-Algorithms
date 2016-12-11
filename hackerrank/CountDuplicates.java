import java.util.HashSet;
 
public class CountDuplicates {
     static int countDuplicates(int[] numbers) {
         HashSet<Integer> set = new HashSet<Integer>();
         HashSet<Integer> duplicateSet = new HashSet<Integer>();
          
         for(int i=0;i<numbers.length;i++){
                if(set.contains(numbers[i])){
                    duplicateSet.add(numbers[i]);
                }else{
                    set.add(numbers[i]);
                }
            }
          
         return duplicateSet.size();
     }
      
     public static void main(String p[]){
        int a[]={20,20,20,30,40,50,60,90,80,90,100};
        System.out.println("Total Number having duplicate Count:"+countDuplicates(a));
     }
 
}