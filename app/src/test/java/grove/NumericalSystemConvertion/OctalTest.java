package grove.NumericalSystemConvertion;

import grove.NumSysConversion.Octal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OctalTest {
    private final Octal octal = new Octal();

    @Test
    public void testOctalToDecimal() {
        assertEquals("8", octal.makeConversion(10, "10"));
        assertEquals("63", octal.makeConversion(10, "77"));
    }

    @Test
    public void testOctalToBinary() {
        assertEquals("1000", octal.makeConversion(2, "10"));
        assertEquals("111111", octal.makeConversion(2, "77"));
    }

    @Test
    public void testOctalToHexadecimal() {
        assertEquals("8", octal.makeConversion(16, "10"));
        assertEquals("3F", octal.makeConversion(16, "77"));
    }

    @Test
    public void testOctalException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> octal.makeConversion(2, "8"));
        String expectedMessage = "The octal string can only contain characters from '0' to '7'.";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }
}
