package grove.binary_operations;

public class BinarySubtraction implements BinaryOperable {

    private long make(String binary1, String binary2) {
        if (Long.parseLong(binary1) < Long.parseLong(binary2))
            return -1;

        if (Long.parseLong(binary2) == 0)
            return Long.parseLong(binary1);

        int maxLength = Math.max(binary1.length(), binary2.length());

        String binary1Left = leftPad(binary1, maxLength);
        String binary2Left = leftPad(binary2, maxLength);

        StringBuilder result = new StringBuilder();
        int carry = 0;

        for (int i = maxLength - 1; i >= 0; i--) {
            int binary1Int = binary1Left.charAt(i) - '0';
            int binary2Int = binary2Left.charAt(i) - '0';

            int subtraction = binary1Int - binary2Int - carry;
            if (subtraction < 0) {
                subtraction += 2;
                carry = 1;
            } else {
                carry = 0;
            }

            result.insert(0, subtraction);
        }

        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        return Long.parseLong(result.toString());
    }

    private String leftPad(String str, int length) {
        StringBuilder padded = new StringBuilder(str);
        while (padded.length() < length) {
            padded.insert(0, '0');
        }
        return padded.toString();
    }

    @Override
    public long make(long... numbers) {
        long result = 0;

        if (numbers.length > 0) {
            result = numbers[0];
            for (int i = 1; i < numbers.length; i++) {
                result = make(
                        String.valueOf(result), String.valueOf(numbers[i]));
                if (result == -1) break;
            }
        }

        return result;
    }

}
