package grove.NumSysConversion;

import grove.NumSysConversion.Converters.DecimalConverter;

public class Decimal implements DecimalConverter {
    @Override
    public String decimalToBinary(long decimal) {
        StringBuilder stringBuilder;
        if (decimal > 0) {
            String binary = "";
            while (decimal != 0) {
                binary += decimal % 2;
                decimal /= 2;
            }
            stringBuilder = new StringBuilder(binary);
            return stringBuilder.reverse().toString();
        }
        return null;
    }

    @Override
    public String decimalToOctal(long decimal) {
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

    @Override
    public String decimalToHexadecimal(long decimal) {
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
}
