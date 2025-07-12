import java.io.*;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] matrixA = new int[row][col];
        int[][] matrixB = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrixA[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrixB[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrixA[i][j] + matrixB[i][j] + " ");
            }
            if(i < row - 1)
                System.out.println();
        }
    }
}