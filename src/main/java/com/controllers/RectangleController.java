package com.controllers;

import com.model.RectangleCalculator;
import com.model.Rectangle;
import com.model.ResultsOfCalculations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RectangleController {

    private RectangleCalculator calculator;
    private Rectangle rectangle;

    @GetMapping("/Calculate")
    public ResultsOfCalculations getParameters(@RequestParam() float length,
                                               @RequestParam() float width) {
        calculator = new RectangleCalculator();
        rectangle = new Rectangle(width, length);
        return calculator.calculate(rectangle);
    }

}


