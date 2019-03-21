package codility;

public class TapeEquilibrium {

	public static void main(String[] args) {
		TapeEquilibrium te = new TapeEquilibrium();
		int[] A = { 3, 1, 2, 4, 3 };
		System.out.println(te.solution(A));
	}

	public int solution(int[] A) {
		int N = A.length - 1;
		int m = 0;
		long sumN = 0;
		long summ = 0;
		while (m <= N) {
			if (summ > sumN) {
				sumN += A[N--];
			} else {
				summ += A[m++];
			}
		}

		return (int) Math.abs(summ - sumN);
	}

}
