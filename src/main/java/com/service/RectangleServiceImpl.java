package com.service;

import com.domain.Cash;
import com.domain.Rectangle;
import com.domain.ResultsOfCalculations;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@AllArgsConstructor
public class RectangleServiceImpl implements RectangleService {

    private final Logger logger = LoggerFactory.getLogger(RectangleServiceImpl.class);
    private final Cash cash;
    private final AppealsCounter appealsCounter;
    private final ExecutorService executorService = Executors.newCachedThreadPool();

    public ResultsOfCalculations calculate(Rectangle rectangle) {
        executorService.submit(appealsCounter);
        if (cash.isExist(rectangle)) {
            logger.info("Appeals to cash");
            return cash.getResultOfCalculations(rectangle);
        }
        ResultsOfCalculations resultsOfCalculations = new ResultsOfCalculations(
                rectangle.getLength() * rectangle.getWidth(),
                (rectangle.getLength() + rectangle.getWidth()) * 2
        );
        cash.addRectangleToCash(rectangle, resultsOfCalculations);
        logger.info("Successfully calculated rectangle square and perimeter");
        return resultsOfCalculations;
    }
}
