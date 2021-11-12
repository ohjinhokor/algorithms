

public class ChainedMatrixMultiplication {
    static int d[] = {5,2,3,4,6,7,8};
    static int[][] P = new int[7][7];
    public static void main(String[] args) {
        int answer = minmult(6, d, P);
        System.out.println("\nanswer : " + answer);

        System.out.print("\n가장 빠른 행렬 곱셈 방법 : ");
        order(1,6);
        System.out.println("");

    }

    public static int minmult(int n, final int d[], int P[][]){
        int i,j,k,diagonal;
        int M[][] = new int[n+1][n+1];

        int MAX = 999;
        for(i=1; i<n+1; i++) {
            for(j=1; j<n+1; j++){
            M[i][j] = MAX ;
            } ;

        }

        for(i=0; i<=n; i++){
            M[i][i]=0;
        }

        for(diagonal =1; diagonal<=n-1; diagonal++){
            for(i=1; i<=n-diagonal; i++){
                j = i+diagonal;
                for(k=i; k<=j-1; k++){
                    if(diagonal == 1){
                        M[i][j] = M[i][k]+M[k+1][j] + d[i-1]*d[k]*d[j];
                        P[i][j] = k;
                    }
                    else{
                        if(M[i][j]> M[i][k]+M[k+1][j] + d[i-1]*d[k]*d[j]){
                            M[i][j] = M[i][k]+M[k+1][j] + d[i-1]*d[k]*d[j];
                            P[i][j] = k;

                        }
                    }
                }
            }
        }
        System.out.println("\n [matrix] ");
        for(i =0; i<7; i++){
            for(j=0; j<7; j++){
                System.out.print(M[i][j]+",");
            }
            System.out.println();
        }

        return M[1][n];
    }

    public static void order(int i, int j){

        if(i==j){
            System.out.print("A" + i);
        }else{
            int k = P[i][j];
            System.out.print("(");
            order(i,k);
            order(k+1, j);
            System.out.print(")");
        }
    }
}
