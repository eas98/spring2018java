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
		
		while(searchSpace !=null && subString != null) {
			System.out.print("search space string:");
			Scanner scanner = new Scanner(System.in);
		    String largeString = scanner.nextLine();
		    System.out.print("search string:");
		}
			
		SubstringFrequencySearcher searcher = new HayStack(searchSpace);
		int nFrequency = searcher.findFrequency(subString);
		System.out.println("Found %d instances",nFrequency);
	}

}
