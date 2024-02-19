package grove.binary_operations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SubtractionTest {

    private static BinarySubtraction binarySubtraction;

    @BeforeAll
    public static void init() {
        binarySubtraction = new BinarySubtraction();
    }

    @Test
    public void testSimpleBinarySubtraction() {
        assertEquals(0, binarySubtraction.make(1, 1));
    }

    @Test
    public void testBorrowBinarySubtraction() {
        assertEquals(1, binarySubtraction.make(10, 1));
    }

    @Test
    public void testDifferentLengthBinarySubtraction() {
        assertEquals(1, binarySubtraction.make(100, 11));
    }

    @Test
    public void testLargeBinarySubtraction() {
        assertEquals(100001, binarySubtraction.make(1101010, 1011));
    }

}
