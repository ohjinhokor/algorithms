public class FloydAlgorithms {
    static int [][] arrayW = {{999,999,999,999,999,999},{999,0,3,999,8,999},{999,999,0,999,4,999},{999,6,2,0,999,999},{999,999,999,2,0,2},{999,5,999,999,1,0}};
    static int [][] arrayD = new int[6][6];
    static int [][] arrayP = new int[6][6];

    public static void main(String[] args) {

        floyd2(6,arrayW,arrayD,arrayP);

        int start = 3;
        int end = 5;

        System.out.print("\n" + start+"노드부터 " +end + "노드까지 이동하는 경로 : ");
        path(start,end);

    }

    public static void floyd2(int n, final int[][] W, int[][] D, int[][] P){

        int i,j,k;

        for(i=0; i<n; i++){
            for(j=0; j<n; j++) {
                D[i][j] = W[i][j];
            }
        }

        for(i=0; i<n; i++){
            for(j=0; j<n; j++) {
                P[i][i] =0;
            }
        }

        for(k=1; k<n; k++){
            for(i=0; i<n; i++){
                for(j=0; j<n; j++){
                    if(D[i][j]>D[i][k]+D[k][j] && i!=j){
                        P[i][j] = k;
                        D[i][j] = D[i][k]+D[k][j];
                    }
                }
            }
        }

        System.out.println("====================\n");
        System.out.println("배열 D의 최종 모습");
        for(i=0; i<n; i++){
            for(j=0; j<n; j++){
                System.out.print(D[i][j] + ",");
            }
            System.out.println("");
        }

        System.out.println("====================\n");
        System.out.println("배열 P의 최종 모습");
        for(i=0; i<n; i++){
            for(j=0; j<n; j++){
                System.out.print(P[i][j] + ",");
            }
            System.out.println("");
        }
    }

    public static void path(int q, int r){
        //q는 시작 노드, r은 종료 노드이다.
        if(arrayP[q][r] !=0){
            path(q, arrayP[q][r]);
            System.out.print("V"+arrayP[q][r]+" ");
            path(arrayP[q][r], r);
        }
    }
}


