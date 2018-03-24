package part4;

import java.util.Comparator;

public class ArrayIndexComparer<E extends Comparable<E>> implements Comparator<Integer> {
	private final E[] m_data;

    public ArrayIndexComparer(E[] data)
    {
        this.m_data = data;
    }
    
    @Override
    public int compare(Integer indexLeft, Integer indexRight)
    {
    	if( indexLeft <0 ||
			indexRight <0 || 
			indexLeft >= m_data.length||
			indexRight >= m_data.length)
    		throw new IndexOutOfBoundsException("Invalid Indexes "+indexLeft.toString()+" "+indexRight.toString());
    	
    	if(m_data[indexLeft.intValue()] == null && m_data[indexRight.intValue()] == null)
    		return 0;
    	return m_data[indexLeft.intValue()].compareTo(m_data[indexRight.intValue()]);
    }
}
