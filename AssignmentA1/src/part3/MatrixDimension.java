package part3;

public class MatrixDimension {
	final Integer m_rows; 
	final Integer m_cols;
	MatrixDimension(Integer rows,Integer cols) {
		m_rows = rows;
		m_cols = cols;
	}
	Integer getRows() {
		return m_rows;
	}
	Integer getCols() {
		return m_cols;
	}
}
