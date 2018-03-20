package part3;

import java.io.PrintStream;
import java.util.Random; 

public class Matrix {
	Integer m_rows; 
	Integer m_cols;
	Integer [][] m_data;
	public Matrix(Integer n, Integer m) {
		m_rows = n;
		m_cols = m;
		m_data = new Integer [n][m]; 
	}
	public Matrix(MatrixDimension dimension) {
		this(dimension.getRows(),dimension.getCols());
	}
	 
	
	public void generate() {
		 Random rand = new Random();
		 for(int i=0;i<m_rows;i++) {
			 for(int j=0;j<m_cols;j++) {
				 Integer data = rand.nextInt(100);
				 m_data[i][j] = data;
			 } 
		 }
	}
	public Matrix add(Matrix right) throws MatrixDimensionException {
		boolean equalDemensions = 
				this.m_cols == right.m_cols && 
				this.m_rows == right.m_rows;
		if(!equalDemensions) {
			throw new MatrixDimensionException("Matrices being addded should have equal dimensions");
		}
		Matrix result = new Matrix(m_rows, m_cols);
		for(int i=0;i<m_rows;i++) {
			for(int j=0;j<m_cols;j++) {
				result.m_data[i][j] = m_data[i][j] + right.m_data [i][j];
			}
		}
		return result;
	}
	public Matrix multiply(Matrix right) throws MatrixDimensionException {
		boolean multipliable = m_cols == right.m_rows;
		if(!multipliable) {
			throw new MatrixDimensionException("Number of column in left Matrix has to equal number of rows in right Matrix");
		}
		Matrix result = new Matrix(m_rows, right.m_cols);
		for(int i=0;i<m_rows;i++) {
			int cellValue = 0;
			for(int j=0;j<right.m_cols;j++) {
				for(int ii=0;ii<m_rows;ii++) {
					cellValue += m_data[i][ii] * right.m_data[j][ii];	
				}
				result.m_data[i][j] = cellValue;
			}
		}
		return result;
	}
	
	public void print() {
		print(System.out);
	}
	public void print(PrintStream stream) {
		stream.println(" __          __ ");
		for(int i = 0; i< m_rows;i++ ) {
			stream.print("|");
			for(int j = 0; j< m_cols;j++ ) {
				stream.print("  ");
				stream.print(String.format("%03d", m_data[i][j]));
			}
			stream.println("  |");
		}
		stream.println(" __          __ ");
	}
}
