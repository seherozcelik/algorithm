import java.math.BigDecimal;

public class testtt {

    public static void main(String[] args) {
        int[] A = { 1, 1, 1, 1, 1 };
        testtt tt = new testtt();
        System.out.println(tt.solution(A));
    }

    public int solution(int[] A) {
        BigDecimal t1 = BigDecimal.ZERO;
        BigDecimal t2 = BigDecimal.ZERO;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                t1 = t1.add(new BigDecimal(A[j]));
            }
            for (int j = i + 1; j < A.length; j++) {
                t2 = t2.add(new BigDecimal(A[j]));
            }
            if (t1.equals(t2)) {
                return i;
            }
            t1 = BigDecimal.ZERO;
            t2 = BigDecimal.ZERO;
        }

        return -1;
    }
}
