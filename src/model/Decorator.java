package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Decorator implements ShapeDraw {
    private Color color;
    private double length;
    private double width;
    private double x;
    private double y;

    public Decorator(){
    }
    private ShapeDraw shapeDraw;
    public Decorator(ShapeDraw shapeDraw){
        this.shapeDraw = shapeDraw;
    }
    @Override
    public void draw(GraphicsContext gr){
        this.draw(gr);
    }
}
