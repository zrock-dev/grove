package grove.NumSysConversion;

import grove.NumSysConversion.Converters.Conversion;
import grove.NumSysConversion.Utils.ConversionValidator;

public class Octal implements Conversion {
    private final Decimal decimal;

    public Octal() {
        decimal = new Decimal();
    }

    private long octalToDecimal(long octal) {
        ConversionValidator.validateOctalValue(octal);
        long decimal = 0;
        int pow = 0;
        while (octal != 0) {
            long lastDigitNumber = octal % 10;
            long powOctal = (long) Math.pow(8, pow);
            decimal += lastDigitNumber * powOctal;
            octal /= 10;
            pow++;
        }
        return decimal;
    }

    private String octalToBinary(long octal) {
        ConversionValidator.validateOctalValue(octal);
        long decimal = octalToDecimal(octal);
        return this.decimal.makeConversion(2, String.valueOf(decimal));
    }

    private String octalToHexadecimal(long octal) {
        ConversionValidator.validateOctalValue(octal);
        long decimal = octalToDecimal(octal);
        return this.decimal.makeConversion(16, String.valueOf(decimal));
    }

    @Override
    public String makeConversion(int targetBase, String value) {
        if (targetBase == 10) return String.valueOf(octalToDecimal(Long.parseLong(value)));
        else if (targetBase == 2) return octalToBinary(Long.parseLong(value));
        else if (targetBase == 16) return octalToHexadecimal(Long.parseLong(value));
        return "Invalid target base";
    }
}
