package com.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultsOfCalculations {

    @JsonProperty
    private float square;
    @JsonProperty
    private float perimeter;

    public ResultsOfCalculations(float square, float perimeter) {
        this.square = square;
        this.perimeter = perimeter;
    }

    public float getSquare() {
        return square;
    }

    public float getPerimeter() {
        return perimeter;
    }
}
