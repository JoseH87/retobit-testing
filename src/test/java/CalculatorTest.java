import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CalculatorTest {
    Calculator calculator;
    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
    }
    @Test
    @DisplayName("Suma de numeros positivos")
    public void testAdd(){
        double num1 = 2.0;
        double num2 = 1.0;
        double result = calculator.add(num1,num2);
        assertEquals(result,3.0);

    }
    @Test
    @DisplayName("Resta de numeros positivos")
    public void testSubtract(){
        double num1 = 2.0;
        double num2 = 1.0;
        double result = calculator.subtract(num1,num2);
        assertEquals(result,1.0);

    }
    @Test
    @DisplayName("Multiplicación de numeros positivos")
    public void testMultiply(){
        double num1 = 3.0;
        double num2 = 5.0;
        double result = calculator.multiply(num1,num2);
        assertEquals(result,15.0);
    }
    @Test
    @DisplayName("Division de numeros positivos")
    public void testDivide(){
        double num1 = 4.0;
        double num2 = 2.0;
        double result = calculator.divide(num1,num2);
        assertEquals(result,2.0);
    }
    @Test
    @DisplayName("Division por cero")
    public void testDivideByZeroThrowsException() throws ArithmeticException{
            double num1 = 2.0;
            double num2 = 0.0;
        assertThrows(
                ArithmeticException.class,
                () -> calculator.divide(num1,num2),
                "Cannot divide by zero"
        );

    }
    @DisplayName("Suma de numeros negativos")
    public void testAddNegative(){
        double num1 = 2.0;
        double num2 = -1.0;
        double result = calculator.add(num1,num2);
        assertFalse(num1 > 0 && num2 > 0);
    }
    @Test
    @DisplayName("Resta de numeros negativos")
    public void testSubtractNegative(){
        double num1 = 2.0;
        double num2 = -1.0;
        double result = calculator.subtract(num1,num2);
        assertFalse(num1 > 0 && num2 > 0);
    }
    @Test
    @DisplayName("Multiplicación de numeros negativos")
    public void testMultiplyNegative(){
        double num1 = 3.0;
        double num2 = -5.0;
        double result = calculator.multiply(num1,num2);
        assertFalse(num1 > 0 && num2 > 0);
    }
    @Test
    @DisplayName("Division de numeros negativos")
    public void testDivideNegative(){
        double num1 = 4.0;
        double num2 = -2.0;
        double result = calculator.divide(num1,num2);
        assertFalse(num1 > 0 && num2 > 0);
    }

    @Test
    @DisplayName("Listas vacias")
    public void testEmptyList(){
        List<Double> numbers = new ArrayList<>();
        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.maximum(numbers),
                "List cannot be empty or null"
        );
    }

}
