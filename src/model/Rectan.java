package model;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectan extends Shape {
    private Color color = Color.AZURE;
    private double length;
    private double width;
    private double x;
    private double y;

    public Rectan(Color color, double length, double width, double x, double y){
        this.color = color;
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
        gr.fillRect(x, y, width, length);
        gr.strokeRect(x, y, width, length);
    }
    public String nameFig(){
        return "Прямоугольник";
    }
}
