package part3;

public class Matrix {
	Integer m_n; 
	Integer m_m;
	Integer [][] m_data;
	public Matrix(Integer n, Integer m) {
		m_n = n;
		m_m = m;
		m_data = new Integer [n][m]; 
	}
	
	public Matrix Add(Matrix left, Matrix right) throws MatrixDimensionException {
		boolean equalDemensions = 
				left.m_m == right.m_m && 
				left.m_n == right.m_n;
		if(!equalDemensions) {
			throw new MatrixDimensionException("Matrices being addded should have equal dimensions");
		}
		Matrix result = new Matrix(left.m_n, left.m_m);
		return result;
	}
}
