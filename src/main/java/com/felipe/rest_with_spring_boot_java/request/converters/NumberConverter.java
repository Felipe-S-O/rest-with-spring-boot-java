package com.felipe.rest_with_spring_boot_java.request.converters;

import com.felipe.rest_with_spring_boot_java.exception.UnsupportedMathOperationException;

public class NumberConverter {

    public static Double covertToDouble(String strNumber) throws IllegalAccessException {
        if (strNumber == null || strNumber.isEmpty())
            throw new UnsupportedMathOperationException("Defina um valor numérico válido.");
        String number = strNumber.replaceAll(",", ".");// Moeda Americana x Brasileira
        return Double.parseDouble(number);
    }

    public static boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isEmpty())
            return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
