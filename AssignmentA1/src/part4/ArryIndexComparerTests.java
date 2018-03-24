package part4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class ArryIndexComparerTests {

	@Test
	void testArrayIndexComparerWithStrings() {
		String [] strings = {"aa","BB","cc","CC","1","2"};
		Integer[] indexPositions = ArrayHelpers.buildAndInitArrayWithIndexes(strings.length);
		ArrayIndexComparer<String> comparer = new ArrayIndexComparer<String>(strings);
		Arrays.sort(indexPositions,comparer);
		Integer[] expectedIndexes = {4,5,1,3,0,2};
	 	assertArrayEquals(expectedIndexes,indexPositions);
	}

	@Test
	void testArrayIndexComparerWithInteger() {
		Integer [] ints = {10,9,8,7,6,5,4,3,2,1,-10,-9,-8,-7,-1};
		Integer[] indexPositions = ArrayHelpers.buildAndInitArrayWithIndexes(ints.length);
		ArrayIndexComparer<Integer> comparer = new ArrayIndexComparer<Integer>(ints);
		Arrays.sort(indexPositions,comparer);
		Integer[] expectedIndexes = {10,11,12,13,14,9,8,7,6,5,4,3,2,1,0};
	 	assertArrayEquals(expectedIndexes,indexPositions);
	}

	@Test
	void testArrayIndexComparerWithReals() {
		Double [] reals = {10.10,9.9,8.8,7.7,6.6,5.5,4.4,3.3,2.2,1.1,-10.10,-9.9,-8.8,-7.7,-1.1};
		Integer[] indexPositions = ArrayHelpers.buildAndInitArrayWithIndexes(reals.length);
		ArrayIndexComparer<Double> comparer = new ArrayIndexComparer<Double>(reals);
		Arrays.sort(indexPositions,comparer);
		Integer[] expectedIndexes = {10,11,12,13,14,9,8,7,6,5,4,3,2,1,0};
	 	assertArrayEquals(expectedIndexes,indexPositions);
	}
}
