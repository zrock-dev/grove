package grove.binary_operations;

public class BinaryMultiplication implements BinaryOperable {

    private long calc(long binary1, long binary2) {
        int i = 0;
        long remainder = 0;
        long result = 0;
        long[] sum = new long[20];
        while (binary1 != 0 || binary2 != 0) {
            sum[i++] = (binary1 % 10 + binary2 % 10 + remainder) % 2;
            remainder = (binary1 % 10 + binary2 % 10 + remainder) / 2;
            binary1 = binary1 / 10;
            binary2 = binary2 / 10;
        }
        if (remainder != 0) {
            sum[i++] = remainder;
        }
        --i;
        while (i >= 0) {
            result = result * 10 + sum[i--];
        }
        return result;
    }

    private long make(long binary1, long binary2) {
        long result = 0;
        long d, f = 1;
        while (binary2 != 0) {
            d = (binary2 % 10);
            if (d == 1) {
                binary1 = binary1 * f;
                result = calc(binary1, result);
            } else {
                binary1 = binary1 * f;
            }
            binary2 = binary2 / 10;
            f = 10;
        }
        return result;
    }

    @Override
    public long make(long... numbers) {
        long result = 0;
        if (numbers.length == 1) {
            return numbers[0];
        }

        if (numbers.length > 1) {
            result = numbers[0];
            for (int i = 1; i < numbers.length; i++) {
                result = make(result, numbers[i]);
            }
        }

        return result;
    }
}
