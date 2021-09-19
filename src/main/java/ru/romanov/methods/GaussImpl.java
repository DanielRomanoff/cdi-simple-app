package ru.romanov.methods;

import ru.romanov.annotations.Gauss;
import ru.romanov.interfaces.IRankFinder;

@Gauss
public class GaussImpl implements IRankFinder {
    @Override
    public int getMatrixRank(double[][] mat, int n, int m) {
        int zeroRows = 0, limit = Math.min(n, m);
        outer:
        for (double[] row : mat) {

            for (int i = 0; i < limit; i++) {
                if (Math.abs(row[i]) > 1.0e-14) {
                    continue outer;
                }
            }
            zeroRows++;
        }
        return limit - zeroRows - 1;
    }
}
