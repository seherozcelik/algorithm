package codility;

public class PermMissingElem {

	public static void main(String[] args) {
		PermMissingElem pme = new PermMissingElem();
		int[] A = { 2, 3, 1, 5 };
		System.out.println(pme.solution(A));
	}

	public int solution(int[] A) {
		long arryL = A.length + 1;
		long sum = 0;
		for (int i : A) {
			sum += i;
		}
		return (int) (((arryL * (arryL + 1)) / 2) - sum);
	}
}
