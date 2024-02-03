package br.com.mlb.math;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SimpleMathTest {
    //nomeclatura: test[System Under test]_[Condition or Stage Changed]_[Expected Result]()
    @Test
    void testSum(){
        SimpleMath math = new SimpleMath();
        double firstNumber = 5.2D;
        double secondNumber = 3D;

        double actual = math.sum(firstNumber, secondNumber);
        double expected = 8.2D;

        assertEquals(expected, actual,
                () -> String.format("%s - %s did not produce result %s", firstNumber, secondNumber, expected));
        assertNotEquals(9D, actual);
    }

    @Test
    void testSubtraction(){
        SimpleMath math = new SimpleMath();
        double firstNumber = 5D;
        double secondNumber = 3D;

        double actual = math.subtraction(firstNumber, secondNumber);
        double expected = 2D;

        assertEquals(expected, actual,
                () -> String.format("%s - %s did not produce result %s", firstNumber, secondNumber, expected));
    }

    @Test
    void testMultiplication(){
        SimpleMath math = new SimpleMath();
        double firstNumber = 7D;
        double secondNumber = 3D;

        double actual = math.multiplication(firstNumber, secondNumber);
        double expected = 21D;

        assertEquals(expected, actual,
                () -> String.format("%s - %s did not produce result %s", firstNumber, secondNumber, expected));
    }
    @Test
    void testDivision(){
        SimpleMath math = new SimpleMath();
        double firstNumber = 10D;
        double secondNumber = 2D;

        double actual = math.division(firstNumber, secondNumber);
        double expected = 5D;

        assertEquals(expected, actual,
                () -> String.format("%s - %s did not produce result %s", firstNumber, secondNumber, expected));
    }
    @Test
    void testMean(){
        SimpleMath math = new SimpleMath();
        double firstNumber = 10D;
        double secondNumber = 2D;

        double actual = math.mean(firstNumber, secondNumber);
        double expected = 6D;

        assertEquals(expected, actual,
                () -> String.format("%s - %s did not produce result %s", firstNumber, secondNumber, expected));
    }
    @Test
    void testSquareRoot(){
        SimpleMath math = new SimpleMath();
        double number = 36D;

        double actual = math.squareRoot(number);
        double expected = 6D;

        assertEquals(expected, actual,
                () -> String.format("Square Root of %s is not %s", number, expected));
    }
}
