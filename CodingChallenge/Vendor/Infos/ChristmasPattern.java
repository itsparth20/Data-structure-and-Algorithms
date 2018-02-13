/*
Pattern :

    * 5
   * * 6
  * * * 7
 * * * * 8
* * * * * 9

*/
public void printData(){
    Stream.iterate(4, x-> x-1).limit(5).forEach(x -> {
	for(int j = 0; j < x; j ++){
            System.out.print(" ");
        }
        for(int i = 5; i > x; i--){
            System.out.print("* ");    
        }
        System.out.println();
	});
    
    for(int x = 4; x <=0; x--){
        for(int j = 0; j < x; j ++){
            System.out.print(" ");
        }
        for(int i = 5; i > x; i--){
            System.out.print("* ");    
        }
        System.out.println();
	}
}