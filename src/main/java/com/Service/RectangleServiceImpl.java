package com.Service;

import com.model.Rectangle;
import com.model.ResultsOfCalculations;
import org.springframework.stereotype.Service;

@Service
public class RectangleServiceImpl implements RectangleService {

    public ResultsOfCalculations calculate(Rectangle rectangle) {
        ResultsOfCalculations resultsOfCalculations = new ResultsOfCalculations(
                rectangle.getLength() * rectangle.getWidth(),
                (rectangle.getLength() + rectangle.getWidth()) * 2
        );
        return resultsOfCalculations;
    }
}
