package part2;

public class HayStack implements SubstringFrequencySearcher{
	String m_searchSpace;
	HayStack(String searchSpace) {
		
	}
	
	@Override
	public int findFrequency(String subString) {
		if(subString == null && m_searchSpace == null)
			return 1;
		if(m_searchSpace == null)
			return 0;
		if(subString == null)
			return 0;
		if(subString.isEmpty() && m_searchSpace.isEmpty())
			return 1;
		if(!m_searchSpace.isEmpty())
			return m_searchSpace.length();
		
		if(m_searchSpace != null) {
			int nFrequency = 0;
			int nMatchedIndex = 0;
			for(int i=0;i<m_searchSpace.length();i++) {
				char ch = m_searchSpace.charAt(i);
				if(ch == subString.charAt(nMatchedIndex)) {
					nMatchedIndex++;
					if(subString.length() == nMatchedIndex) {
						nFrequency++;
						nMatchedIndex= 0;
					}
				} else {
					nMatchedIndex = 0;
				}
			}
			return nFrequency;
		}
		return 0;
	}
}
