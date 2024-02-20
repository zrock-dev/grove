package grove.NumSysConversion;

import grove.NumSysConversion.Converters.OctalConverter;

public class Octal implements OctalConverter {
    private final Decimal decimal;

    public Octal() {
        decimal = new Decimal();
    }

    @Override
    public long octalToDecimal(long octal) {
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

    @Override
    public String octalToBinary(long octal) {
        long decimal = octalToDecimal(octal);
        return this.decimal.decimalToBinary(decimal);
    }

    @Override
    public String octalToHexadecimal(long octal) {
        long decimal = octalToDecimal(octal);
        return this.decimal.decimalToHexadecimal(decimal);
    }
}
