package by.it.rydzeuski.calc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    private Parser parser;

    @Before
    public void setUp() {
        parser = new Parser();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void addTest() throws CalcException {
        Var actualScalar = parser.calc("2+3*2");
        double actual = Double.parseDouble(actualScalar.toString());
        double expected = 8;
        assertEquals(expected, actual, 1e-5);
    }

    @Test
    public void expressionScalar() throws CalcException {
        double actual = Double.parseDouble(parser.calc("A=2+5.3").toString());
        assertEquals(7.3, actual, 1e-5);
        actual = Double.parseDouble(parser.calc("B=A*3.5").toString());
        assertEquals(25.55, actual, 1e-5);
        actual = Double.parseDouble(parser.calc("B1=B+0.11*-5").toString());
        assertEquals(25, actual, 1e-5);
        actual = Double.parseDouble(parser.calc("B=A/2-1").toString());
        assertEquals(2.65, actual, 1e-5);
    }


}