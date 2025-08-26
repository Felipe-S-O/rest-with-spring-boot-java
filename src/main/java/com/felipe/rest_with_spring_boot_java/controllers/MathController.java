package com.felipe.rest_with_spring_boot_java.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipe.rest_with_spring_boot_java.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/math")
public class MathController {

    // http://localhost:8080/math/sum/3/5
    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
            throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Defina um valor numérico válido.");
        }
        return covertToDouble(numberOne) + covertToDouble(numberTwo);
    }

    private Double covertToDouble(String strNumber) throws IllegalAccessException {
        if (strNumber == null || strNumber.isEmpty())
            throw new UnsupportedMathOperationException("Defina um valor numérico válido.");
        String number = strNumber.replaceAll(",", ".");// Moeda Americana x Brasileira
        return Double.parseDouble(number);
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isEmpty())
            return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    // http://localhost:8080/math/subtraction/3/5
    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
            throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Defina um valor numérico válido.");
        }
        return covertToDouble(numberOne) - covertToDouble(numberTwo);
    }

    // http://localhost:8080/math/multiplication/3/5
    @RequestMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(@PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Defina um valor numérico válido.");

        return covertToDouble(numberOne) * covertToDouble(numberTwo);

    }

    // http://localhost:8080/math/division/3/5
    @RequestMapping("division/{numberOne}/{numberTwo}")
    public Double division(@PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Defina um valor numérico válido.");

        return covertToDouble(numberOne) / covertToDouble(numberTwo);

    }

    // http://localhost:8080/math/mean/3/5
    @RequestMapping("/mean/{numberOne}/{numberTwo}")
    public Double maen(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
            throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Defina um valor numérico válido.");

        return (covertToDouble(numberOne) + covertToDouble(numberTwo)) / 2;
    }

    // http://localhost:8080/math/squareRoot/81
    @RequestMapping("/squareroot/{number}")
    public Double squareRoot(@PathVariable("number") String number) throws Exception {
        if (!isNumeric(number))
            throw new UnsupportedMathOperationException("Defina um valor numérico válido.");

        return Math.sqrt(covertToDouble(number));

    }
}
