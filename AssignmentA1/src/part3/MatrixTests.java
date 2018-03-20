package part3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

class MatrixTests {

	@Test
	void testGenerate() {
		Matrix matrix = new Matrix(3,3);
		matrix.generate();
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				int cellValue = matrix.at(i,j);
				assertTrue(cellValue>=0 && cellValue< 100);
			}	
		}
	}

	@Test
	void testAdd() {
		Assertions.assertThrows(MatrixDimensionException.class, () -> {
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
		    });
	}

	@Test
	void testMultiply() {
		Assertions.assertThrows(MatrixDimensionException.class, () -> {
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
						{4312,5294,1960},
						{5515,5230,4018},
						{7144,4798,6732},
					};
				Matrix matrixExpectedResult = new Matrix(matrixExpectedResultData);
				assertTrue(matrixExpectedResult.equals(matrixResult));
		    });
	}

}
