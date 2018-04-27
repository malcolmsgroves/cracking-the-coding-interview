package chapter_1;

public class Permutation {
	
	public static boolean isPermutation(String a, String b) {
		if(a.length() != b.length()) {
			return false;
		}
		String aLow = a.toLowerCase();
		String bLow = b.toLowerCase();
		
		int[] count = new int[26];
		for(int i = 0; i < aLow.length(); ++i) {
			int index = aLow.charAt(i) - 'a';
			if(index >= 0 && index < 26) {
				++count[index];
			}
		}
		for(int i = 0; i < bLow.length(); ++i) {
			int index = bLow.charAt(i) - 'a';
			if(index >= 0 && index < 26) {
				--count[index];
			}
			if(count[index] < 0) {
				return false;
			}
		}
		return true;
	}
}
