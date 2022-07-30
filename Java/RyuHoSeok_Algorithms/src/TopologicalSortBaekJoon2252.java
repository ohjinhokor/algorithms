import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TopologicalSortBaekJoon2252 {

	private static Reader reader = new Reader();
	private static StringBuilder stringBuilder = new StringBuilder();

	private static int N;
	private static int M;

	private static int[] inDegreeCount;
	private static List<Integer>[] smallerStudents;
	private static List<Integer> studentsLine = new ArrayList<>();

	public static void main(String[] args) {
		input();
		preProcess();
		printStudentDesc();
	}

	private static void printStudentDesc() {
		addTallestStudentsToLine();

		while (!studentsLine.isEmpty()) {
			Integer student = studentsLine.remove(0);
			stringBuilder.append(student + " ");

			for (Integer smallerStudent : smallerStudents[student]) {
				inDegreeCount[smallerStudent]--;
				if (inDegreeCount[smallerStudent] == 0) {
					studentsLine.add(smallerStudent);
				}
			}
		}

		for (int student = 1; student <= N; student++) {
			if (inDegreeCount[student] != 0) {
				stringBuilder.append(student + " ");
			}
		}

		System.out.println(stringBuilder);
	}

	private static void addTallestStudentsToLine() {
		for (int student = 1; student <= N; student++) {
			if (inDegreeCount[student] == 0) {
				studentsLine.add(student);
			}
		}
	}

	private static void input() {
		N = reader.nextInt();
		M = reader.nextInt();
	}

	private static void preProcess() {
		inDegreeCount = new int[N + 1];
		smallerStudents = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			smallerStudents[i] = new ArrayList();
		}

		for (int i = 1; i <= M; i++) {
			int tallerStudent = reader.nextInt();
			int smallerStudent = reader.nextInt();

			inDegreeCount[smallerStudent]++;
			smallerStudents[tallerStudent].add(smallerStudent);
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
