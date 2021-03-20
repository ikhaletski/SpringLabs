package com.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultsOfCalculations {

    @JsonProperty
    final private float square;
    @JsonProperty
    final private float perimeter;

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
