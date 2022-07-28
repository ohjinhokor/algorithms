import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LeetCodeRomanToInteger {

	private static Reader reader = new Reader();

	private static String romanString;

	private static char[] romanChars;

	public static void main(String[] args) {
		input();
		System.out.println(romanToInt(romanString));
	}

	private static int romanToInt(String s) {
		makeRomanStringToChars(s);

		int sum = 0;

		int charAt = 1;

		while (charAt <= s.length()) {

			if (charAt == s.length()) {
				sum = sum + RomanSymbol.switchToRomanSymbol(romanChars[charAt]).getValue();

				charAt++;
				continue;
			}

			RomanSymbol romanSymbol = RomanSymbol.switchToRomanSymbol(romanChars[charAt]);
			RomanSymbol nextRomanSymbol = RomanSymbol.switchToRomanSymbol(romanChars[charAt + 1]);

			if (romanSymbol.getValue() < nextRomanSymbol.getValue()) {
				sum = sum + nextRomanSymbol.getValue() - romanSymbol.getValue();

				charAt = charAt + 2;
				continue;
			}

			sum = sum + romanSymbol.getValue();

			charAt++;
		}
		return sum;
	}

	private static void makeRomanStringToChars(String s) {
		romanChars = new char[s.length() + 1];

		for (int i = 0; i < s.length(); i++) {
			romanChars[i + 1] = romanString.charAt(i);
		}
	}

	private static void input() {
		romanString = reader.next();
	}

	enum RomanSymbol {
		I(1),
		V(5),
		X(10),
		L(50),
		C(100),
		D(500),
		M(1000),
		;

		private int value;

		RomanSymbol(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public static RomanSymbol switchToRomanSymbol(char romanChar) {
			String romanString = Character.toString(romanChar);

			for (RomanSymbol romanSymbol : RomanSymbol.values()) {
				if (romanString.equals(romanSymbol.toString())) {
					return romanSymbol;
				}
			}
			return null;
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
	}
}
