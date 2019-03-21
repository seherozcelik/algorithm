package codility;

public class FrogJmp {

	public static void main(String[] args) {
		FrogJmp fj = new FrogJmp();
		System.out.println(fj.solution(10, 85, 30));
		System.out.println(Integer.MAX_VALUE);
	}

	public int solution(int X, int Y, int D) {
		if (X == Y)
			return 0;
		int dist = Y - X;
		if (D >= dist)
			return 1;
		int rem = dist % D;
		if (rem == 0)
			return dist / D;
		int exactNum = dist - rem;
		int num = exactNum / D;
		return num + 1;
	}
}
