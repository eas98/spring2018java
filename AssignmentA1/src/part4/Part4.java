package part4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Part4 {

	public static void main(String[] args) {
		System.out.println("part4");
				
		Integer[] unsortedData = null;
		if(args.length == 1) {
			String [] strNumbers = args[0].split(",");
			
			int index=0;
			unsortedData = new Integer[strNumbers.length];
			for(String strNumber:strNumbers) {
				int n = Integer.parseInt(strNumber);
				unsortedData[index++] = n;
			}
		}
		if(unsortedData == null) {
			ArrayList<Integer> listNumbersInput = new ArrayList<Integer>();
			System.out.println("enter numbers on separate line:");
			Scanner scanner = new Scanner(System.in);
			while(true) {
				String strNumber = scanner.nextLine();
				if(strNumber.isEmpty()) {
					break;
				}
				Integer nData = Integer.parseInt(strNumber);
				listNumbersInput.add(nData);
			}
			scanner.close();
			unsortedData = new Integer[listNumbersInput.size()];
			unsortedData = listNumbersInput.toArray(unsortedData);
		}

		Integer[] indexPositions = ArrayHelpers.buildAndInitArrayWithIndexes(unsortedData.length);
		String strCommaSeparatedVals = ArrayHelpers.convertDataWithIndexsToString(unsortedData,indexPositions);
		System.out.printf("Unsorted Array:%s",strCommaSeparatedVals.toString());
		System.out.println();
		
		ArrayIndexComparer<Integer> indexComparer = new ArrayIndexComparer<Integer>(unsortedData);
		Arrays.sort(indexPositions,indexComparer);
		
		String strCommaSeparatedVals2 = ArrayHelpers.convertDataWithIndexsToString(unsortedData,indexPositions);
		System.out.printf("Sorted Array:%s",strCommaSeparatedVals2.toString());
		System.out.println();
		
		String strIndexes = ArrayHelpers.convertArrayToString(indexPositions);
		System.out.printf("Sorted Indexes:%s",strIndexes);
		System.out.println();
	}

}
