package part2;

public class HayStack implements SubstringFrequencySearcher{
	String m_searchSpace;
	HayStack(String searchSpace) {
		
	}
	
	@Override
	public int findFrequency(String subString) {
		if(subString == null && m_searchSpace == null)
			return 1;
		if(subString.isEmpty() && m_searchSpace.isEmpty())
			return 1;
		
		if(m_searchSpace != null) {
			int nFrequency = 0;
			for(int i =0;i<m_searchSpace.length();i++) {
				m_searchSpace
			}
		}
		return 0;
	}
}
