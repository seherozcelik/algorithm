import java.util.HashSet;

public class OddOccurrencesInArray {

    public static void main(String[] args) {
        OddOccurrencesInArray occr = new OddOccurrencesInArray();
        int[] A = { 2, 3, 6, 3, 6, 2, 5, 9, 8, 8, 9 };
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
