public class OptimalBinarySearchTree {

    public static void main(String[] args){

        float[] p = {0, 3f/8f, 2f/8f, 2f/8f, 1f/8f};
        int[][] R = new int[6][5];
        float answer = OptSearchTree(4,p,R);

        System.out.println(answer);
    }

    public static float OptSearchTree(int n, final float p[], int R[][]){
        int i,j,k,diagonal;
        float[][] A = new float[n+2][n+1];
        for(i=0; i<n+2; i++){
            for(j=0; j<n+1; j++){
                A[i][j] = 99;
            }
        }


        for(i=1; i<=n; i++) {
            A[i][i - 1] = 0;
            A[i][i] = p[i];
            R[i][i] = i;
            R[i][i - 1] = 0;
        }

        A[n+1][n] = 0;
        R[n+1][n] = 0;

        for(diagonal =1; diagonal<=n-1; diagonal++) {
            for (i = 1; i <= n - diagonal; i++) {
                j = i + diagonal;

                float sumP = 0.0f;
                for(int sum =i; sum<=j; sum++){
                    sumP = sumP + p[sum];
                }

                for (k = i; k <= j; k++) {
                    if (A[i][j] > A[i][k - 1] + A[k + 1][j] + sumP) {
                        A[i][j] = A[i][k - 1] + A[k + 1][j] + sumP;
                        R[i][j] = k;
                    }
                }
            }
        }

        System.out.println("-----------------------");
        for (int[] ints : R) {
            for (int anInt : ints) {
                System.out.print(anInt + ",");
            }
            System.out.println();
        }

        System.out.println("-----------------");

        for (float[] floats : A) {
            for (float aFloat : floats) {
                System.out.print(aFloat+",");
            }
            System.out.println("");
        }

        System.out.println("----------------------");
        float minavg = A[1][n];
        return minavg;
    }
}
