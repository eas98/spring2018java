package part3;

import java.util.Scanner;

public class Part3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MatrixDimension dimension = null;
		System.out.println("part3");
		do {
			System.out.print("Enter Matrix Defenition (Default Matrix.txt)");
			System.out.print("file:matrix.txt");
			Scanner scanner = new Scanner(System.in);
		    String input = scanner.nextLine();
		    scanner.close();
		    
			FileBasedMatrixDimensionProvider provider = new FileBasedMatrixDimensionProvider(input);
			dimension = provider.getDimension();	
		     if(dimension == null) {
			    	
			 } else {
				System.out.print("Invalid Matrix Defenition File"); 
			 }
		} while(dimension == null);
		
	    
	}

}
