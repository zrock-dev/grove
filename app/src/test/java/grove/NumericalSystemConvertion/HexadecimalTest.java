package grove.NumericalSystemConvertion;

import grove.NumSysConversion.Hexadecimal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HexadecimalTest {
    private final Hexadecimal hexadecimal = new Hexadecimal();

    @Test
    public void testHexadecimalToDecimal() {
        assertEquals(255, hexadecimal.hexadecimalToDecimal("FF"));
        assertEquals(16, hexadecimal.hexadecimalToDecimal("10"));
    }

    @Test
    public void testHexadecimalToBinary() {
        assertEquals("11111111", hexadecimal.hexadecimalToBinary("FF"));
        assertEquals("10000", hexadecimal.hexadecimalToBinary("10"));
    }

    @Test
    public void testHexadecimalToOctal() {
        assertEquals("377", hexadecimal.hexadecimalToOctal("FF"));
        assertEquals("20", hexadecimal.hexadecimalToOctal("10"));
    }

    @Test
    public void testHexadecimalException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> hexadecimal.hexadecimalToDecimal("G"));
        String expectedMessage = "The hexadecimal string can only contain the characters '0' to '9' and 'A' to 'F'.";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);

        exception = assertThrows(IllegalArgumentException.class, () -> hexadecimal.hexadecimalToDecimal(""));
        expectedMessage = "The value can not be null or empty.";
        actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);

        exception = assertThrows(IllegalArgumentException.class, () -> hexadecimal.hexadecimalToDecimal(null));
        expectedMessage = "The value can not be null or empty.";
        actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }
}
