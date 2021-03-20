package com.controllers;

import com.model.InterfaceCalculatorImpl;
import com.model.Rectangle;
import com.model.ResultsOfCalculations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RectangleParametersController {

    @GetMapping("/Calculate")
    public ResultsOfCalculations getParameters(@RequestParam float length,
                                               @RequestParam float width) {
        return new InterfaceCalculatorImpl().calculate(new Rectangle(width, length));
    }

}


