public class TapeEquilibrium {
    public static void main(String[] args) {
        TapeEquilibrium te = new TapeEquilibrium();
        int[] A = { -10, -20, -30, -40, 100 };
        System.out.println(te.solution(A));
    }

    public int solution(int[] A) {
        if (A.length == 2)
            return Math.abs(A[0] - A[1]);
        long sum = 0;
        for (int i : A) {
            sum += i;
        }
        sum = sum - A[A.length - 1] - A[A.length - 2];
        long ySum = A[A.length - 1] + A[A.length - 2];
        long diff = Math.abs(sum - ySum);
        long minDiff = diff;
        for (int i = A.length - 3; i > 0; i--) {
            sum = sum - A[i];
            ySum += A[i];
            diff = Math.abs(sum - ySum);
            if (diff <= minDiff) {
                minDiff = diff;
            }
        }
        return (int) minDiff;
    }
}
