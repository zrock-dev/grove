package grove.NumSysConversion.Converters;

public interface DecimalConverter {
    String decimalToBinary(long decimal);
    String decimalToOctal(long decimal);
    String decimalToHexadecimal(long decimal);
}
