package part3;

import java.util.Scanner;
import java.util.logging.Logger;

public class Part3 {
	private static final Logger m_logger = Logger.getLogger(Part3.class.getName());
	public static void main(String[] args) {
		
		try {
			MatrixDimension dimension = null;
			System.out.println("part3");
			
			do {
				System.out.println("Enter Matrix Defenition (file:Matrix.txt)");
				System.out.print("file:");
				Scanner scanner = new Scanner(System.in);
			    String input = scanner.nextLine();
			    if(input == null || input.isEmpty())
			    	input = "matrix.txt";
			    scanner.close();
			    
				FileBasedMatrixDimensionProvider provider = new FileBasedMatrixDimensionProvider(input);
				dimension = provider.getDimension();
			     if(dimension != null) {
			    	 doMatrixOps(dimension);
				 } else {
					System.out.print("Invalid Matrix Defenition File"); 
				 }
			} while(dimension == null);
		} catch(Exception e) {
			m_logger.severe("Unhandled Exception:"+e.toString());
		}
	}
	
	private static void doMatrixOps(MatrixDimension dimension) throws MatrixDimensionException {
		System.out.format("Matrix Dimensions:%dX%d",dimension.getRows(),dimension.getCols());
		doMatrixAddition(dimension);
		doMatrixMultipication(dimension);
	}
	private static void doMatrixAddition(MatrixDimension dimension) throws MatrixDimensionException {
		System.out.println("---------------");
		System.out.println();
		System.out.println("Matrix1");
		Matrix matrix1 = new Matrix(dimension);
	   	matrix1.generate();
	   	matrix1.print();
	   	
	   	System.out.println("Matrix2");
	   	Matrix matrix2 = new Matrix(dimension);
	   	matrix2.generate();
	   	matrix2.print();	   		
	   	
	   	System.out.println("Matrix3=Matrix1+Matrix2");
	   	Matrix matrix3 = matrix1.add(matrix2);
	   	matrix3.print();
	   	System.out.println("---------------");
	}
	
	private static void doMatrixMultipication(MatrixDimension dimension) throws MatrixDimensionException {
		System.out.println("_______________");
		System.out.println();
		System.out.println("Matrix1");
		Matrix matrix1 = new Matrix(dimension);
	   	matrix1.generate();
	   	matrix1.print();
	   	
	   	System.out.println("Matrix2");
	   	Matrix matrix2 = new Matrix(dimension);
	   	matrix2.generate();
	   	matrix2.print();	   		
	   	
	   	System.out.println("Matrix3=Matrix1*Matrix2");
	   	Matrix matrix3 = matrix1.multiply(matrix2);
	   	matrix3.print();
	   	System.out.println("_______________");
	}
}
