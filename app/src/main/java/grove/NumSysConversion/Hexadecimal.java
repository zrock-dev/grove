package grove.NumSysConversion;

import grove.NumSysConversion.Converters.Conversion;
import grove.NumSysConversion.Utils.ConversionValidator;

public class Hexadecimal implements Conversion {
    private final Decimal decimal;

    public Hexadecimal() {
        decimal = new Decimal();
    }

    private String hexadecimalToDecimal(String hexadecimal) {
        validateHexadecimalValue(hexadecimal);
        long decimal = 0;
        int pow = 0;
        for (int i = hexadecimal.length() - 1; i >= 0; i--) {
            int powHex = (int) Math.pow(16, pow);
            if (!Character.isDigit(hexadecimal.charAt(i))) {
                decimal += getIndexLetter(hexadecimal.charAt(i)) * powHex;
            } else {
                decimal += (long) Character.getNumericValue(hexadecimal.charAt(i)) * powHex;
            }
            pow++;
        }
        return Long.toString(decimal);
    }

    private String hexadecimalToBinary(String hexadecimal) {
        validateHexadecimalValue(hexadecimal);
        long decimal = Long.parseLong(hexadecimalToDecimal(hexadecimal));
        return this.decimal.makeConversion(2, String.valueOf(decimal));
    }

    private String hexadecimalToOctal(String hexadecimal) {
        validateHexadecimalValue(hexadecimal);
        long decimal = Long.parseLong(hexadecimalToDecimal(hexadecimal));
        return this.decimal.makeConversion(8, String.valueOf(decimal));
    }

    private long getIndexLetter(char letter) {
        long count = 10;
        char initChar = 'A';
        while (Character.toUpperCase(initChar) != letter) {
            count++;
            initChar++;
        }
        return count;
    }

    private void validateHexadecimalValue(String hexadecimal) {
        ConversionValidator.validateEmptyOrNullString(hexadecimal);
        ConversionValidator.validateHexadecimalValue(hexadecimal);
    }

    @Override
    public String makeConversion(int targetBase, String value) {
        if (targetBase == 10) return hexadecimalToDecimal(value);
        else if (targetBase == 2) return hexadecimalToBinary(value);
        else if (targetBase == 8) return hexadecimalToOctal(value);
        return "Invalid target base";
    }
}
