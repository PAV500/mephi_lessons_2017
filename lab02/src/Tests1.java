/**
 * Created by Александр on 20.10.2017.
 */
import org.junit.Assert;
import org.junit.Test;

public class Tests1 {
    @Test
    public void test1() {

        Integr integr = new Integr();

        Assert.assertTrue(Math.abs(integr.Prymougolnik(-1, 3, 1000, 1) - 20) <= 0.1);
        Assert.assertTrue(Math.abs(integr.Trapec(-1, 3, 1000, 1) - 20) <= 0.1);
        Assert.assertTrue(Math.abs(integr.Simpson(-1, 3, 1000, 1) - 20) <= 0.1);
    }

    @Test
    public void test2() {

        Integr integr = new Integr();

        Assert.assertTrue(Math.abs(integr.Prymougolnik(0, 2, 1000, 2) - 1.68) <= 0.1);
        Assert.assertTrue(Math.abs(integr.Trapec(0, 2, 1000, 2) - 1.68) <= 0.1);
        Assert.assertTrue(Math.abs(integr.Simpson(0, 2, 1000, 2) - 1.68) <= 0.1);
    }

    @Test
    public void test3() {

        Integr integr = new Integr();

        Assert.assertTrue(Math.abs(integr.Prymougolnik(1, 5, 1000, 3) - 1.61) <= 0.1);
        Assert.assertTrue(Math.abs(integr.Trapec(1, 5, 1000, 3) - 1.61) <= 0.1);
        Assert.assertTrue(Math.abs(integr.Simpson(1, 5, 1000, 3) - 1.61) <= 0.1);
    }

    @Test
    public void test4() {

        Integr integr = new Integr();

        Assert.assertTrue(Math.abs(integr.Prymougolnik(1, 5, 1000, 4) - 4.047) <= 0.1);
        Assert.assertTrue(Math.abs(integr.Trapec(1, 5, 1000, 4) - 4.047) <= 0.1);
        Assert.assertTrue(Math.abs(integr.Simpson(1, 5, 1000, 4) - 4.047) <= 0.1);
    }

    @Test
    public void test5() {

        Integr integr = new Integr();

        Assert.assertTrue(Math.abs(integr.Prymougolnik(1, 10, 1000, 5) - 20.415) <= 0.1);
        Assert.assertTrue(Math.abs(integr.Trapec(1, 10, 1000, 5) - 20.415) <= 0.1);
        Assert.assertTrue(Math.abs(integr.Simpson(1, 10, 1000, 5) - 20.415) <= 0.1);
    }

    @Test
    public void test6() {

        Integr integr = new Integr();

        Assert.assertTrue(Math.abs(integr.Prymougolnik(2, 4, 1000, 6) - 8) <= 0.1);
        Assert.assertTrue(Math.abs(integr.Trapec(2, 4, 1000, 6) - 8) <= 0.1);
        Assert.assertTrue(Math.abs(integr.Simpson(2, 4, 1000, 6) - 8) <= 0.1);
    }

    @Test
    public void test7() {

        Integr integr = new Integr();

        Assert.assertTrue(Math.abs(integr.Prymougolnik(2, 4, 1000, 7) - 10) <= 0.1);
        Assert.assertTrue(Math.abs(integr.Trapec(2, 4, 1000, 7) - 10) <= 0.1);
        Assert.assertTrue(Math.abs(integr.Simpson(2, 4, 1000, 7) - 10) <= 0.1);
    }

    @Test
    public void test8() {

        Integr integr = new Integr();

        Assert.assertTrue(Math.abs(integr.Prymougolnik(2, 4, 1000, 8) - 47.2) <= 0.1);
        Assert.assertTrue(Math.abs(integr.Trapec(2, 4, 1000, 8) - 47.2) <= 0.1);
        Assert.assertTrue(Math.abs(integr.Simpson(2, 4, 1000, 8) - 47.2) <= 0.1);
    }

    @Test
    public void test9() {

        Integr integr = new Integr();

        Assert.assertTrue(Math.abs(integr.Prymougolnik(2, 4, 1000, 9) - 70.9556) <= 0.1);
        Assert.assertTrue(Math.abs(integr.Trapec(2, 4, 1000, 9) - 70.956) <= 0.1);
        Assert.assertTrue(Math.abs(integr.Simpson(2, 4, 1000, 9) - 70.956) <= 0.1);
    }

    @Test
    public void test10() {

        Integr integr = new Integr();

        System.out.println("Интеграл по методу прямоугольника: " + integr.Prymougolnik(1, 2, 1000, 10));
        Assert.assertTrue(Math.abs(integr.Prymougolnik(1, 2, 1000, 10) - 2.05) <= 0.1);
        Assert.assertTrue(Math.abs(integr.Trapec(1, 2, 1000, 10) - 2.05) <= 0.1);
        Assert.assertTrue(Math.abs(integr.Simpson(1, 2, 1000, 10) - 2.05) <= 0.1);
    }

}