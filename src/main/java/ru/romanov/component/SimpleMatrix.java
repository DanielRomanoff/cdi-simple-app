package ru.romanov.component;

import lombok.*;
import ru.romanov.annotations.Definition;
import ru.romanov.annotations.Gauss;
import ru.romanov.annotations.Minor;
import ru.romanov.annotations.Timer;
import ru.romanov.interfaces.IRankFinder;

import javax.inject.Inject;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SimpleMatrix {
    double[][] matrix;

    @Inject
    @Minor
    IRankFinder finder;

    @Timer
    public int getRank() {
        return finder.getMatrixRank(this.getMatrix(), 3, 3);
    }
}
