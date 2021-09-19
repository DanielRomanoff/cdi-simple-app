package ru.romanov;

import ru.romanov.component.SimpleMatrix;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

/**
 * Создать компонент CDI, выполняющий нахождение ранга матрицы различными способами (по определению, методом окаймляющих миноров, по методу Гаусса).
 * Выбор способа нахождение ранга матрицы должен быть реализован через указание соответствующей аннотации или посредством указания класса в XML файле.
 * Посредством перехватчиков провести сравнение по времени эффективности различных методов.
 *
 * Results:
 * Gauss: 31820
 * Definition: 28900
 * Border minors: 67919100
 */

public class App {
    public static void main(String[] args) {
        SeContainerInitializer initializer = SeContainerInitializer.newInstance();
        SeContainer container = initializer.initialize();
        double[][] mat =
                {
                        {10, 20, 10},
                        {-20, -30, 10},
                        {30, 50, 0}
                };
        SimpleMatrix matrix = container.select(SimpleMatrix.class).get();
        matrix.setMatrix(mat);
        System.out.println(matrix.getRank());
    }
}
