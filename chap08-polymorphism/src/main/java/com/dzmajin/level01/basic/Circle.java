package com.dzmajin.level01.basic;

public class Circle extends Shape {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    double calculatePerimeter() {
        return Math.PI*radius * 2;
    }
    @Override
    public String toString() {
        return "Shape : Circle\n Area = " + calculateArea() + "\n Perimeter = " + calculatePerimeter();
    }
}
