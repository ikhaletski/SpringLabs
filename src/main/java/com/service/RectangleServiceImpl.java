package com.service;

import com.model.Rectangle;
import com.model.ResultsOfCalculations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RectangleServiceImpl implements RectangleService {

    private final Logger logger = LoggerFactory.getLogger(RectangleServiceImpl.class);

    public ResultsOfCalculations calculate(Rectangle rectangle) {
        ResultsOfCalculations resultsOfCalculations = new ResultsOfCalculations(
                rectangle.getLength() * rectangle.getWidth(),
                (rectangle.getLength() + rectangle.getWidth()) * 2
        );
        logger.info("Successfully calculated rectangle square and perimeter");
        return resultsOfCalculations;
    }
}
