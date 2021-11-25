import java.util.ArrayList;

public class Ojh20162589 {

    static int size = 5;
    static int MAX = 99;

    static int i, vNear;
    static String edge = "";
    static int[] touch = new int[size + 1];
    static int[] length = new int[size+1];
    static ArrayList<String> F = new ArrayList<>();

    static int W[][] = {{MAX,MAX,MAX,MAX,MAX,MAX},{MAX,0,7,4,6,1},{MAX,MAX,0,MAX,MAX,MAX},{MAX,MAX,2,0,5,MAX},{MAX,MAX,3,MAX,0,MAX},{MAX,MAX,MAX,MAX,1,0}};

    public static void main(String[] args) {
        dijkstra(size,W,F);

        for (String f : F) {
            System.out.println(f);
        }
    }

    public static void dijkstra(int n, final int[][] W, ArrayList<String> F) {

        for(i=2; i<=n;i++){
            touch[i] = 1;
            length[i] = W[1][i];
        }

        //가장 가까운 vertex를 찾아옴.
        for(int count=0; count<n-1; count++){
            int min = MAX;
            for(int i=2; i<=n; i++) {
                if (0 <= length[i] && length[i] < min) {
                    min = length[i];
                    vNear = i;
                }
            }

            edge = "V" + Integer.toString(touch[vNear]) + " -> " + "V"+Integer.toString(vNear);
            F.add(edge);


            for(int j=2; j<=n; j++){
                if(length[vNear] + W[vNear][j] < length[j]){
                    length[j] = length[vNear] + W[vNear][j];
                    touch[j] = vNear;
                }
                length[vNear] = -1;
            }
        }
    }
}
