package model;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectan extends Shape {
    double length;
    double width;
    double x;
    double y;

    public Rectan(Color color, double length, double width, double x, double y) {
        // calling Shape constructor
        super(color);
        this.length = length;
        this.width = width;
        this.x = x;
        this.y = y;
    }

    @Override
    double area() {
        return length*width;
    }

    @Override
    public String toString() {
        return "Цвет прямоугольника - " + super.color +  " и его площадь : " + area();
    }

    @Override
    public void draw(GraphicsContext gr){
        gr.setFill(color);
        gr.fillRect(x, y, width, length);
        gr.strokeRect(x, y, width, length);
    }
}
