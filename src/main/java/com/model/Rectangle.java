package com.model;

import javax.validation.constraints.Min;

public class Rectangle {

    final private float width;
    final private float length;

    public Rectangle(float width, float length) {
        this.width = width;
        this.length = length;
    }

    public float getWidth() {
        return width;
    }

    public float getLength() {
        return length;
    }
}
