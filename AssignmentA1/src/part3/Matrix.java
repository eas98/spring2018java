package part3;

import java.io.PrintStream;
import java.util.Random; 

public class Matrix {
	int m_rows; 
	int m_cols;
	int [][] m_data;
	public Matrix(Integer n, Integer m) {
		m_rows = n;
		m_cols = m;
		m_data = new int[n][m]; 
	}
	public Matrix(MatrixDimension dimension) {
		this(dimension.getRows(),dimension.getCols());
	}
	public Matrix(int[][] srcMatrixData) {
		this(srcMatrixData.length,srcMatrixData[0].length);
		for(int i=0;i<m_rows;i++) {
			for(int j=0;j<m_cols;j++) {
				m_data[i][j] = srcMatrixData[i][j];
			}	
		}
	}
	
	public int at(int i, int j) {
		return m_data[i][j];
	}
	
	public boolean equals(Matrix right) {
		if(m_data.length == right.m_data.length) {
			if(m_data[0].length == right.m_data[0].length) {
				for(int i=0; i< m_rows;i++) {
					for(int j=0; j< m_cols;j++) {
						if(m_data[i][j] != right.m_data[i][j]) {
							return false;
						}					
					}
				}
				return true;
			}
		}
		return false;
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
			throw new MatrixDimensionException("Number of rows in left Matrix has to equal number of columns in right Matrix");
		}
		Matrix result = new Matrix(m_rows, right.m_cols);
		for(int i=0;i<m_rows;i++) {
			
			for(int j=0;j<right.m_cols;j++) {
				int cellValue = 0;
				for(int ii=0;ii<right.m_rows;ii++) {
					cellValue += m_data[i][ii] * right.m_data[ii][j];	
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
