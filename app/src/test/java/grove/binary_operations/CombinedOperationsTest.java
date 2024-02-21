package grove.binary_operations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CombinedOperationsTest {

    private static BinarySum sum;
    private static BinarySubtraction subtraction;
    private static BinaryMultiplication multiplication;
    private static BinaryDivision division;

    @BeforeAll
    public static void init() {
        sum = new BinarySum();
        subtraction = new BinarySubtraction();
        multiplication = new BinaryMultiplication();
        division = new BinaryDivision();
    }

    @Test
    public void combinedOperations() {
        long result = subtraction.make(
                        division.make(
                            multiplication.make(
                                sum.make(10111, 100, 11),
                                100),
                            10),
                        11110);
        assertEquals(11110, result);
    }

}
