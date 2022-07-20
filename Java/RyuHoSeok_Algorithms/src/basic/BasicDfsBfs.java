package basic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BasicDfsBfs {

	private static FastReader scan = new FastReader();
	static private List<Integer>[] graph;
	static private Boolean[] visit;

	static private int N;
	static private int M;
	static private int V;

	//	static private int[] nums = new int[5];

	public static void main(String[] args) {
		input();
		dfs(V);
		visitClear();
		System.out.println("");
		bfs(V);
	}

	private static void input() {
		N = scan.nextInt();
		M = scan.nextInt();
		V = scan.nextInt();

		graph = new ArrayList[N + 1];
		visit = new Boolean[N + 1];

		for (int i = 0; i <= N; i++) {
			visit[i] = false;
			graph[i] = new ArrayList<>();
		}

		for (int i = 1; i <= M; i++) {
			int firstNode = scan.nextInt();
			int secondNode = scan.nextInt();

			graph[firstNode].add(secondNode);
			graph[secondNode].add(firstNode);
		}

		for (List<Integer> connectedNodes : graph) {
			Collections.sort(connectedNodes);
		}

//		for (List<Integer> integers : graph) {
//			for (Integer integer : integers) {
//				System.out.print(integer);
//			}
//			System.out.println("");
//		}
	}

	private static void dfs(int node) {
		System.out.print(node + " ");
		visit[node] = true;
		for (Integer integer : graph[node]) {
			if (visit[integer]) {
				continue;
			}
			dfs(integer);
		}
	}

	private static void bfs(int start) {
		List<Integer> queue = new ArrayList<>();
		queue.add(start);
		visit[start] = true;

		while (!queue.isEmpty()) {
			int nextNode = queue.remove(0);

			System.out.print(nextNode + " ");

			for (Integer connectedNode : graph[nextNode]) {
				if (visit[connectedNode] == true) {
					continue;
				}
				queue.add(connectedNode);
				visit[connectedNode] = true;
			}
		}
	}

	private static void visitClear() {
		for (int i = 0; i <= N; i++) {
			visit[i] = false;
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
