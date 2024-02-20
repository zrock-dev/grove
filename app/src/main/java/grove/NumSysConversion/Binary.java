package grove.NumSysConversion;

import grove.NumSysConversion.Converters.BinaryConverter;

public class Binary implements BinaryConverter {
    private final Decimal decimal;

    public Binary() {
        decimal = new Decimal();
    }

    @Override
    public long binaryToDecimal(String binary) {
        long decimal = 0;
        int length = binary.length();
        for (int i = 0; i < length; i++) {
            char c = binary.charAt(length - 1 - i);
            if (c == '1') {
                decimal += (long) Math.pow(2, i);
            }
        }
        return decimal;
    }

    @Override
    public String binaryToOctal(String binary) {
        long decimal = binaryToDecimal(binary);
        return Long.toOctalString(decimal);
    }

    @Override
    public String binaryToHexadecimal(String binary) {
        long decimal = binaryToDecimal(binary);
        return this.decimal.decimalToHexadecimal(decimal);
    }
}
