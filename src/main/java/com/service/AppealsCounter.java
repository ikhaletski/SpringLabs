package com.service;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Getter
@Service
public class AppealsCounter implements Runnable{

    private Logger logger = LoggerFactory.getLogger(AppealsCounter.class);
    private int appealsCounter;

    public AppealsCounter() {
        this.appealsCounter = 0;
    }

    synchronized public void addAppeal() {
        appealsCounter++;
        logger.info("Counter is: " + appealsCounter);
    }

    @Override
    public void run() {
        addAppeal();
    }
}
