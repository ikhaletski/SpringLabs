package com.domain;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Cash {

    private final Map<Rectangle, ResultsOfCalculations> cash = new HashMap<>();

    public ResultsOfCalculations addRectangleToCash(Rectangle rectangle, ResultsOfCalculations resultsOfCalculations) {
        return cash.put(rectangle, resultsOfCalculations);
    }

    public ResultsOfCalculations getResultOfCalculations(Rectangle rectangle) {
        return cash.get(rectangle);
    }

    public boolean isExist(Rectangle rectangle) {
        return cash.containsKey(rectangle);
    }


}
