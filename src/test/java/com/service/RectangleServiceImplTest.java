package com.service;

import com.model.Rectangle;
import com.model.ResultsOfCalculations;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleServiceImplTest {

    private RectangleServiceImpl rectangleService = new RectangleServiceImpl();

    @Test
    void calculate() {
        Rectangle rectangle = new Rectangle(12, 12);
        ResultsOfCalculations resultsOfCalculations = new ResultsOfCalculations(144, 48);
        Assert.assertEquals(resultsOfCalculations, rectangleService.calculate(rectangle));
    }
}