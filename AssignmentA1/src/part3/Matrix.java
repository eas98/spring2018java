package part3;

import java.util.Random; 

public class Matrix {
	Integer m_n; 
	Integer m_m;
	Integer [][] m_data;
	public Matrix(Integer n, Integer m) {
		m_n = n;
		m_m = m;
		m_data = new Integer [n][m]; 
	}
	
	public void generate() {
		 Random rand = new Random();
		 for(int i=0;i<m_n;i++) {
			 for(int j=0;j<m_m;j++) {
				 Integer data = rand.nextInt(100);
				 m_data[i][j] = data;
			 } 
		 }
	}
	public Matrix add(Matrix left, Matrix right) throws MatrixDimensionException {
		boolean equalDemensions = 
				left.m_m == right.m_m && 
				left.m_n == right.m_n;
		if(!equalDemensions) {
			throw new MatrixDimensionException("Matrices being addded should have equal dimensions");
		}
		Matrix result = new Matrix(left.m_n, left.m_m);
		for(int i=0;i<left.m_n;i++) {
			for(int j=0;j<left.m_m;j++) {
				result.m_data[i][j] = left.m_data[i][j] + right.m_data [i][j];
			}
		}
		return result;
	}
	public Matrix multiply(Matrix left, Matrix right) throws MatrixDimensionException {
		boolean multipliable = left.m_m == right.m_n;
		if(!multipliable) {
			throw new MatrixDimensionException("Number of column in left Matrix has to equal number of rows in right Matrix");
		}
		Matrix result = new Matrix(left.m_n, right.m_m);
		for(int i=0;i<left.m_n;i++) {
			int cellValue = 0;
			for(int j=0;j<right.m_m;j++) {
				for(int ii=0;ii<left.m_n;ii++) {
					cellValue += left.m_data[i][ii] * right.m_data[j][ii];	
				}
				result.m_data[i][j] = cellValue;
			}
		}
		return result;
	}
}
