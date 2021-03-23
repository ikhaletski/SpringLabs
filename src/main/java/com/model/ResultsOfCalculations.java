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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultsOfCalculations that = (ResultsOfCalculations) o;
        return Float.compare(that.square, square) == 0 && Float.compare(that.perimeter, perimeter) == 0;
    }

    public float getSquare() {
        return square;
    }

    public float getPerimeter() {
        return perimeter;
    }
}
