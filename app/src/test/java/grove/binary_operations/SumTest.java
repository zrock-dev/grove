package grove.binary_operations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SumTest {

    private static BinarySum binarySum;

    @BeforeAll
    public static void init() {
        binarySum = new BinarySum();
    }

    @Test
    public void testSimpleBinarySum() {
        assertEquals(10, binarySum.make(1, 1));
    }

    @Test
    public void testDifferentLengthBinarySum() {
        assertEquals(101, binarySum.make(100, 1));
    }

    @Test
    public void testCarryBinarySum() {
        assertEquals(1000, binarySum.make(111, 1));
    }

    @Test
    public void testDifferentLengthAndCarryBinarySum() {
        assertEquals(10000, binarySum.make(1111, 1));
    }

    @Test
    public void testLargeBinarySum() {
        assertEquals(110000010, binarySum.make(10000000, 100000010));
    }

    @Test
    public void testLargerBinarySum() {
        assertEquals(1111110100, binarySum.make(0, 1011100, 10111000, 0, 1011100000));
    }
}
