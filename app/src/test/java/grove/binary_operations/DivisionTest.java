package grove.binary_operations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DivisionTest {

    private static BinaryDivision binaryDivision;

    @BeforeAll
    public static void init() {
        binaryDivision = new BinaryDivision();
    }

    @Test
    public void testSimpleBinaryDivision() {
        assertEquals(10, binaryDivision.make(100, 10));
    }

    @Test
    public void testZeroDivision() {
        assertEquals(-1, binaryDivision.make(100, 0));
    }

    @Test
    public void testLargeBinaryDivision() {
        assertEquals(101, binaryDivision.make(10101, 10));
    }

}
