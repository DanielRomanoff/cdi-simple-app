package ru.romanov.methods;

import ru.romanov.annotations.Definition;
import ru.romanov.interfaces.IRankFinder;

@Definition
public class DefinitionImpl implements IRankFinder {

    static void swap(double[][] mat,
                     int row1, int row2, int col) {
        for (int i = 0; i < col; i++) {
            double temp = mat[row1][i];
            mat[row1][i] = mat[row2][i];
            mat[row2][i] = temp;
        }
    }

    @Override
    public int getMatrixRank(double[][] mat, int n, int m) {
        int rank = n;
        for (int row = 0; row < rank; row++) {
            if (mat[row][row] != 0) {
                for (int col = 0; col < m; col++) {
                    if (col != row) {
                        double mult = mat[col][row] / mat[row][row];
                        for (int i = 0; i < rank; i++)
                            mat[col][i] -= mult * mat[row][i];
                    }
                }
            } else {
                boolean reduce = true;
                for (int i = row + 1; i < m; i++) {
                    if (mat[i][row] != 0) {
                        swap(mat, row, i, rank);
                        reduce = false;
                        break;
                    }
                }
                if (reduce) {
                    rank--;
                    for (int i = 0; i < m; i++)
                        mat[i][row] = mat[i][rank];
                }
                row--;
            }
        }
        return rank;
    }
}