import java.util.Arrays;
import java.util.Scanner;

public class SortProblem {
    static void swap(int mat[][], int i, int minInd, int j){
        int temp = mat[i][j];
        mat[i][j] = mat[minInd][j];
        mat[minInd][j] = temp;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int mat[][] = new int[n][2];
        for(int i=0; i<n; i++)
            for(int j=0; j<2; j++)
                mat[i][j] = in.nextInt();
        
        for(int i=0; i<n; i++){
            int minInd = i;
            for(int j=i+1; j<n; j++){
                if(mat[j][0]<mat[minInd][0])
                    minInd = j;
            }
            swap(mat, i, minInd, 0);
            swap(mat, i, minInd, 1);
        }

        for(int i=0; i<n-1; i++){
            if(mat[i][0]==mat[i+1][0]){
                if(mat[i][1]>mat[i+1][1]){
                    swap(mat, i, i+1, 1);
                }
            }
        }

        for(int i=0; i<n; i++){
            System.out.println(Arrays.toString(mat[i]));
        }
    }
}