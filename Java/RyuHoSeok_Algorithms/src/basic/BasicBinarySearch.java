package basic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// A 배열, B 배열이 있음.
// B 배열을 정렬한 후, A배열의 각각의 숫자보다 작은 숫자가 B배열안에 몇개 있는지 출력하는 문제
public class BasicBinarySearch {

	private static FastReader reader = new FastReader();

	private static int T;
	private static int N;
	private static int M;

	private static int[] aFishes;
	private static int[] bFishes;

	public static void main(String[] args) {
		input();
		for (int i = 0; i < T; i++) {
			fishInput();
			printTotalCount();
		}
	}

	private static void input() {

		T = reader.nextInt();
		N = reader.nextInt();
		M = reader.nextInt();
	}

	private static void fishInput() {

		aFishes = new int[N + 1];
		bFishes = new int[M + 1];

		for (int i = 1; i <= N; i++) {
			aFishes[i] = reader.nextInt();
		}

		for (int i = 1; i <= M; i++) {
			bFishes[i] = reader.nextInt();
		}

		Arrays.sort(bFishes, 1, M + 1);
	}

	private static void printTotalCount() {
		int count = 0;

		for (int i = 1; i <= N; i++) {
			int aFishSize = aFishes[i];
			int bFishCount = countSmallerFishSizeThan(aFishSize);
			count = count + bFishCount;
		}
		System.out.println(count);
	}

	private static int countSmallerFishSizeThan(int fishSize) {
		int left = 1;
		int right = M;
		int result = 0;
		int mid;

		while (left <= right) {
			mid = (left + right) / 2;

			if (bFishes[mid] < fishSize) {
				result = mid;
				left = mid + 1;
			} else if (bFishes[mid] >= fishSize) {
				right = mid - 1;
			}
		}
		return result;
	}

	static class FastReader {

		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public FastReader(String s) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(new File(s)));
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

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
