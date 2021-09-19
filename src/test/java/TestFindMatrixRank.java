import org.testng.Assert;
import org.testng.annotations.Test;
import ru.romanov.interfaces.IRankFinder;
import ru.romanov.methods.BorderMinorImpl;
import ru.romanov.methods.DefinitionImpl;
import ru.romanov.methods.GaussImpl;

import static ru.romanov.utils.Printer.display;

public class TestFindMatrixRank {

    @Test
    public void definition() {
        System.out.println("===Definition method===\n");
        double[][] mat =
                {
                        {10, 20, 10},
                        {-20, -30, 10},
                        {30, 50, 0}
                };
        display(mat, 3, 3);
        IRankFinder finder = new GaussImpl();
        int excepted = 2;
        int actual = finder.getMatrixRank(mat, 3, 3);
        System.out.printf("Ожидаемое значение - %d\nВычисленное значение - %d\n\n", excepted, actual);
        Assert.assertEquals(actual, excepted);
        System.out.println("===Definition method===\n");
    }

    @Test
    public void minor() {
        System.out.println("===Border Minors method===\n");
        double[][] mat =
                {
                        {10, 20, 10},
                        {-20, -30, 10},
                        {30, 50, 0}
                };
        display(mat, 3, 3);
        IRankFinder finder = new DefinitionImpl();
        int excepted = 2;
        int actual = finder.getMatrixRank(mat, 3, 3);
        System.out.printf("Ожидаемое значение - %d\nВычисленное значение - %d\n\n", excepted, actual);
        Assert.assertEquals(actual, excepted);
        System.out.println("===Border Minors method===\n");

    }

    @Test
    public void gauss() {
        System.out.println("===Gauss method===\n");
        double[][] mat =
                {
                        {10, 20, 10},
                        {-20, -30, 10},
                        {30, 50, 0}
                };
        display(mat, 3, 3);
        IRankFinder finder = new BorderMinorImpl();
        int excepted = 2;
        int actual = finder.getMatrixRank(mat, 3, 3);
        System.out.printf("Ожидаемое значение - %d\nВычисленное значение - %d\n\n", excepted, actual);
        Assert.assertEquals(actual, excepted);
        System.out.println("===Gauss method===\n");


    }
}
