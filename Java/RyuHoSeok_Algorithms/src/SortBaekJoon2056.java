import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SortBaekJoon2056 {

	static FastReader scan = new FastReader();

	static int N, M;
	static int[] indeg, T_done, T;
	static ArrayList<Integer>[] adj;

	static void input() {
		N = scan.nextInt();
		adj = new ArrayList[N + 1];
		indeg = new int[N + 1];
		T = new int[N + 1];
		T_done = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 1; i <= N; i++) {
			T[i] = scan.nextInt();
			int cnt = scan.nextInt();
			while (cnt-- > 0) {
				int y = scan.nextInt();
				adj[y].add(i);
				indeg[i]++;
			}
		}
	}

	static void pro() {
		Deque<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (indeg[i] == 0) {
				queue.add(i);
				T_done[i] = T[i];
			}
		}

		while (!queue.isEmpty()) {
			int x = queue.poll();
			for (int y : adj[x]) {
				indeg[y]--;
				if (indeg[y] == 0) {
					queue.add(y);
				}
				T_done[y] = Math.max(T_done[y], T_done[x] + T[y]);
			}
		}
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			ans = Math.max(ans, T_done[i]);
		}
		System.out.println(ans);
	}

	public static void main(String[] args) {
		input();
		pro();
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
	}
}
