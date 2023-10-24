package coding.mentor.be5;

public class LongestSameString {
	
	public static void main(String args[]) {
		String[] strings = {"flower", "flow", "flight"};
		int shortestStringIndex = getTheShortestStringIndex(strings);
		String res = getLongestSameString(strings, shortestStringIndex);
		System.out.println(res);
	}
	
	public static int getTheShortestStringIndex(String[] strings) {
		
		int minLength = strings[0].length();
		int shortestStringIndex = 0;
		
		for (int i = 1; i < strings.length; i++) {
			if (strings[i].length() < minLength) {
				minLength = strings[i].length();
				shortestStringIndex = i;
			}
		}
		return shortestStringIndex;
	}
	
	public static String getLongestSameString(String[] strings, int shortestStringIndex) {

		String sameString = "";
		
		for (int i = 0; i < strings[shortestStringIndex].length(); i++) { // number of operations: length of the smallest string
			
			int j = 0;
			int count = 0;
			
			while (j < strings.length) { // number of operations: number of strings
				
				if (j == shortestStringIndex) {
					j += 1;
					continue;
				}
						
				if (strings[shortestStringIndex].charAt(i) != strings[j].charAt(i)) {
					return sameString;
				} else {
					count += 1;
				}
				
				if (count == strings.length - 1) {
					sameString += strings[shortestStringIndex].charAt(i);
				}
				
				j += 1;
			}
		}
		
		return sameString;
	}
	
}
