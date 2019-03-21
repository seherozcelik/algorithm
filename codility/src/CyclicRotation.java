public class CyclicRotation {

    public static void main(String[] args) {
        CyclicRotation cy = new CyclicRotation();
        int[] A = { 3, 8, 9, 7, 6 };
        int[] newA = cy.solution(A, 3);
        for (int i : newA) {
            System.out.print(i + " ");
        }
    }

    public int[] solution(int[] A, int K) {
        int L = A.length;
        int[] newA = new int[L];
        for (int i = 0; i < L; i++) {
            newA[(i + K) % L] = A[i];
        }
        return newA;
    }
}
