package part4;

import java.awt.List;
import java.util.ArrayList;
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
		if(unsortedData != null) {
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
			unsortedData = (Integer[])listNumbersInput.toArray();
		}
		ArraySorter sorter = new ArrayPositionRetainerSorter();
		sorter.sort(unsortedData);
		
	}

}
