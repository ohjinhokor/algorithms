package basic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// Tree형태의 그래프를 받아서 각 노드의 부모 노드를 출력하는 문제
public class BasicTree {

	private static FastReader reader = new FastReader();
	private static List<Integer>[] tree;
	private static int[] parentNodes;
	private static int N;

	public static void main(String[] args) {
		input();
		saveParentNode(1);
		printParentNode();
	}

	private static void printParentNode() {
		for (int i = 2; i <= N; i++) {
			System.out.println(parentNodes[i]);
		}
	}

	private static void saveParentNode(int node) {
		List<Integer> queue = new ArrayList<>();
		queue.add(node);

		while (!queue.isEmpty()) {
			Integer parentNode = queue.remove(0);
			for (Integer childNode : tree[parentNode]) {
				if (parentNodes[childNode] != 0) {
					continue;
				}
				parentNodes[childNode] = parentNode;
				queue.add(childNode);
			}
		}
	}

	private static void input() {
		N = reader.nextInt();
		tree = new ArrayList[N + 1];
		parentNodes = new int[N + 1];
		parentNodes[1] = 1; // Node 1의 부모 노드를 자기 자신으로 표현. 이게 보편적인 방식인지는 모르겠음

		for (int i = 0; i <= N; i++) {
			tree[i] = new ArrayList<>();
		}

		for (int i = 1; i <= N - 1; i++) {
			int firstNode = reader.nextInt();
			int secondNode = reader.nextInt();

			tree[firstNode].add(secondNode);
			tree[secondNode].add(firstNode);
		}

//		for (List<Integer> integers : tree) {
//			for (Integer integer : integers) {
//				System.out.print(integer);
//			}
//			System.out.println(" ");
//		}
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
