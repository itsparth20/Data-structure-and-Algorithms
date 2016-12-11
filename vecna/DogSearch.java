package vecna;

public class DogSearch {

 public static void main(String[] args) {
    //This code will not compile correctly until you fix it.
    //
    //We are trying to count the number of times the word
    //dog appears in some input text, but we can't seem to
    //remember the appropriate method call in the String class,
    //and are not sure our approach will work.
    //task: Use the JDK documentation to help us finish the code,
    //then discuss the ambiguity in the problem description, and
    //reword it to remove the ambiguity in the space provided below.

    /*
        Ambiguity are
            1. No clear explanation for some words such as dogman, Doglips. Because Dogman also contain word dog same as Doglips also contains word dog. 
            2. No clear explanation for "dog" and "DOG". Means should should we count "DOG" as dog or not.
            
        Without Ambiguty:
            1. "DOG" or "dog" count as a similar word to dog.
            2. "Dogman" or "Doglips"  should not be count as similar word to dog.
            3. "God-like" or "god," count as a similar word to dog.

    */

    int counter = 0;
    String s = "The Dogman was no ordinary dog, nor man, but rather a peculiar dog-like man who barked like a dog, and panted like a dog, he even ate like a dog.  He owned a dog named Doglips, and interestingly enough, his favorite food was hotdogs";
    String str[]= s.split("\\W");
    for (String str1 : str) {
        if (str1.equalsIgnoreCase("dog")) {
             counter++;
        }
    }
    System.out.println("Word \"dog\" appears "+counter+" time.");    
  } 
 
}

