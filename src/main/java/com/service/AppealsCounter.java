package com.service;

import lombok.Getter;
import org.springframework.stereotype.Service;

@Getter
@Service
public class AppealsCounter {

    private int appealsCounter;

    public AppealsCounter() {
        this.appealsCounter = 0;
    }

    synchronized public void addAppeal() {
        appealsCounter++;
    }

}
