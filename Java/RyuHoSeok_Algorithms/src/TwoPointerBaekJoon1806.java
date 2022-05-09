import java.io.*;
import java.util.*;

public class TwoPointerBaekJoon1806 {
    static StringBuilder sb = new StringBuilder();
    static FastReader fastReader = new FastReader();

    static int N;
    static int S;

    static int[] arr;

    static void input() {
        N = fastReader.nextInt();
        S = fastReader.nextInt();

        arr = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            arr[i] = fastReader.nextInt();
        }
    }

    static void pro() {
        int result =S+1;

        for (int startPoint = 1; startPoint< N+1; startPoint++) {
            int count = 0;
            int sum = 0;
            for (int i = startPoint; i < N + 1; i++) {
                sum = sum + arr[i];
                count++;
                if (sum > S) {
                    if (result > count) {
                        result = count;
                    }
                    continue;
                }
            }
        }
        System.out.println(result);
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