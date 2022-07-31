import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class TopologicalSortBaekJoon1005 {

	private static Reader reader = new Reader();

	private static int T; // test case 개수
	private static int N; // 건물의 갯수
	private static int K; // 건설순서 규칙의 총 개수

	private static Map<Integer, Integer> constructTimes = new HashMap<>(); // 건물 건설 시간
	private static List<Integer> topologicalList = new ArrayList<>(); // 건물들을 위상정렬한 리스트
	private static int[] inDegree; // 각 건물의 inDegree
	private static List<Integer>[] parentConstructions; // 각 건물이 지어지기 위해 미리 건설되어 있어야 하는 건물 리스트
	private static List<Integer>[] childConstructions; // 각 건물이 완성되어야 지어질 수 있는 건물 리스트
	private static int[] constructionAccumulatedTime; // 각 건물이 지어지는데 필요한 누적 시간

	public static void main(String[] args) {
		T = reader.nextInt();
		for (int i = 1; i <= T; i++) {
			preProcess();
			System.out.println(constructionAccumulatedTime[reader.nextInt()]);
			clear();
		}
	}

	private static void clear() {
		constructTimes.clear();
		topologicalList.clear();
		for (int i = 0; i < inDegree.length; i++) {
			inDegree[i] = 0;
		}
		for (List<Integer> parentConstruction : parentConstructions) {
			parentConstruction.clear();
		}
		for (List<Integer> childConstruction : childConstructions) {
			childConstruction.clear();
		}
		for (int i = 0; i < constructionAccumulatedTime.length; i++) {
			constructionAccumulatedTime[i] = 0;
		}
	}

	private static void preProcess() {
		N = reader.nextInt();
		K = reader.nextInt();

		for (int i = 1; i <= N; i++) {
			constructTimes.put(i, reader.nextInt());
		}

		inDegree = new int[N + 1];
		parentConstructions = new ArrayList[N + 1];
		childConstructions = new ArrayList[N + 1];
		constructionAccumulatedTime = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			parentConstructions[i] = new ArrayList();
			childConstructions[i] = new ArrayList();
		}

		for (int i = 1; i <= K; i++) {
			int parent = reader.nextInt();
			int child = reader.nextInt();

			inDegree[child]++;
			parentConstructions[child].add(parent);
			childConstructions[parent].add(child);
		}
		topologicalSort();
		calculateAccumulatedTime();
	}

	private static void topologicalSort() {
		List<Integer> queue = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) {
				queue.add(i);
			}
		}

		while (!queue.isEmpty()) {
			int construction = queue.remove(0);
			topologicalList.add(construction);
			for (Integer child : childConstructions[construction]) {
				inDegree[child]--;
				if (inDegree[child] == 0) {
					queue.add(child);
				}
			}
		}
	}

	private static void calculateAccumulatedTime() {
		for (Integer construction : topologicalList) {
			if (parentConstructions[construction].size() == 0) {
				constructionAccumulatedTime[construction] = constructTimes.get(construction);
				continue;
			}

			int max = 0;
			for (Integer parent : parentConstructions[construction]) {
				if (constructionAccumulatedTime[parent] > max) {
					max = constructionAccumulatedTime[parent];
				}
			}

			constructionAccumulatedTime[construction] = max + constructTimes.get(construction);
		}
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