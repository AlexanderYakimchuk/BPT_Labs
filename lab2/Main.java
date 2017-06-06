package labs.lab2;
/**
 * Created by User on 09.04.2017.
 */

/**
 * operation - direct sum
 * type of elements - byte
 * operation with C - find average value of each row of matrix
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Input matrix A
        int n = 0;
        System.out.printf("Size of A[n x n]: ");
        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
        }
        System.out.printf("Input elements of A:\n");
        byte[][] A = new byte[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (scanner.hasNextByte()) {
                    A[i][j] = scanner.nextByte();
                }
            }
        }
        //Input matrix B
        int m = 0;
        System.out.printf("Size of B[m x m]: ");
        if (scanner.hasNextInt()) {
            m = scanner.nextInt();
        }
        System.out.printf("Input elements of B:\n");
        byte[][] B = new byte[m][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (scanner.hasNextByte()) {
                    B[i][j] = scanner.nextByte();
                }
            }
        }

        //Calculate matrix
        int k=n+m;
        byte [][] C=new byte[k][k];
        for (int i=0; i<k; i++){
            for (int j=0; j<k; j++){
                if (i<n){
                    if (j<n){
                        C[i][j]=A[i][j];
                    } else{
                        C[i][j]=0;
                    }
                } else{
                    if (j>=n){
                        C[i][j]=B[i-n][j-n];
                    } else {
                        C[i][j] = 0;
                    }
                }
            }
        }
        //Output matrix C
        System.out.printf("Matrix C:\n");
        for(int i=0; i<k; i++){
            for (int j=0; j<k; j++){
                System.out.printf("%4d", C[i][j]);
            }
            System.out.printf("\n");
        }

        //Calculate average value fot each row
        float sum;
        for (int i=0; i<k; i++){
            sum=0;
            for (int j=0; j<k; j++){
                sum+=C[i][j];
            }
            System.out.printf("Row %d   Average %.2f\n", i, (float)(sum/k));
        }
    }
}
