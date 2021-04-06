package com.controller;

import com.domain.Cash;
import com.service.AppealsCounter;
import com.service.RectangleService;
import com.domain.Rectangle;
import com.domain.ResultsOfCalculations;
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

    private final RectangleService service;
    private final Logger logger = LoggerFactory.getLogger(RectangleParametersController.class);
    private final Cash cash;
    private final AppealsCounter appealsCounter;

    @Autowired
    public RectangleParametersController(RectangleService service, Cash cash, AppealsCounter appealsCounter) {
        this.service = service;
        this.cash = cash;
        this.appealsCounter = appealsCounter;
    }

    @GetMapping("/Calculate")
    public ResultsOfCalculations getParameters(@RequestParam @Min(0) float length,
                                               @RequestParam @Min(0) float width) throws ConstraintViolationException {
        appealsCounter.addAppeal();
        logger.info("Current appeals count: " + appealsCounter.getAppealsCounter());
        Rectangle rectangle = new Rectangle(width, length);
        if (cash.isExist(rectangle)) {
            logger.info("Appeals to cash");
            return cash.getResultOfCalculations(rectangle);
        }
        ResultsOfCalculations resultsOfCalculations = service.calculate(rectangle);
        cash.addRectangleToCash(rectangle, resultsOfCalculations);
        return resultsOfCalculations;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {

        logger.warn(e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}