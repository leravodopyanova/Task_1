package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape implements ShapeDraw {
    private Color color;
    private double length;
    private double width;
    private double x;
    private double y;

    public Shape(){
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public abstract void draw(GraphicsContext gr);
    @Override
    public abstract String nameFig();
}
