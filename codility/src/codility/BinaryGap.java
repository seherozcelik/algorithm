package codility;

public class BinaryGap {

	public static void main(String[] args) {
		// bir adet XOR cozumu var
		BinaryGap bg = new BinaryGap();
		System.out.println(bg.solution(1041));
	}

	public Integer solution(Integer N) {
		Integer maxNum = 0;
		String binN = Integer.toBinaryString(N);
		String[] zeroes = binN.split("1");
		int toIterate = 0;
		if (N % 2 == 0)
			toIterate = zeroes.length - 1;
		else
			toIterate = zeroes.length;
		for (int i = 0; i < toIterate; i++) {
			if (zeroes[i].length() > maxNum)
				maxNum = zeroes[i].length();
		}
		return maxNum;
	}

}
