package com.controllers;

import com.Service.RectangleServiceImpl;
import com.model.Rectangle;
import com.model.ResultsOfCalculations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RectangleParametersController {

    private RectangleServiceImpl service;

    @Autowired
    public RectangleParametersController(RectangleServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/Calculate")
    public ResultsOfCalculations getParameters(@RequestParam float length,
                                               @RequestParam float width) {
        return service.calculate(new Rectangle(width, length));
    }

}


