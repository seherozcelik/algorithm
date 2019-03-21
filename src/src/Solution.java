import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        Solution ss = new Solution();
        int[] A = {40, 40, 100, 80, 20};
        int[] B = {3, 3, 2, 2, 3};
        ss.solution(A, B, 3, 5, 200);
    }

    public int solution(int[] A, int[] B, int M, int X, int Y) {
        int stopTimes = 0;
        HashSet<Integer> floor = new HashSet<Integer>();
        int tempY = Y;
        int tempX = X;
        for (int i = 0; i < A.length; i++) {
            tempY -= A[i];
            tempX--;
            if (tempY >= 0 && tempX >= 0) {
                floor.add(B[i]);
                System.out.println(floor);
            } else {
                stopTimes += floor.size();
                stopTimes += 1;
                System.out.println(stopTimes);
                floor.clear();
                tempY = Y-A[i];
                tempX = X-1;
                floor.add(B[i]);
                System.out.println(floor);
                System.out.println(i);
                if(i==A.length -2){
                    stopTimes += floor.size();
                    stopTimes += 1;
                    System.out.println(stopTimes);
                }
            }
        }
        
        return stopTimes;
    }
}
