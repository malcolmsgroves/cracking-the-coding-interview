package chapter_1;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String a = in.nextLine();
		String b = in.nextLine();
		in.close();
		boolean isPerm = Permutation.isPermutation(a, b);
		if(isPerm) {
			System.out.println("You've got a permutation!");
		} else {
			System.out.println("Not a permutation");
		}

	}

}
