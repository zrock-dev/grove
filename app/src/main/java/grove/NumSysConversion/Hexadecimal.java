package grove.NumSysConversion;

import grove.NumSysConversion.Converters.HexadecimalConverter;
import grove.NumSysConversion.Utils.ConversionValidator;

public class Hexadecimal implements HexadecimalConverter {
    private final Decimal decimal;

    public Hexadecimal() {
        decimal = new Decimal();
    }

    @Override
    public long hexadecimalToDecimal(String hexadecimal) {
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
        return decimal;
    }

    @Override
    public String hexadecimalToBinary(String hexadecimal) {
        validateHexadecimalValue(hexadecimal);
        long decimal = hexadecimalToDecimal(hexadecimal);
        return this.decimal.decimalToBinary((int) decimal);
    }

    @Override
    public String hexadecimalToOctal(String hexadecimal) {
        validateHexadecimalValue(hexadecimal);
        long decimal = hexadecimalToDecimal(hexadecimal);
        return this.decimal.decimalToOctal(decimal);
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
}
