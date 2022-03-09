package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Conturee extends Decorator{
    private double borderWidth;
    ShapeDraw shapeDraw;
    private Color color;
    private double length;
    private double width;
    private double x;
    private double y;

    public Conturee(ShapeDraw shapeDraw, double borderWidth, Color color, double length, double width, double x, double y) {
        super(shapeDraw);
        this.shapeDraw = shapeDraw;
        this.borderWidth = borderWidth;
        this.color = color;
        this.length = length;
        this.width = width;
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(GraphicsContext gr){
        gr.setLineWidth(borderWidth);
        gr.setStroke(color);
        if(shapeDraw.nameFig().equals("Прямоугольник")){
            gr.strokeRect(x, y, width, length);
        }
        else if (shapeDraw.nameFig().equals("Скругленный прямоугольник")){
            gr.strokeRoundRect(x, y, width, length, 15, 15);
        }
        else if (shapeDraw.nameFig().equals("Эллипс")){
            gr.strokeOval(x, y, width, length);
        }
        else{
            return;
        }
    }

    @Override
    public String nameFig() {
        return "Контур";
    }
}
