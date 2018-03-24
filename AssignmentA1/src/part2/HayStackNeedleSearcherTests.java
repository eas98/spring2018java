package part2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HayStackNeedleSearcherTests {

	@Test
	void testNullSubstringWithNullSearchSpace() {
		HayStackNeedleSearcher searcher = new HayStackNeedleSearcher(null);
		int nFrequency = searcher.findFrequency(null);
		assertEquals(nFrequency,0);
	}
	@Test
	void testEmptySubstringWithNullSearchSpace() {
		HayStackNeedleSearcher searcher = new HayStackNeedleSearcher(null);
		int nFrequency = searcher.findFrequency("");
		assertEquals(nFrequency,0);
	}

	@Test
	void testNullSubstringWithEmptySearchSpace() {
		HayStackNeedleSearcher searcher = new HayStackNeedleSearcher("");
		int nFrequency = searcher.findFrequency(null);
		assertEquals(nFrequency,0);
	}
	@Test
	void testEmptySubstringWithEmptySearchSpace() {
		HayStackNeedleSearcher searcher = new HayStackNeedleSearcher("");
		int nFrequency = searcher.findFrequency("");
		assertEquals(nFrequency,1);
	}
	@Test
	void testEmptySubstringWithFullSearchSpace() {
		HayStackNeedleSearcher searcher = new HayStackNeedleSearcher("searchSpace");
		int nFrequency = searcher.findFrequency("");
		assertEquals(nFrequency,11);
	}
	@Test
	void testUpperCaseSubstringWithFullSearchSpace() {
		HayStackNeedleSearcher searcher = new HayStackNeedleSearcher("searchSpace");
		int nFrequency = searcher.findFrequency("A");
		assertEquals(nFrequency,2);
	}
	@Test
	void testLowerCaseSubstringWithFullSearchSpace() {
		HayStackNeedleSearcher searcher = new HayStackNeedleSearcher("seArchSpace");
		int nFrequency = searcher.findFrequency("A");
		assertEquals(nFrequency,2);
	}
}
