package com.felipe.rest_with_spring_boot_java.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    // http://localhost:8080/math/sum/3/5
    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
            throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new Exception();
        }
        return covertToDouble(numberOne) + covertToDouble(numberTwo);
    }

    private Double covertToDouble(String strNumber) {
        if (strNumber == null)
            return 0d;
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

    // http://localhost:8080/math/division/3/5

}
