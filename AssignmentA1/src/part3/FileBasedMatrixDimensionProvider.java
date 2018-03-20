package part3;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.logging.Logger;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileBasedMatrixDimensionProvider implements MatrixDimensionProvider{
	private static final Logger m_logger = Logger.getLogger(MatrixDimensionProvider.class.getName());
	String m_filePath;
	FileBasedMatrixDimensionProvider(String filepath) {
		m_filePath = filepath;
	}

	@Override
	public MatrixDimension getDimension() {
		MatrixDimension dimension = null;
		int rows = 0;
		int cols = 0;
		// TODO Auto-generated method stub
	    Path path = Paths.get(m_filePath);
		try {
			List<String> lines = Files.readAllLines(path);
			for(String line:lines) {
				String [] parts = line.split("\\=");
				Boolean isReadingColumn = false;
				Boolean isReadingRows = false;
				for(String part:parts) {
					if(isReadingColumn) {
						cols = Integer.parseInt(part.trim());
					}
					else if(isReadingRows) {
						rows = Integer.parseInt(part.trim());
					}
					if(part.trim().equalsIgnoreCase("columns")) {
						isReadingColumn = true;
					}
					else if(part.trim().equalsIgnoreCase("rows")) {
						isReadingRows = true;
					}
				}
				if(rows> 0 && cols > 0) {
					break;
				}
			}	
		} catch(IOException e) {
			m_logger.warning("failed to read from file:"+m_filePath);
		}
		return dimension;
	}

}
