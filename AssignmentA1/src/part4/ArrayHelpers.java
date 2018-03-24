package part4;

public class ArrayHelpers {

	public static Integer[] buildAndInitArrayWithIndexes(int nSize)
    {
        Integer[] indexes = new Integer[nSize];
        for (int i = 0; i < nSize; i++)
        {
            indexes[i] = i;
        }
        return indexes;
    }
	
	public static <E> String convertDataWithIndexsToString(E[] data,Integer[] indexes) {
		StringBuilder builder = new StringBuilder();
		
		for(Integer index:indexes) {
			if(builder.length() != 0) {
				builder.append(',');	
			}
			int i = index.intValue();
			builder.append(data[i]);
		}
		return builder.toString();
	}
	
	public static <E> String convertArrayToString(E[] data) {
		StringBuilder builder = new StringBuilder();
		
		for(E element:data) {
			if(builder.length() != 0) {
				builder.append(',');	
			}
			builder.append(element.toString());
		}
		return builder.toString();
	}
}
