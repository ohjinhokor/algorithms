import java.io.*;
import java.util.*;

public class TreeBaekJoon11725 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] parentNode;
    static boolean[] visit;

    static ArrayList<Integer>[] connectedNodes;

    static void input() {
        N = scan.nextInt();

        parentNode = new int[N + 1];
        visit = new boolean[N + 1];
        connectedNodes = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            connectedNodes[i] = new ArrayList<>();
        }
        for (int i = 1; i < N; i++) {
            int firstNode = scan.nextInt();
            int secondNode = scan.nextInt();

            connectedNodes[firstNode].add(secondNode);
            connectedNodes[secondNode].add(firstNode);
        }
    }

    // start 에서 시작해서 갈 수 있는 정점들을 모두 탐색하기
    static void dfs(int start) {
        List<Integer> nodeList = new ArrayList<Integer>();

        for (Integer node : connectedNodes[start]) {
            if (visit[node]) {
                continue;
            }
            nodeList.add(node);
            visit[node] = true;
            parentNode[node] = start;
        }
        while (!nodeList.isEmpty()) {
            Integer node = nodeList.remove(0);
            dfs(node);
        }
    }

    static void pro() {
        dfs(1);
        for (int i = 2; i <= N; i++) {
            sb.append(parentNode[i] + "\n");
        }

        System.out.println(sb.toString());
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