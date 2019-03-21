package codility;

import java.util.HashSet;

public class OddOccurencesInArray {

	public static void main(String[] args) {
		OddOccurencesInArray occr = new OddOccurencesInArray();
		int[] A = { 2, 3, 5, 3, 2, 7, 7, 8, 5, 9, 8 };
		System.out.println(occr.solution(A));
	}

	public int solution(int[] A) {
		HashSet<Integer> mySet = new HashSet<Integer>();
		for (int i : A) {
			if (mySet.contains(i)) {
				mySet.remove(i);
			} else {
				mySet.add(i);
			}
		}
		for (Integer sayi : mySet) {
			return sayi;
		}
		return 0;
	}

}
