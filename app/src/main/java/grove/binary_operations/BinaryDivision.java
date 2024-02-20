package grove.binary_operations;

public class BinaryDivision implements BinaryOperable {

    private long make(long binary1, long binary2) {
        if (binary2 == 0)
            return -1;
        if (binary1 == 0)
            return 0;

        long bin1 = Long.parseLong(String.valueOf(binary1), 2);
        long bin2 = Long.parseLong(String.valueOf(binary2), 2);
        long result = bin1 / bin2;

        return Long.parseLong(Long.toBinaryString(result));
    }

    @Override
    public long make(long... numbers) {
        long result = 0;
        if (numbers.length > 0) {
            result = numbers[0];
            for (int i = 1; i < numbers.length; i++) {
                result = make(result, numbers[i]);
                if (result == -1)
                    break;
            }

        }

        return result;
    }

}
