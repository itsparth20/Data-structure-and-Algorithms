package vecna;

public class Sort {

  public static void main(String[] args) {
    //This code will sort the numbers in the array.
    //task: Modify the algorithm to reverse the sort, then comment on its
    //efficiency in the space provided below:
    /*
        The program run in BIG of O(n^2). 
        If array will be long then its takes much time. Therefore it is inefficient. 
        We can also do this program in O(nlogn).
    */

    //fill the array with random numbers
    int[] unsorted = new int[100];
    for(int i = 0; i < 100; i++) {
      unsorted[i] = (int) (Math.random() * 100);
    }

    System.out.println("Here are the unsorted numbers:");
    for(int i = 0; i < 100; i++) {
      System.out.print(unsorted[i] + " ");
    }
    System.out.println();

    int[] sorted = new int[100];
    for(int i = 0; i < 100; i++) {
      int hi = 101;
      int hiIndex = -1;
      for(int j = 0; j < 100; j++) {
        if(unsorted[j] < hi) {
          hi = unsorted[j];
          hiIndex = j;
        }
      }
      sorted[i] = hi;
      unsorted[hiIndex] = 102;
    }
    System.out.println("Here are the sorted numbers: ");
    for(int i = 0; i < 100; i++) {
      System.out.print(sorted[i] + " ");
    }
    System.out.println();
  }
}

