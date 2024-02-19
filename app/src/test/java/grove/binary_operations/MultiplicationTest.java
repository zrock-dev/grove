package grove.binary_operations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MultiplicationTest {

    private static BinaryMultiplication binaryMultiplication;

    @BeforeAll
    public static void init() {
        binaryMultiplication = new BinaryMultiplication();
    }

    @Test
    public void testSimpleBinaryMultiplication() {
        assertEquals(10, binaryMultiplication.make(10, 1));
    }

    @Test
    public void testZeroMultiplication() {
        assertEquals(0, binaryMultiplication.make(100, 0));
    }

    @Test
    public void testLargeBinaryMultiplication() {
        assertEquals(11111100, binaryMultiplication.make(11110, 111));
    }

    @Test
    public void testMultiplicationByOne() {
        assertEquals(1001111, binaryMultiplication.make(1001111, 1));
    }
}
