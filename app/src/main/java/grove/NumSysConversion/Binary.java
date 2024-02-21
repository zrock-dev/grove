package grove.NumSysConversion;

import grove.NumSysConversion.Converters.Conversion;
import grove.NumSysConversion.Utils.ConversionValidator;

public class Binary implements Conversion {
    private final Decimal decimal;

    public Binary() {
        decimal = new Decimal();
    }

    private String binaryToDecimal(String binary) {
        validateBinary(binary);
        long decimal = 0;
        int length = binary.length();
        for (int i = 0; i < length; i++) {
            char c = binary.charAt(length - 1 - i);
            if (c == '1') {
                decimal += (long) Math.pow(2, i);
            }
        }
        return Long.toString(decimal);
    }

    private String binaryToOctal(String binary) {
        validateBinary(binary);
        long decimal = Long.parseLong(binaryToDecimal(binary));
        return Long.toOctalString(decimal);
    }

    private String binaryToHexadecimal(String binary) {
        validateBinary(binary);
        long decimal = Long.parseLong(binaryToDecimal(binary));
        return this.decimal.makeConversion( 16, Long.toString(decimal));
    }

    private void validateBinary(String binary) {
        ConversionValidator.validateEmptyOrNullString(binary);
        ConversionValidator.validateBinaryValue(binary);
    }

    @Override
    public String makeConversion(int targetBase, String value) {
        if (targetBase == 10) return binaryToDecimal(value);
        if (targetBase == 8) return binaryToOctal(value);
        if (targetBase == 16) return binaryToHexadecimal(value);
        return "Invalid target base";
    }
}
