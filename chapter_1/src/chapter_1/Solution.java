package chapter_1;

public class Solution {
	
	public static final char WHITESPACE = ' ';
	
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
	
	public static String escapeWhitespace(String a, int size) {
		int whitespace = 0;
		int i = 0;
		boolean charFound = false;
		while (i < a.length()) {
			if (i < a.length() && a.charAt(i) == WHITESPACE) {
				if (charFound) ++whitespace;
				while (i < a.length() && a.charAt(i) == WHITESPACE) {
					++i;
				}
				if(i == a.length()) {
					--whitespace;
				}
			}
			
			if (!charFound) charFound = true;
			
			while (i < a.length() && a.charAt(i) != WHITESPACE) {
				++i;
			}
		}
		
		char[] str = new char[size + 2 * whitespace];
		--i;
		int j = str.length - 1;
		
		while (i >= 0 && a.charAt(i) == WHITESPACE) {
			--i;
		}
		
		while (i >= 0 && j >= 0) {
			if (a.charAt(i) == WHITESPACE) {
				str[j] = '0';
				str[j - 1] = '2';
				str[j - 2] = '%';
				j -= 3;
				while (i >= 0 && a.charAt(i) == WHITESPACE) {
					--i;
				}
			}
			while (i >= 0 && a.charAt(i) != WHITESPACE) {
				str[j] = a.charAt(i);
				--j;
				--i;
			}
		}
		
		return new String(str);
	}
	
	public static boolean oneAway(String a, String b) {
		if(Math.abs(a.length() - b.length()) == 1) {
			int i = 0, j = 0;
			String lng = a.length() < b.length() ? b : a;
			String shr = a.length() < b.length() ? a : b;
			while(i < lng.length()) {
				if(j == shr.length() || lng.charAt(i) != shr.charAt(j)) {
					++i;
					if(Math.abs(i - j) > 1) {
						return false;
					}
				} else {
					++i;
					++j;
				}
			}
			return true;
		}
		if(a.length() == b.length()) {
			if(a.compareTo(b) == 0) {
				return true;
			}
			boolean charChanged = false;
			for(int i = 0; i < a.length(); ++i) {
				if(a.charAt(i) != b.charAt(i)) {
					if(!charChanged) {
						charChanged = true;
					} else {
						return false;
					}
				}
			}
			return true;
		}
		return false;
		
	}
	
	public static String compressString(String str) {
		int compressedSize = 2;
		for(int i = 1; i < str.length(); ++i) {
			if(str.charAt(i) != str.charAt(i - 1)) {
				compressedSize += 2;
			}
		}
		
		System.out.println(compressedSize);
		
		if(compressedSize >= str.length()) {
			return str;
		}
		
		char[] compressed = new char[compressedSize];
		
		int count = 1;
		int index = 1;
		compressed[0] = str.charAt(0);
		
		for(int i = 1; i < str.length(); ++i) {
			if(str.charAt(i) == str.charAt(i - 1)) {
				++count;
			} else {
				compressed[index] = Character.forDigit(count, 10);
				compressed[index + 1] = str.charAt(i);
				index += 2;
				count = 1;
			}
		}
		
		compressed[compressedSize - 1] = Character.forDigit(count,  10);
		
		return new String(compressed);
	}
	
}
