package part3;

import java.util.Scanner;

public class Part3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		    	 Matrix matrix = new Matrix(dimension);
		    	 matrix.generate();
		    	 matrix.print();
			 } else {
				System.out.print("Invalid Matrix Defenition File"); 
			 }
		} while(dimension == null);
		
	    
	}

}
