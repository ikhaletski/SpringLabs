package com.domain;

import java.util.Objects;

public class Rectangle {

    private float width;
    private float length;

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

    public void setWidth(float width) { this.width = width; }

    public void setLength(float length) { this.length = length; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Float.compare(rectangle.width, width) == 0 && Float.compare(rectangle.length, length) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, length);
    }
}
