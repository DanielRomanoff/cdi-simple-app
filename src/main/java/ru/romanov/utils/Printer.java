package ru.romanov.utils;

public class Printer {

    public static void display(double[][] mat, int row, int col) {
        System.out.println("Матрица:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++)
                System.out.print(mat[i][j] + "\t");
            System.out.print("\n");
        }
    }
}
