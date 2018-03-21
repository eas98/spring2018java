package part3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

class MatrixTests {

	@Test
	void testGenerate2x2() {
		Matrix matrix = new Matrix(2,2);
		matrix.generate();
		for(int i=0;i<2;i++) {
			for(int j=0;j<2;j++) {
				int cellValue = matrix.at(i,j);
				assertTrue(cellValue>=0 && cellValue< 100);
			}	
		}
	}
	
	@Test
	void testGenerate3x2() {
		Matrix matrix = new Matrix(3,2);
		matrix.generate();
		for(int i=0;i<3;i++) {
			for(int j=0;j<2;j++) {
				int cellValue = matrix.at(i,j);
				assertTrue(cellValue>=0 && cellValue< 100);
			}	
		}
	}

	@Test
	void testAdd3X3By3X3() throws MatrixDimensionException{
		int[][] matrixLeftData = {
				{1,2,3},
				{4,5,6},
				{7,8,9},
			};
			int[][] matrixRightData = {
					{11,22,33},
					{44,55,66},
					{77,88,99},
				};
			Matrix matrixLeft = new Matrix(matrixLeftData);
			Matrix matrixRight = new Matrix(matrixRightData);
			Matrix matrixResult = matrixLeft.add(matrixRight);
			
			int[][] matrixExpectedResultData = {
					{12,24,36},
					{48,60,72},
					{84,96,108},
				};
			Matrix matrixExpectedResult = new Matrix(matrixExpectedResultData);
			assertTrue(matrixExpectedResult.equals(matrixResult));
	}
	
	@Test
	void testAdd3X3by2X3ShouldThrowException() {
		assertThrows(MatrixDimensionException.class, ()->{
			int[][] matrixLeftData = {
					{1,2,3},
					{4,5,6},
					{7,8,9},
				};
			int[][] matrixRightData = {
					{11,22,33},
					{44,55,66},
				};
			Matrix matrixLeft = new Matrix(matrixLeftData);
			Matrix matrixRight = new Matrix(matrixRightData);
			matrixLeft.add(matrixRight);
		
		});
	}
	@Test
	void testAdd2X2By2X2() throws MatrixDimensionException{
		int[][] matrixLeftData = {
				{11,12},
				{21,22},
			};
			int[][] matrixRightData = {
					{111,112},
					{121,122},
				};
			Matrix matrixLeft = new Matrix(matrixLeftData);
			Matrix matrixRight = new Matrix(matrixRightData);
			Matrix matrixResult = matrixLeft.add(matrixRight);
			
			int[][] matrixExpectedResultData = {
					{122,124},
					{142,144},
				};
			Matrix matrixExpectedResult = new Matrix(matrixExpectedResultData);
			assertTrue(matrixExpectedResult.equals(matrixResult));
	}

	@Test
	void testMultiply3X3By3X3() throws MatrixDimensionException{		
		int[][] matrixLeftData = {
				{14,18,84},
				{26,41,57},
				{86,34,32},
			};
			int[][] matrixRightData = {
					{47,  19,  63},
					{63,  46,  63},
					{30,  50,  1},
				};
			Matrix matrixLeft = new Matrix(matrixLeftData);
			Matrix matrixRight = new Matrix(matrixRightData);
			Matrix matrixResult = matrixLeft.multiply(matrixRight);
			
			int[][] matrixExpectedResultData = {
					{4312,5294,2100},
					{5515,5230,4278},
					{7144,4798,7592},
				};
			Matrix matrixExpectedResult = new Matrix(matrixExpectedResultData);
			boolean areSame = matrixExpectedResult.equals(matrixResult);
			System.out.println("Expected");
			matrixExpectedResult.print(System.out);
			System.out.println("Actual");
			matrixResult.print(System.out); 
			assertTrue(areSame);
	}
	
	@Test
	void testMultiply2X3By3X2() throws MatrixDimensionException{		
		int[][] matrixLeftData = {
				{1,2,3},
				{4,5,6},
			};
			int[][] matrixRightData = {
					{7,  8 },
					{9,  10},
					{11, 12},
				};
			Matrix matrixLeft = new Matrix(matrixLeftData);
			Matrix matrixRight = new Matrix(matrixRightData);
			Matrix matrixResult = matrixLeft.multiply(matrixRight);
			
			int[][] matrixExpectedResultData = {
					{58,64},
					{139,154},
				};
			Matrix matrixExpectedResult = new Matrix(matrixExpectedResultData);
			boolean areSame = matrixExpectedResult.equals(matrixResult);
			System.out.println("Expected");
			matrixExpectedResult.print(System.out);
			System.out.println("Actual");
			matrixResult.print(System.out); 
			assertTrue(areSame);
	}

	@Test
	void testMultiply1X3By3X4() throws MatrixDimensionException{		
		int[][] matrixLeftData = {
				{3,4,2},
			};
			int[][] matrixRightData = {
					{13,  9, 7, 15 },
					{8,  7, 4, 6 },
					{6,  4, 0, 3 },
				};
			Matrix matrixLeft = new Matrix(matrixLeftData);
			Matrix matrixRight = new Matrix(matrixRightData);
			Matrix matrixResult = matrixLeft.multiply(matrixRight);
			
			int[][] matrixExpectedResultData = {
					{83,63,37,75},
				};
			Matrix matrixExpectedResult = new Matrix(matrixExpectedResultData);
			boolean areSame = matrixExpectedResult.equals(matrixResult);
			System.out.println("Expected");
			matrixExpectedResult.print(System.out);
			System.out.println("Actual");
			matrixResult.print(System.out); 
			assertTrue(areSame);
	}

	@Test
	void testMultiply1X4By3X4ShouldThrowException() {
		assertThrows(MatrixDimensionException.class, ()->{
			int[][] matrixLeftData = {
					{3,4,2,1},
				};
			int[][] matrixRightData = {
					{13,  9, 7, 15 },
					{8,  7, 4, 6 },
					{6,  4, 0, 3 },
				};
			Matrix matrixLeft = new Matrix(matrixLeftData);
			Matrix matrixRight = new Matrix(matrixRightData);
			matrixLeft.multiply(matrixRight);

		});
		
	}
	
}
