package model;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape  {
    double x;
    double y;
    //параметры фигуры - приватные поля
    Color color;

    // объявление абстрактных методов
    abstract double area();
    public abstract String toString();
    public abstract void draw(GraphicsContext gr);

    // конструктор
    public Shape(Color color) {
        System.out.println("Shape constructor called");
        this.color = color;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    // реализация методов
    public void setColor(Color color) {
        this.color=color;
    }

}
