package chapter_1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ChapterOneTest {

	@Test
	void detectPermutation() {
		String a = "create";
		String b = "etaerc";
		assertTrue(Permutation.isPermutation(a, b), "'create' is a permutation of 'etaerc'");
		
		String c = "NOise";
		String d = "sEIno";
		assertTrue(Permutation.isPermutation(c, d), "'NOise' is a permutation of 'sEIno'");
		
		String e = "everything";
		String f = "not";
		assertFalse(Permutation.isPermutation(e, f), "'everything' is not a permutation of 'not'");
		
		String g = "number";
		String h = "triage";
		assertFalse(Permutation.isPermutation(g, h), "'number' is not a permutation of 'triage'");
	}

}
