package grove.binary_operations;

public class BinarySum implements BinaryOperable {

    private long sum(long binary1, long binary2) {
        if (binary1 == 0 || binary2 == 0) {
            return (binary1 == 0 && binary2 > 0)
                    ? binary2
                    : (binary2 == 0 && binary1 > 0)
                            ? binary1
                            : 0;
        }
        int i = 0, remainder = 0;

        int[] sum = new int[30];

        while (binary1 != 0 || binary2 != 0) {
            sum[i++] = (int) ((binary1 % 10 + binary2 % 10 + remainder) % 2);
            remainder = (int) ((binary1 % 10 + binary2 % 10 + remainder) / 2);
            binary1 = binary1 / 10;
            binary2 = binary2 / 10;
        }

        if (remainder != 0) {
            sum[i++] = remainder;
        }

        --i;

        StringBuilder stringBuilder = new StringBuilder();
        while (i >= 0) {
            stringBuilder.append(sum[i--]);
        }
        return Long.parseLong(stringBuilder.toString());
    }

    @Override
    public long make(long... numbers) {
        long result = 0;
        if (numbers.length > 1) {
            for (int i = 0; i < numbers.length; i++) {
                result = sum(result, numbers[i]);
            }
        }

        return result;
    }

}
