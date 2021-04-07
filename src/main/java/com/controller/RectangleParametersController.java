package com.controller;

import com.domain.Cash;
import com.service.AppealsCounter;
import com.service.RectangleService;
import com.domain.Rectangle;
import com.domain.ResultsOfCalculations;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class RectangleParametersController {

    private final RectangleService service;
    private final Logger logger = LoggerFactory.getLogger(RectangleParametersController.class);

    @GetMapping("/Calculate")
    public ResultsOfCalculations getParameters(@RequestParam @Min(0) float length,
                                               @RequestParam @Min(0) float width) throws ConstraintViolationException {
        Rectangle rectangle = new Rectangle(width, length);
        return service.calculate(rectangle);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {

        logger.warn(e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}