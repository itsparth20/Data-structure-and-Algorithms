package Axon;

public class Triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Triangle triangle = new Triangle();
		System.out.println(triangle.getType(0, 5, 6));
		System.out.println(triangle.getType(5, 5, 15));
		System.out.println(triangle.getType(5, 5, 10));
		System.out.println(triangle.getType(5, 6, 10));
		System.out.println(triangle.getType(5, 5, 4));
		System.out.println(triangle.getType(5, 5, 5));
	}
	
	public int getType(int a, int b, int c){
		if((a<=0 || b<=0 || c<=0) || (a+b<=c || b+c<=a || a+c<=b))
			return 4;		
		else if(a==b && b==c)
			return 3;
		else if(a==b || b==c || a==c)
			return 2;		
		else
			return 1;		
	}

}
