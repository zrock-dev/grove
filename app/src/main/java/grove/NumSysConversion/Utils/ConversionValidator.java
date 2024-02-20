package grove.NumSysConversion.Utils;

public class ConversionValidator {
    public static void validateEmptyOrNullString(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("The value can not be null or empty.");
        }
    }

    public static void validateNonNegative(long decimal) {
        if (decimal < 0) {
            throw new IllegalArgumentException("The number can not be negative.");
        }
    }

    public static void validateOctalValue(long octal) {
        while (octal != 0) {
            long digit = octal % 10;
            if (digit < 0 || digit > 7) {
                throw new IllegalArgumentException("The octal string can only contain characters from '0' to '7'.");
            }
            octal /= 10;
        }
    }

    public static void validateBinaryValue(String binary) {
        for (char c : binary.toCharArray()) {
            if (c != '0' && c != '1') {
                throw new IllegalArgumentException("The binary string can only contain the characters '0' and '1'.");
            }
        }
    }

    public static void validateHexadecimalValue(String hexadecimal) {
        for (char c : hexadecimal.toCharArray()) {
            if (!Character.isDigit(c) && !(c >= 'A' && c <= 'F') && !(c >= 'a' && c <= 'f')) {
                throw new IllegalArgumentException("The hexadecimal string can only contain the characters '0' to '9' and 'A' to 'F'.");
            }
        }
    }
}
