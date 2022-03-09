package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Textt extends Decorator{
    String txt;
    private Color color;
    private double length;
    private double width;
    private double x;
    private double y;

    public Textt(Color col, double length, double width, double x, double y){
        super();
        color = col;
        this.length = length;
        this.width = width;
        this.x = x;
        this.y = y;
    }

    public Textt(ShapeDraw shapeDraw, String txt, Color color, double length, double width, double x, double y) {
        super(shapeDraw);
        this.txt = txt;
        this.color = color;
        this.length = length;
        this.width = width;
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(GraphicsContext gr){
        gr.setStroke(color);
        gr.strokeText(txt, x, y, width);
    }

    @Override
    public String nameFig() {
        return "Текст";
    }
}

// сохранение в собственом формате