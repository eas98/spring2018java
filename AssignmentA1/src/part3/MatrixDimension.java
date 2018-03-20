package part3;

public class MatrixDimension {
	final int m_rows; 
	final int m_cols;
	MatrixDimension(int rows,int cols) {
		m_rows = rows;
		m_cols = cols;
	}
	public int getRows() {
		return m_rows;
	}
	public int getCols() {
		return m_cols;
	}
}
