package grove.NumericalSystemConvertion;

import grove.NumSysConversion.Decimal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DecimalTest {
    private final Decimal decimal = new Decimal();

    @Test
    public void testDecimalToBinary() {
        assertEquals("1010", decimal.makeConversion(2, "10"));
        assertEquals("1111", decimal.makeConversion(2, "15"));
        assertEquals("100110", decimal.makeConversion(2, "38"));
        assertThrows(IllegalArgumentException.class, () -> decimal.makeConversion(2, "-10"));
    }

    @Test
    public void testDecimalToOctal() {
        assertEquals("12", decimal.makeConversion(8, "10"));
        assertEquals("17", decimal.makeConversion(8, "15"));
        assertEquals("46", decimal.makeConversion(8, "38"));
        assertThrows(IllegalArgumentException.class, () -> decimal.makeConversion(8, "-10"));
    }

    @Test
    public void testDecimalToHexadecimal() {
        assertEquals("A", decimal.makeConversion(16, "10"));
        assertEquals("F", decimal.makeConversion(16, "15"));
        assertEquals("26", decimal.makeConversion(16, "38"));
        assertThrows(IllegalArgumentException.class, () -> decimal.makeConversion(16, "-10"));
    }

    @Test
    public void testDecimalException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> decimal.makeConversion(2, "-10"));
        String expectedMessage = "The number can not be negative.";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

}
