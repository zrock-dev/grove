package grove.NumericalSystemConvertion;

import grove.NumSysConversion.Decimal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DecimalTest {
    private final Decimal decimal = new Decimal();

    @Test
    public void testDecimalToBinary() {
        assertEquals("1010", decimal.decimalToBinary(10));
        assertEquals("1111", decimal.decimalToBinary(15));
        assertEquals("100110", decimal.decimalToBinary(38));
        assertThrows(IllegalArgumentException.class, () -> decimal.decimalToBinary(-10));
    }

    @Test
    public void testDecimalToOctal() {
        assertEquals("12", decimal.decimalToOctal(10));
        assertEquals("17", decimal.decimalToOctal(15));
        assertEquals("46", decimal.decimalToOctal(38));
        assertThrows(IllegalArgumentException.class, () -> decimal.decimalToOctal(-10));
    }

    @Test
    public void testDecimalToHexadecimal() {
        assertEquals("A", decimal.decimalToHexadecimal(10));
        assertEquals("F", decimal.decimalToHexadecimal(15));
        assertEquals("26", decimal.decimalToHexadecimal(38));
        assertThrows(IllegalArgumentException.class, () -> decimal.decimalToHexadecimal(-10));
    }

    @Test
    public void testDecimalException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> decimal.decimalToBinary(-10));
        String expectedMessage = "The number can not be negative.";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

}
