public class OptimalBinarySearchTree {

    public static void main(String[] args){

        float[] p = new float[5];
        Float minavg = 0F;
        int[][] R = new int[5][6];
        float answer = OptSearchTree(4,p,minavg,R);

        System.out.println(minavg);
    }

    public static float OptSearchTree(int n, final float p[], Float minavg, int R[][]){
        int i,j,k,diagonal;
        float[][] A = new float[n+2][n+1];

        for(i=0; i<=n; i++) {
            A[i][i - 1] = 0;
            A[i][i] = p[i];
            R[i][i] = i;
            R[i][i - 1] = 0;
        }

        A[n+1][n] = 0;
        R[n+1][n] = 0;

        for(diagonal =1; diagonal<n-1; diagonal++){
            j = i+diagonal;

            for(k=i; k<=j; k++) {
                if (A[i][j] > A[i][k - 1] + A[k+1][j]) {
                    A[i][j] = A[i][k - 1] + A[k + 1][j] + 1;
                    R[i][j] = k;
                }
            }
        }
        minavg = A[1][n];
        return minavg;
    }
}
