package chapter_1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ChapterOneTest {

	@Test
	void detectPermutation() {
		String a = "create";
		String b = "etaerc";
		assertTrue(Solution.isPermutation(a, b), "'create' is a permutation of 'etaerc'");
		
		String c = "NOise";
		String d = "sEIno";
		assertTrue(Solution.isPermutation(c, d), "'NOise' is a permutation of 'sEIno'");
		
		String e = "everything";
		String f = "not";
		assertFalse(Solution.isPermutation(e, f), "'everything' is not a permutation of 'not'");
		
		String g = "number";
		String h = "triage";
		assertFalse(Solution.isPermutation(g, h), "'number' is not a permutation of 'triage'");
	}
	
	@Test
	void escapeWhitespace() {
		String pre1 = "use screener questions       ";
		String post1 = "use%20screener%20questions";
		
		String test1 = Solution.escapeWhitespace(pre1, 22);
		
		int compare1 = post1.compareTo(test1);
		assertEquals(compare1, 0, pre1 + " escapes to " + post1);
		
		String pre2 = "    that is how they found ";
		String post2 = "that%20is%20how%20they%20found";
		
		String test2 = Solution.escapeWhitespace(pre2, 22);
		
		int compare2 = post2.compareTo(test2);
		assertEquals(compare2, 0, pre2 + " escapes to " + post2);
		
		assertNotEquals(post2.compareTo(test1), 0, "These strings are not the same");
		
	}
	
	@Test
	void oneAway() {
		assertTrue(Solution.oneAway("pale", "ple"));
		assertTrue(Solution.oneAway("pales", "pale"));
		assertTrue(Solution.oneAway("pale", "bale"));
		assertFalse(Solution.oneAway("pale", "bake"));
	}
	
	@Test
	void stringCompression() {
		String test1 = "aabcccccaaa";
		assertEquals(Solution.compressString(test1).compareTo("a2b1c5a3"), 0);
		
		String test2 = "abcde";
		assertEquals(Solution.compressString(test2).compareTo(test2), 0);
		
		String test3 = "aabbcc";
		assertEquals(Solution.compressString(test3).compareTo(test3), 0);
	}

}
