package com.dzmajin.level01.basic;

import java.awt.geom.Area;

public class Rectangle extends Shape {
    double width;
    double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    double calculateArea() {
        return width * height;
    }

    @Override
    double calculatePerimeter() {
        return 2*(width + height);
    }

    @Override
    public String toString() {
        return "Shape : Rectangle\n Area = " + calculateArea() + "\n Perimeter = " + calculatePerimeter();
    }
}
