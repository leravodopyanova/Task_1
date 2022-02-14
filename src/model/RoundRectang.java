package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class RoundRectang extends Shape{
    double length;
    double width;
    double x;
    double y;

    public RoundRectang(Color color, double length, double width, double x, double y) {
        // calling Shape constructor
        super(color);
        this.length = length;
        this.width = width;
        this.x = x;
        this.y = y;
    }

    public RoundRectang(Color color) {
        super(color);
    }

    @Override
    double area() {
        return Math.PI * 15 * 15 +(length - 2 * 15) * (width - 2 * 15) + 2 * 15 * (length - 2 * 15) + 2 * 15 * (width - 2 * 15);
    }

    @Override
    public String toString() {
        return "Цвет скругленного прямоугольника - " + super.color +  " и его площадь : " + area();
    }

    @Override
    public void draw(GraphicsContext gr){
        gr.setFill(color);
        gr.fillRoundRect(x, y, width, length, 15, 15);
        gr.strokeRoundRect(x, y, width, length, 15, 15);
    }
}
