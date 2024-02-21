package grove.NumericalSystemConvertion;

import grove.NumSysConversion.Hexadecimal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HexadecimalTest {
    private final Hexadecimal hexadecimal = new Hexadecimal();

    @Test
    public void testHexadecimalToDecimal() {
        assertEquals("255", hexadecimal.makeConversion(10, "FF"));
        assertEquals("16", hexadecimal.makeConversion(10, "10"));
    }

    @Test
    public void testHexadecimalToBinary() {
        assertEquals("11111111", hexadecimal.makeConversion(2, "FF"));
        assertEquals("10000", hexadecimal.makeConversion(2, "10"));
    }

    @Test
    public void testHexadecimalToOctal() {
        assertEquals("377", hexadecimal.makeConversion(8, "FF"));
        assertEquals("20", hexadecimal.makeConversion(8, "10"));
    }

    @Test
    public void testHexadecimalException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> hexadecimal.makeConversion(2, "G"));
        String expectedMessage = "The hexadecimal string can only contain the characters '0' to '9' and 'A' to 'F'.";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);

        exception = assertThrows(IllegalArgumentException.class, () -> hexadecimal.makeConversion(2, ""));
        expectedMessage = "The value can not be null or empty.";
        actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);

        exception = assertThrows(IllegalArgumentException.class, () -> hexadecimal.makeConversion(2, null));
        expectedMessage = "The value can not be null or empty.";
        actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }
}
