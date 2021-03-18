package com.model;

public class Calculator {

    public ResultsOfCalculations calculate(Rectangle rectangle) {
        ResultsOfCalculations resultsOfCalculations = new ResultsOfCalculations(
                rectangle.getLength() * rectangle.getWidth(),
                (rectangle.getLength() + rectangle.getWidth()) * 2
        );
        return resultsOfCalculations;
    }
}
