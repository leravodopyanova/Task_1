package model;

import javafx.scene.paint.Color;

public class ShapeFactory {
    private Color color;
    private double length;
    private double width;
    private double x;
    private double y;

    public ShapeFactory(Color color, double length, double width, double x, double y){
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

    public Shape createShape(String choice){
        if(choice.equals("Прямоугольник")){
            return new Rectan(color, length, width, x, y);
        }
        else if(choice.equals("Эллипс")){
            return new Ellips(color, length, width, x, y);
        }
        else if(choice.equals("Скругленный прямоугольник")){
            return new RoundRectang(color, length, width, x, y);
        }
        else if(choice.equals("Круг")){
            return new Ellips(color, length, length, x, y);
        }
        else if(choice.equals("Квадрат")){
            return new Rectan(color, length, length, x, y);
        }
        else {
            return null;
        }
    }
}
