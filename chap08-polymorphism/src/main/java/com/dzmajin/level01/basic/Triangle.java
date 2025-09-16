package com.dzmajin.level01.basic;

public class Triangle extends Shape {
    double base;
    double height;
    double side1;
    double side2;
    double side3;

    public Triangle(double base, double height, double side1, double side2, double side3) {
        this.base = base; //밑변
        this.height = height;
        this.side1 = side1; //첫번째 변
        this.side2 = side2; //두번째 변
        this.side3 = side3; //세번째 변
    }
    @Override
    double calculateArea() {
        return (base * height)/2 ;
    }

    @Override
    double calculatePerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public String toString() {
        return "Shape : Triangle\n Area = " + calculateArea() + "\n Perimeter = " + calculatePerimeter();
    }
}
