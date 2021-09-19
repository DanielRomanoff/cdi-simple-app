package ru.romanov.methods;

import Jama.Matrix;
import ru.romanov.annotations.Minor;
import ru.romanov.annotations.Timer;
import ru.romanov.interfaces.IRankFinder;

@Minor
public class BorderMinorImpl implements IRankFinder {
    @Override
    public int getMatrixRank(double[][] matrix, int n, int m) {
        return new Matrix(matrix).rank();
    }
}
