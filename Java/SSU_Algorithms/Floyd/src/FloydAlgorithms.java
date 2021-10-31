public class FloydAlgorithms {
    public static void main(String[] args) {

        int [][] arrayW = {{99,99,99,99,99,99},{99,0,1,99,1,5},{99,9,0,3,2,99},{99,99,99,0,4,99},{99,99,99,2,0,3},{99,3,99,99,99,0}};
        int [][] arrayD = new int[6][6];
        int [][] arrayP = new int[6][6];

        floyd2(6,arrayW,arrayD,arrayP);
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
        for(k=0; k<n; k++){
            for(i=0; i<n; i++){
                for(j=0; j<n; j++){
                    if(D[i][j]>D[i][k]+D[k][j]){
                        P[i][j] = k;
                        D[i][j] = D[i][k]+D[k][j];
                    }
                }
            }
        }

        for(i=0; i<n; i++){
            for(j=0; j<n; j++){
                System.out.print(D[i][j] + ",");
            }
            System.out.println("");
        }
        System.out.println("====================");
        for(i=0; i<n; i++){
            for(j=0; j<n; j++){
                System.out.print(P[i][j] + ",");
            }
            System.out.println("");
        }
    }
}


