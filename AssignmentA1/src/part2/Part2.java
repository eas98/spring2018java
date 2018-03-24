package part2;

import java.util.Scanner;

public class Part2 {

	public static void main(String[] args) {
		System.out.println("part2");
		String searchSpace = null;
		String subString = null;
		if(args.length == 2) {
			searchSpace =args[0];
			subString =args[1];
		}
		
		while(searchSpace ==null || subString == null) {
			System.out.print("hayStack string:");
			Scanner scanner = new Scanner(System.in);
		    searchSpace = scanner.nextLine();
		    System.out.println("needle string:");
		    subString = scanner.nextLine();
		    scanner.close();
		    System.out.println();
		}
		
		long nStart = System.currentTimeMillis();
		SubstringFrequencySearcher searcher = new HayStackNeedleSearcher(searchSpace);
		int nFrequency = searcher.findFrequency(subString);
		long nEnd = System.currentTimeMillis();
		long nDuration = nEnd - nStart;
		System.out.printf("Found %d instances, It took %d miliseconds.",nFrequency,nDuration);
		System.out.println();
	}

}
