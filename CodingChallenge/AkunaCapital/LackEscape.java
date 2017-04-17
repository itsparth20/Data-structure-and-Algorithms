package practiceProblem;

public class LackEscape {

	static int manCoorX = 4;
	static int manCoorY = 2;
//	static int manCoorX = 1;
//	static int manCoorY = 1;
	static int DogCoorY = 2;
	static int DogCoorX = 2;
	static int[][] a = {{0,0,0,0,0,0,0},
				{0,0,-1,0,0,0,0},
				{0,0,1,-1,0,-1,0},
				{-1,0,0,0,0,0,0},
				{0,0,1,0,0,1,0},
				{-1,0,-1,0,-1,0,0},
				{0,0,0,0,0,0,0}				
	};
//	static int[][] a = {{0,0,0,0,0,0,0},
//			{0,0,-1,0,0,0,0},
//			{0,-1,1,-1,0,-1,0},
//			{-1,0,-1,0,0,0,0},
//			{0,0,1,0,0,1,0},
//			{-1,0,-1,0,-1,0,0},
//			{0,0,0,0,0,0,0}				
//};
//	static int[][] a = {{0,-1,0},
//						{-1,1,-1},
//						{0,-1,0},
//	};
	static boolean withDog = false;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LackEscape obj = new LackEscape();
		System.out.println(obj.walk(manCoorX, manCoorY, 0));
		
	}
	
	static private boolean walk(int manCoorX, int manCoorY, int direction){
		if(a[0].length <= manCoorX || a.length <= manCoorY || manCoorX < 0 || manCoorY < 0){
			if(withDog)
				return true;
			return false;
		}
		
		if(manCoorX == DogCoorX && manCoorY == DogCoorY)
			withDog = true;
		
		if(a[manCoorX][manCoorY] == -1)
			return false;
		
		if(a[manCoorX][manCoorY] == 1 && (
				(walk(manCoorX, manCoorY-1, 0)) ||
				(walk(manCoorX-1, manCoorY, 1)) ||
				(walk(manCoorX+1, manCoorY, 2)) ||
				(walk(manCoorX, manCoorY+1, 3))
				))
			return true;
		
		else if(direction==0)
			return walk(manCoorX, manCoorY-1, 0);
		else if(direction==1)
			return walk(manCoorX-1, manCoorY, 1);
		else if(direction==2)
			return walk(manCoorX+1, manCoorY, 2);
		else
			return walk(manCoorX, manCoorY+1, 3);					
	}

}
