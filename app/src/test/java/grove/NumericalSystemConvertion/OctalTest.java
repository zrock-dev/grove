package grove.NumericalSystemConvertion;

import grove.NumSysConversion.Octal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OctalTest {
    private final Octal octal = new Octal();

    @Test
    public void testOctalToDecimal() {
        assertEquals(8, octal.octalToDecimal(10));
        assertEquals(63, octal.octalToDecimal(77));
    }

    @Test
    public void testOctalToBinary() {
        assertEquals("1000", octal.octalToBinary(10));
        assertEquals("111111", octal.octalToBinary(77));
    }

    @Test
    public void testOctalToHexadecimal() {
        assertEquals("8", octal.octalToHexadecimal(10));
        assertEquals("3F", octal.octalToHexadecimal(77));
    }

    @Test
    public void testOctalException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> octal.octalToDecimal(8));
        String expectedMessage = "The octal string can only contain characters from '0' to '7'.";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }
}
