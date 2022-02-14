package model;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Ellips extends Shape {
    double length;
    double width;
    double x;
    double y;

    public Ellips(Color color, double length, double width, double x, double y) {
        // calling Shape constructor
        super(color);
        this.length = length;
        this.width = width;
        this.x = x;
        this.y = y;
    }

    @Override
    double area() {
        return Math.PI * length * width;
    }

    @Override
    public String toString() {
        return "Цвет эллипса - " + super.color +  " и его площадь : " + area();
    }

    @Override
    public void draw(GraphicsContext gr){
        gr.setFill(color);
        gr.fillOval(x, y, width, length);
        gr.strokeOval(x, y, width, length);
    }
}

