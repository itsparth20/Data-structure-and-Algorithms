package vecna;
public class PrimesImprovement {

  public static void main(String[] args) {
 
    //This code should print out the prime numbers.
    //task: Fix and improve the algorithm
    
    System.out.println("Printing primes from 1 to 100");
    int i;
    int j;
    boolean prime;
    for(i = 2; i <= 100; i++) {
      prime = true;
      for(j = 2; j < i; j++) {
        if((i!=j) && (i % j == 0)) {
            prime = false; 
            break;
        }
      } 
      if(prime) {
        System.out.print(i + " ");
      }
    }
    System.out.println();
  }
}
