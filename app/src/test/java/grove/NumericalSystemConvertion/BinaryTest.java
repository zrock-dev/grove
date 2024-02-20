package grove.NumericalSystemConvertion;

import grove.NumSysConversion.Binary;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BinaryTest {
    private final Binary binary = new Binary();

    @Test
    public void testBinaryToDecimal() {
        assertEquals(2, binary.binaryToDecimal("10"));
        assertEquals(15, binary.binaryToDecimal("1111"));
        assertEquals(38, binary.binaryToDecimal("100110"));
    }

    @Test
    public void testBinaryToOctal() {
        assertEquals("2", binary.binaryToOctal("10"));
        assertEquals("17", binary.binaryToOctal("1111"));
        assertEquals("46", binary.binaryToOctal("100110"));
    }

    @Test
    public void testBinaryToHexadecimal() {
        assertEquals("2", binary.binaryToHexadecimal("10"));
        assertEquals("F", binary.binaryToHexadecimal("1111"));
        assertEquals("26", binary.binaryToHexadecimal("100110"));
    }

    @Test
    public void testBinaryException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> binary.binaryToDecimal("102"));
        String expectedMessage = "The binary string can only contain the characters '0' and '1'.";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }
}
