package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class RoundRectang extends Shape {
    private Color color;
    private double length;
    private double width;
    private double x;
    private double y;

    public RoundRectang(Color col, double length, double width, double x, double y){
        super();
        this.color = col;
        this.length = length;
        this.width = width;
        this.x = x;
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    @Override
    public void draw(GraphicsContext gr){
        gr.setFill(color);
        gr.fillRoundRect(x, y, width, length, 15, 15);
        gr.strokeRoundRect(x, y, width, length, 15, 15);
    }
    public String nameFig(){
        return "Скругленный прямоугольник";
    }
}
