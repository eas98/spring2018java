package part3;
import java.lang.Exception; 


@SuppressWarnings("serial")
public class MatrixDimensionException extends Exception {
	public MatrixDimensionException(String message) {
		super(message);
	}
}
