package part3;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
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
	
	private boolean doesFileExist(String fullFilePath) {
		File file = new File(fullFilePath);
		return file.exists();	
	}
	
	private Path getFullFilePath( ) {
		if(m_filePath == null || m_filePath.isEmpty())
			return null;
		File file = new File(m_filePath);
		if(file.isAbsolute())
			return Paths.get(m_filePath);
		
         String dir = System.getProperty("user.dir");
         return Paths.get(dir,m_filePath);        	
	}
	

	@Override
	public MatrixDimension getDimension() {
		
		int rows = 0;
		int cols = 0;
		// TODO Auto-generated method stub
		Path path = getFullFilePath();
		if(path == null)
			return null;
		if(!doesFileExist(path.toString())) {
			m_logger.warning(path.toString()+ " does not exist!");
			return null;
		}	
		
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
			if(cols > 0 && rows > 0 )
				return new MatrixDimension(rows,cols); 
		} catch(IOException e) {
			m_logger.warning("failed to read from file:"+m_filePath);
		}
		return null;
	}

}
