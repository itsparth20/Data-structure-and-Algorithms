package foobar.doomsdayFuel;

import java.util.ArrayList;
import java.util.Arrays;

class ReactorCore {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		int m[][] = { 
					{ 0, 1, 1, 0, 0, 1, 0, 0, 1, 1 }, 
					{ 4, 0, 0, 3, 2, 0, 3, 0, 4, 0 }, 
					{ 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, 
					{ 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
					{ 1, 0, 0, 5, 0, 0, 7, 0, 0, 0 }, 
					{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
					{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 0, 4, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 5, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
		};
		
		int m1[][] = {
				{0,2,1,0,0},
				{5,0,0,0,0},
				{0,0,0,0,0},
				{0,0,0,0,0},
				{0,0,0,0,0}
		};
		
		int m2[][] = {
				{0,0},
				{1,0}				
//				{0,0,0}
		};
		

		int[] output = answer(m2);
		System.out.println(Arrays.toString(output));
	}

	public static int[] answer(int[][] m) { 

        // Your code goes here.
        
        double[][] orignal = generate2DArrayDouble(m);
		
		int denominaterCount = 0;
		ArrayList<Integer> nonTerminatedList = new ArrayList<Integer>();
		ArrayList<Integer> terminatedList = new ArrayList<Integer>();
		int[] denominater = new int[m.length];

		for (int row = 0; row < m.length; row++) {
			int sum = 0;
			for (int column = 0; column < m[0].length; column++) {
				sum += m[row][column];
			}
			if(row == 0 && sum == 0){
//				int[] finalArray = new int[4];
//				finalArray[3] = 1;
				return new int[1];
			}
			if (sum > 0) {
				nonTerminatedList.add(row);
				denominater[denominaterCount++] = sum;
			} else {
				terminatedList.add(row);
			}
		}

//		ArrayList<ArrayList<Fraction>> Q = new ArrayList<ArrayList<Fraction>>();
		
		double[][] Q = new double[nonTerminatedList.size()][nonTerminatedList.size()];
		double[][] I = new double[nonTerminatedList.size()][nonTerminatedList.size()];
		for (int i = 0; i < nonTerminatedList.size(); i++) {
			for (int j = 0; j < nonTerminatedList.size(); j++) {
				double temp = orignal[nonTerminatedList.get(i)][nonTerminatedList.get(j)];
				Q[i][j] = temp/(double)denominater[i];				
				if(i == j)
					I[i][j] = 1;
				else
					I[i][j] = 0;
			}
		}
		
		Matrix IObj = new Matrix(I);
		Matrix QObj = new Matrix(Q);
		Matrix IsubstractQObj = MatrixMathematics.subtract(IObj, QObj);
		
		double[][] Isubstract = IsubstractQObj.getValues();

		//print I-Q
//		System.out.println(Arrays.deepToString(Isubstract));
		
		Matrix FObj = MatrixMathematics.inverse(IsubstractQObj);
		double[][] F = FObj.getValues();
		
		//print F
//		System.out.println(Arrays.deepToString(F));
		
		double[][] R = new double[nonTerminatedList.size()][terminatedList.size()];
		
		for(int i = 0; i < nonTerminatedList.size(); i++){
			for(int j = 0; j < terminatedList.size(); j++){
				R[i][j] = orignal[nonTerminatedList.get(i)][terminatedList.get(j)]/denominater[i];
			}
		}
		
		//print R
//		System.out.println(Arrays.deepToString(R));
		
		Matrix RObj = new Matrix(R);
		Matrix FRObj = MatrixMathematics.multiply(FObj, RObj);
		
		double[][] FR = FRObj.getValues();
		
		//print FR
//		System.out.println(Arrays.deepToString(FR));		
		
		int[] finalArrNumerator = new int[terminatedList.size()];
		int[] finalArrDenominator = new int[terminatedList.size()];
		
		for(int i = 0; i < terminatedList.size(); i++){
			
			int[] fraction = convertDecimalToFraction(FR[0][i]);
			finalArrNumerator[i] = fraction[0];
			finalArrDenominator[i] = fraction[1];
		}
		
		//Denominator
//		System.out.println(Arrays.toString(finalArrDenominator));
		//Numerator
//		System.out.println(Arrays.toString(finalArrNumerator));
				
		int lcm = lcm(finalArrDenominator);
		//print lcm
//		System.out.println(lcm);
		int[] finalArr = new int[terminatedList.size()+1];
		finalArr[terminatedList.size()] = lcm;
		for(int i = 0; i<terminatedList.size(); i++){
			int temp = lcm/finalArrDenominator[i];
			finalArr[i] = finalArrNumerator[i] * temp; 
		}
		
//		System.out.println(Arrays.toString(finalArr));
		return finalArr;
	}

	private static double[][] generate2DArrayDouble(int[][] m) {
		double[][] orignal = new double[m.length][m[0].length];
		for (int row = 0; row < m.length; row++) {			
			for (int column = 0; column < m[0].length; column++) {				
				orignal[row][column] = (double)m[row][column];
			}			
		}
		return orignal;
	}
	
	static private int[] convertDecimalToFraction(double x){
	    if (x < 0.0){
	        return convertDecimalToFraction(-x);
	    }
	    double tolerance = 1.0E-6;
	    double h1=1; double h2=0;
	    double k1=0; double k2=1;
	    double b = x;
	    do {
	        double a = Math.floor(b);
	        double aux = h1; h1 = a*h1+h2; h2 = aux;
	        aux = k1; k1 = a*k1+k2; k2 = aux;
	        b = 1/(b-a);
	    } while (Math.abs(x-h1/k1) > x*tolerance);
	    
	    int[] fraction = new int[2];
	    fraction[0] = (int)h1;
	    fraction[1] = (int)k1;
	    return fraction;
	}
	
	private static int gcd(int a, int b)
	{
	    while (b > 0)
	    {
	        int temp = b;
	        b = a % b; // % is remainder
	        a = temp;
	    }
	    return a;
	}

	private static int lcm(int a, int b)
	{
	    return a * (b / gcd(a, b));
	}

	private static int lcm(int[] input)
	{
	    int result = input[0];
	    for(int i = 1; i < input.length; i++) result = lcm(result, input[i]);
	    return result;
	}

}

class Matrix {

	private int nrows;
	private int ncols;
	private double[][] data;

	public Matrix(double[][] dat) {
		this.data = dat;
		this.nrows = dat.length;
		this.ncols = dat[0].length;
	}

	public Matrix(int nrow, int ncol) {
		this.nrows = nrow;
		this.ncols = ncol;
		data = new double[nrow][ncol];
	}

	public int getNrows() {
		return nrows;
	}

	public void setNrows(int nrows) {
		this.nrows = nrows;
	}

	public int getNcols() {
		return ncols;
	}

	public void setNcols(int ncols) {
		this.ncols = ncols;
	}

	public double[][] getValues() {
		return data;
	}

	public void setValues(double[][] values) {
		this.data = values;
	}

	public void setValueAt(int row, int col, double value) {
		data[row][col] = value;
	}

	public double getValueAt(int row, int col) {
		return data[row][col];
	}

	public boolean isSquare() {
		return nrows == ncols;
	}

	public int size() {
		if (isSquare())
			return nrows;
		return -1;
	}

	public Matrix multiplyByConstant(double constant) {
		Matrix mat = new Matrix(nrows, ncols);
		for (int i = 0; i < nrows; i++) {
			for (int j = 0; j < ncols; j++) {
				mat.setValueAt(i, j, data[i][j] * constant);
			}
		}
		return mat;
	}
	public Matrix insertColumnWithValue1() {
		Matrix X_ = new Matrix(this.getNrows(), this.getNcols()+1);
		for (int i=0;i<X_.getNrows();i++) {
			for (int j=0;j<X_.getNcols();j++) {
				if (j==0)
					X_.setValueAt(i, j, 1.0);
				else 
					X_.setValueAt(i, j, this.getValueAt(i, j-1));
				
			}
		}
		return X_;
	}
}

class MatrixMathematics {

	private MatrixMathematics(){}
	
	public static Matrix transpose(Matrix matrix) {
		Matrix transposedMatrix = new Matrix(matrix.getNcols(), matrix.getNrows());
		for (int i=0;i<matrix.getNrows();i++) {
			for (int j=0;j<matrix.getNcols();j++) {
				transposedMatrix.setValueAt(j, i, matrix.getValueAt(i, j));
			}
		}
		return transposedMatrix;
	}
	
	public static Matrix inverse(Matrix matrix){
		return (transpose(cofactor(matrix)).multiplyByConstant(1.0/determinant(matrix)));
	}
	
	public static double determinant(Matrix matrix){
		if (!matrix.isSquare())
		{}
		if (matrix.size() == 1){
			return matrix.getValueAt(0, 0);
		}
			
		if (matrix.size()==2) {
			return (matrix.getValueAt(0, 0) * matrix.getValueAt(1, 1)) - ( matrix.getValueAt(0, 1) * matrix.getValueAt(1, 0));
		}
		double sum = 0.0;
		for (int i=0; i<matrix.getNcols(); i++) {
			sum += changeSign(i) * matrix.getValueAt(0, i) * determinant(createSubMatrix(matrix, 0, i));
		}
		return sum;
	}

	private static int changeSign(int i) {
		if (i%2==0)
			return 1;
		return -1;
	}
	
	public static Matrix createSubMatrix(Matrix matrix, int excluding_row, int excluding_col) {
		Matrix mat = new Matrix(matrix.getNrows()-1, matrix.getNcols()-1);
		int r = -1;
		for (int i=0;i<matrix.getNrows();i++) {
			if (i==excluding_row)
				continue;
				r++;
				int c = -1;
			for (int j=0;j<matrix.getNcols();j++) {
				if (j==excluding_col)
					continue;
				mat.setValueAt(r, ++c, matrix.getValueAt(i, j));
			}
		}
		return mat;
	}
	
	public static Matrix cofactor(Matrix matrix) {
		Matrix mat = new Matrix(matrix.getNrows(), matrix.getNcols());
		for (int i=0;i<matrix.getNrows();i++) {
			for (int j=0; j<matrix.getNcols();j++) {
				mat.setValueAt(i, j, changeSign(i) * changeSign(j) * determinant(createSubMatrix(matrix, i, j)));
			}
		}
		
		return mat;
	}
	
	public static Matrix add(Matrix matrix1, Matrix matrix2){
		if (matrix1.getNcols() != matrix2.getNcols() || matrix1.getNrows() != matrix2.getNrows())
		{}
		Matrix sumMatrix = new Matrix(matrix1.getNrows(), matrix1.getNcols());
		for (int i=0; i<matrix1.getNrows();i++) {
			for (int j=0;j<matrix1.getNcols();j++) 
				sumMatrix.setValueAt(i, j, matrix1.getValueAt(i, j) + matrix2.getValueAt(i,j));
			
		}
		return sumMatrix;
	}
	
	public static Matrix subtract(Matrix matrix1, Matrix matrix2) {
		return add(matrix1,matrix2.multiplyByConstant(-1));
	}
	
	public static Matrix multiply(Matrix matrix1, Matrix matrix2)  {
		Matrix multipliedMatrix = new Matrix(matrix1.getNrows(), matrix2.getNcols());
		
		for (int i=0;i<multipliedMatrix.getNrows();i++) {
			for (int j=0;j<multipliedMatrix.getNcols();j++) {
				double sum = 0.0;
				for (int k=0;k<matrix1.getNcols();k++) {
					sum += matrix1.getValueAt(i, k) * matrix2.getValueAt(k, j);
				}
				multipliedMatrix.setValueAt(i, j, sum);
			}
		}
		return multipliedMatrix;
	}
}

