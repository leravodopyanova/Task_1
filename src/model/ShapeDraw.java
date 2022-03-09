package model;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public interface ShapeDraw{
    public abstract void draw(GraphicsContext gr);
    public abstract String nameFig();
}
