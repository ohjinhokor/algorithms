import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LeetCodeLongestCommonPrefix {

	private static Reader reader = new Reader();

	private static int N;
	private static String[] strs;

	private static void input() {
		N = reader.nextInt();

		strs = new String[N];

		for (int i = 0; i < N; i++) {
			strs[i] = reader.next();
		}
	}

	public static void main(String[] args) {
		input();
		System.out.println(longestCommonPrefix(strs));
	}

	private static String longestCommonPrefix(String[] strs) {
		if (strs.length == 1) {
			return strs[0];
		}

		CommonPrefix commonPrefix = getCommonPrefix(strs[0], strs[1]);

		for (int i = 1; i <= strs.length - 2; i++) {
			if (commonPrefix.getLength() == 0) {
				return "";
			}
			CommonPrefix candidate = getCommonPrefix(strs[i], strs[i + 1]);
			if (candidate.getLength() < commonPrefix.getLength()) {
				commonPrefix = candidate;
			}
		}
		return commonPrefix.getCommonPrefix();
	}

	private static CommonPrefix getCommonPrefix(String firstWord, String secondWord) {
		StringBuilder stringBuilder = new StringBuilder();

		int minLength = Math.min(firstWord.length(), secondWord.length());

		for (int i = 0; i < minLength; i++) {
			if (firstWord.charAt(i) != secondWord.charAt(i)) {
				break;
			}
			stringBuilder.append(firstWord.charAt(i));
		}

		String commonPrefix = stringBuilder.toString();

		return new CommonPrefix(commonPrefix.length(), commonPrefix);
	}

	private static class CommonPrefix {

		private int length;

		private String commonPrefix;

		public CommonPrefix(int length, String commonPrefix) {
			this.length = length;
			this.commonPrefix = commonPrefix;
		}

		public int getLength() {
			return length;
		}

		public String getCommonPrefix() {
			return commonPrefix;
		}
	}

	private static class Reader {

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
