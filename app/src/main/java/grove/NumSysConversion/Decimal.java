package grove.NumSysConversion;

import grove.NumSysConversion.Converters.Conversion;
import grove.NumSysConversion.Utils.ConversionValidator;

public class Decimal implements Conversion {
    private String decimalToBinary(long decimal) {
        ConversionValidator.validateNonNegative(decimal);
        if (decimal == 0) return "0";
        StringBuilder stringBuilder;
        String binary = "";
        while (decimal != 0) {
            binary += decimal % 2;
            decimal /= 2;
        }
        stringBuilder = new StringBuilder(binary);
        return stringBuilder.reverse().toString();
    }

    private String decimalToOctal(long decimal) {
        ConversionValidator.validateNonNegative(decimal);
        StringBuilder stringBuilder;
        if (decimal > 8) {
            String octal = "";
            while (decimal > 8) {
                octal += decimal % 8;
                decimal /= 8;
            }
            octal += decimal;
            stringBuilder = new StringBuilder(octal);
            return stringBuilder.reverse().toString();
        } else {
            return Long.toString(decimal);
        }
    }

    private String decimalToHexadecimal(long decimal) {
        ConversionValidator.validateNonNegative(decimal);
        if (decimal == 0) return "0";
        StringBuilder stringBuilder;
        String hexadecimalNumber = "0123456789ABCDEF";
        String hexadecimal = "";
        while (decimal > 0) {
            int module = (int) (decimal % 16);
            hexadecimal += hexadecimalNumber.charAt(module);
            decimal /= 16;
        }
        stringBuilder = new StringBuilder(hexadecimal);
        return stringBuilder.reverse().toString();
    }

    @Override
    public String makeConversion(int targetBase, String value) {
        if (targetBase == 2) return decimalToBinary(Long.parseLong(value));
        else if (targetBase == 8) return decimalToOctal(Long.parseLong(value));
        else if (targetBase == 16) return decimalToHexadecimal(Long.parseLong(value));
        return "Invalid target base";
    }
}
