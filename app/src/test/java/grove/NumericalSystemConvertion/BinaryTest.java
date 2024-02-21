package grove.NumericalSystemConvertion;

import grove.NumSysConversion.Binary;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BinaryTest {
    private final Binary binary = new Binary();

    @Test
    public void testBinaryToDecimal() {
        assertEquals("2", binary.makeConversion(10, "10"));
        assertEquals("15", binary.makeConversion(10, "1111"));
        assertEquals("38", binary.makeConversion(10, "100110"));
    }

    @Test
    public void testBinaryToOctal() {
        assertEquals("2", binary.makeConversion(8, "10"));
        assertEquals("17", binary.makeConversion(8, "1111"));
        assertEquals("46", binary.makeConversion(8, "100110"));
    }

    @Test
    public void testBinaryToHexadecimal() {
        assertEquals("2", binary.makeConversion(16, "10"));
        assertEquals("F", binary.makeConversion(16, "1111"));
        assertEquals("26", binary.makeConversion(16, "100110"));
    }

    @Test
    public void testBinaryException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> binary.makeConversion(10, "102"));
        String expectedMessage = "The binary string can only contain the characters '0' and '1'.";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }
}
