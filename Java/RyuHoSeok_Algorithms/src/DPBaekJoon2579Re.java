import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DPBaekJoon2579Re {

	private static Reader reader = new Reader();

	private static int stairsCount;
	private static int[] stairsValue; // 각 계단에 부여된 값
	private static int[] TotalValueContainBeforeStair; // 직전 계단을 밟은 경우, 현재 계단까지의 합
	private static int[] TotalValueNotContainBeforeStair; // 직전 계단을 밟지 경우, 현재 계단까지의 합

	public static void main(String[] args) {
		input();
		calculateStairTotalValue();
		System.out.println(Math.max(TotalValueContainBeforeStair[stairsCount], TotalValueNotContainBeforeStair[stairsCount]));
	}

	private static void calculateStairTotalValue() {
		for (int i = 3; i <= stairsCount; i++) {
			TotalValueContainBeforeStair[i] = TotalValueNotContainBeforeStair[i - 1] + stairsValue[i];
			TotalValueNotContainBeforeStair[i] = Math.max(TotalValueNotContainBeforeStair[i - 2], TotalValueContainBeforeStair[i - 2]) + stairsValue[i];
		}
	}

	private static void input() {
		stairsCount = reader.nextInt();
		stairsValue = new int[stairsCount + 1];

		TotalValueContainBeforeStair = new int[stairsCount + 1];
		TotalValueNotContainBeforeStair = new int[stairsCount + 1];

		for (int i = 1; i <= stairsCount; i++) {
			stairsValue[i] = reader.nextInt();
		}

		TotalValueContainBeforeStair[1] = stairsValue[1];
		TotalValueNotContainBeforeStair[1] = stairsValue[1];

		TotalValueContainBeforeStair[2] = stairsValue[1] + stairsValue[2];
		TotalValueNotContainBeforeStair[2] = stairsValue[2];
	}

	static class Reader {

		BufferedReader br;
		StringTokenizer st;

		public Reader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
