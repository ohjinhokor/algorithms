package basic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 10,000 이하의 자연수로 이루어진 길이 N짜리 수열이 주어진다. 이 수열에서 연속된 수들의 부분합 중에 그 합이 S 이상이 되는 것 중, 가장 짧은 것의 길이를 구하는 프로그램을 작성하시오.
public class BasicTwoPointers {

	private static FastReader reader = new FastReader();
	private static int N;
	private static int S;
	private static int[] list;

	public static void main(String[] args) {
		input();
		System.out.println(getShortestLength());
	}

	private static int getShortestLength() {
		int shortestLength = N + 1;

		int leftPoint = 0;
		int rightPoint = 0;
		int sum = 0;

		while (leftPoint < N) {
			leftPoint++;
			sum = sum - list[leftPoint - 1];
			while (sum < S && rightPoint + 1 <= N) {
				rightPoint = rightPoint + 1;
				sum = sum + list[rightPoint];
			}
			if (sum >= S) {
				shortestLength = Math.min(shortestLength, (rightPoint - leftPoint + 1));
			}
		}
		if (shortestLength == N + 1) {
			shortestLength = 0;
		}
		return shortestLength;
	}

	static private void input() {
		N = reader.nextInt();
		S = reader.nextInt();
		list = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = reader.nextInt();
		}
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
