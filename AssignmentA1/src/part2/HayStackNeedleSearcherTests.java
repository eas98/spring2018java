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
	@Test
	void testEarthQuakeWithSearchSpace() {
		String searchSpace = "The western American city of San Francisco, California suffered a huge earthquake on April 18th, 1906."+
		"More than three thousand people are known to have died. The true number of dead will never be known. Two"+
		"hundred fifty thousand people lost their homes. Just a few hours after the terrible earthquake, a magazine named"+
		"Collier's sent a telegraph message to the famous American writer Jack London. They asked Mr. London to go to"+
		"San Francisco and report about what he saw.";
		HayStackNeedleSearcher searcher = new HayStackNeedleSearcher(searchSpace);
		int nFrequency = searcher.findFrequency("earthquake");
		assertEquals(nFrequency,2);
	}
	@Test
	void testSanFranciscoWithSearchSpace() {
		String searchSpace = "The western American city of San Francisco, California suffered a huge earthquake on April 18th, 1906."+
		"More than three thousand people are known to have died. The true number of dead will never be known. Two"+
		"hundred fifty thousand people lost their homes. Just a few hours after the terrible earthquake, a magazine named"+
		"Collier's sent a telegraph message to the famous American writer Jack London. They asked Mr. London to go to"+
		"San Francisco and report about what he saw.";
		HayStackNeedleSearcher searcher = new HayStackNeedleSearcher(searchSpace);
		int nFrequency = searcher.findFrequency("San Francisco");
		assertEquals(nFrequency,2);
	}
}
