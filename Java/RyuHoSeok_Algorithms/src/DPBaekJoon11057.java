import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DPBaekJoon11057 {

	private static Reader reader = new Reader();
	private static int[][] numbers;

	private static int N;

	public static void main(String[] args) {
		input();
		preProcessing();
		printTotalByDigit(N);
	}

	private static void input() {

		N = reader.nextInt();

		numbers = new int[N + 1][10];
	}

	private static void preProcessing() {

		for (int i = 0; i <= 9; i++) {
			numbers[0][i] = 0;
		}

		for (int i = 0; i <= 9; i++) {
			numbers[1][i] = 1;
		}

		for (int i = 2; i <= N; i++) {
			int sum = 0;
			for (int j = 0; j <= 9; j++) {
				sum = sum + numbers[i - 1][j];
				numbers[i][j] = sum;
			}
		}
	}

	private static void printTotalByDigit(int digit) {
		int sum = 0;

		for (int i = 0; i <= 9; i++) {
			sum = sum + numbers[digit][i];
			System.out.println("i : " + i + "  number : " + numbers[digit][i]);
			System.out.println("i : " + i + " sum : " + sum);
		}

		System.out.println(sum % 10007);
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
