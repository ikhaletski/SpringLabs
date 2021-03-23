package com.controller;

import com.service.RectangleServiceImpl;
import com.model.Rectangle;
import com.model.ResultsOfCalculations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Min;

@Validated
@RestController
public class RectangleParametersController {

    private final RectangleServiceImpl service;
    private final Logger logger = LoggerFactory.getLogger(RectangleParametersController.class);

    @Autowired
    public RectangleParametersController(RectangleServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/Calculate")
    public ResultsOfCalculations getParameters(@RequestParam @Min(0) float length,
                                               @RequestParam @Min(0) float width) throws ConstraintViolationException

    {

        return service.calculate(new Rectangle(width, length));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {

        logger.warn(e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}