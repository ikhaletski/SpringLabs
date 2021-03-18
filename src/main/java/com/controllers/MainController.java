package com.controllers;

import com.model.Calculator;
import com.model.Rectangle;
import com.model.ResultsOfCalculations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private Calculator calculator;
    private Rectangle rectangle;

    @GetMapping("/Calculate")
    public ResultsOfCalculations getParameters(@RequestParam(name = "length") float length,
                                               @RequestParam(name = "width") float width) {
        calculator = new Calculator();
        rectangle = new Rectangle(width, length);
        return calculator.calculate(rectangle);
    }

}


