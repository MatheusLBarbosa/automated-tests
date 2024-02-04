package br.com.mlb.math;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test Math Operations in SimpleMath class")
public class SimpleMathTest {
    SimpleMath math;
    private double actual;

    @BeforeEach
    void setup() {
        math = new SimpleMath();
    }
    @AfterEach
    void afterEach(){
        System.out.println("Running @AfterEach method!");
    }

    //nomeclatura: test[System Under test]_[Condition or Stage Changed]_[Expected Result]()
    @Test
    @DisplayName("Test 5.2 + 3 = 8.2")
    void testSum() {
        double firstNumber = 5.2D;
        double secondNumber = 3D;

        double actual = math.sum(firstNumber, secondNumber);
        double expected = 8.2D;

        assertEquals(expected, actual,
                () -> String.format("%s - %s did not produce result %s", firstNumber, secondNumber, expected));
        assertNotEquals(9D, actual);
    }

    @Test
    @DisplayName("Test 5 - 3 = 2")
    void testSubtraction() {

        double firstNumber = 5D;
        double secondNumber = 3D;

        double actual = math.subtraction(firstNumber, secondNumber);
        double expected = 2D;

        assertEquals(expected, actual,
                () -> String.format("%s - %s did not produce result %s", firstNumber, secondNumber, expected));
    }

    @Test
    @DisplayName("Test 7 * 3 = 21")
    void testMultiplication() {

        double firstNumber = 7D;
        double secondNumber = 3D;

        double actual = math.multiplication(firstNumber, secondNumber);
        double expected = 21D;

        assertEquals(expected, actual,
                () -> String.format("%s - %s did not produce result %s", firstNumber, secondNumber, expected));
    }

    @Test
    @DisplayName("Test 10 / 2 = 5")
    void testDivision() {

        double firstNumber = 10D;
        double secondNumber = 2D;

        double actual = math.division(firstNumber, secondNumber);
        double expected = 5D;

        assertEquals(expected, actual,
                () -> String.format("%s - %s did not produce result %s", firstNumber, secondNumber, expected));
    }

    @Test
    @DisplayName("Test Division By Zero")
    void testDivision_When_FirstNumberIsDividedByZero_ShouldThrowArithmeticException(){
        double firstNumber = 10D;
        double secondNumber = 0D;

        String expectedMesssage = "Impossible divide by zero!";
        ArithmeticException exception = assertThrows(ArithmeticException.class,
                () -> math.division(firstNumber, secondNumber),
                () -> "Division by zero should throw an ArithmeticException!");
        assertEquals(expectedMesssage, exception.getMessage());
    }

    @Test
    @DisplayName("Test (10 + 2)/2 = 6")
    void testMean() {

        double firstNumber = 10D;
        double secondNumber = 2D;

        double actual = math.mean(firstNumber, secondNumber);
        double expected = 6D;

        assertEquals(expected, actual,
                () -> String.format("%s - %s did not produce result %s", firstNumber, secondNumber, expected));
    }

    @Test
    @DisplayName("Test Square Root 36 = 6")
    void testSquareRoot() {

        double number = 36D;

        double actual = math.squareRoot(number);
        double expected = 6D;

        assertEquals(expected, actual,
                () -> String.format("Square Root of %s is not %s", number, expected));
    }

    @DisplayName("Display name")
    @Test
    void testABCD_When_XYZ_Should() {
        //Given
        //When
        //Then
    }
}
