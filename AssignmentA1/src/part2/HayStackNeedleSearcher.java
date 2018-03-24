package part2;

public class HayStackNeedleSearcher implements SubstringFrequencySearcher{
	String m_searchSpace;
	HayStackNeedleSearcher(String searchSpace) {
		m_searchSpace = searchSpace;
	}
	
	@Override
	public int findFrequency(String subString) {
		if(m_searchSpace == null)
			return 0;
		if(subString == null)
			return 0;
		if(subString.isEmpty() && m_searchSpace.isEmpty())
			return 1;
		if(subString.isEmpty())
			return m_searchSpace.length();
		
		if(m_searchSpace != null) {
			int nFrequency = 0;
			int nMatchedIndex = 0;
			for(int i=0;i<m_searchSpace.length();i++) {
				char ch = m_searchSpace.charAt(i);
				if(Character.toLowerCase(ch) == Character.toLowerCase(subString.charAt(nMatchedIndex))) {
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
