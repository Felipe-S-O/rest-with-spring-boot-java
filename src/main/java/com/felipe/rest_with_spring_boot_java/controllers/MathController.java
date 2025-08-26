package com.felipe.rest_with_spring_boot_java.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipe.rest_with_spring_boot_java.exception.UnsupportedMathOperationException;
import com.felipe.rest_with_spring_boot_java.math.SimpleMath;
import com.felipe.rest_with_spring_boot_java.request.converters.NumberConverter;

@RestController
@RequestMapping("/math")
public class MathController {

    private SimpleMath math = new SimpleMath();

    // http://localhost:8080/math/sum/3/5
    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
            throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Defina um valor numérico válido.");
        }
        return math.sum(NumberConverter.covertToDouble(numberOne), NumberConverter.covertToDouble(numberTwo));
    }

    // http://localhost:8080/math/subtraction/3/5
    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
            throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Defina um valor numérico válido.");
        }
        return math.subtraction(NumberConverter.covertToDouble(numberOne), NumberConverter.covertToDouble(numberTwo));
    }

    // http://localhost:8080/math/multiplication/3/5
    @RequestMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(@PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Defina um valor numérico válido.");

        return math.multiplication(NumberConverter.covertToDouble(numberOne),
                NumberConverter.covertToDouble(numberTwo));

    }

    // http://localhost:8080/math/division/3/5
    @RequestMapping("division/{numberOne}/{numberTwo}")
    public Double division(@PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Defina um valor numérico válido.");

        return math.division(NumberConverter.covertToDouble(numberOne), NumberConverter.covertToDouble(numberTwo));

    }

    // http://localhost:8080/math/mean/3/5
    @RequestMapping("/mean/{numberOne}/{numberTwo}")
    public Double maen(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
            throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Defina um valor numérico válido.");

        return math.maen(NumberConverter.covertToDouble(numberOne), NumberConverter.covertToDouble(numberTwo));
    }

    // http://localhost:8080/math/squareRoot/81
    @RequestMapping("/squareroot/{number}")
    public Double squareRoot(@PathVariable("number") String number) throws Exception {
        if (!NumberConverter.isNumeric(number))
            throw new UnsupportedMathOperationException("Defina um valor numérico válido.");

        return math.squareRoot(NumberConverter.covertToDouble(number));

    }
}
