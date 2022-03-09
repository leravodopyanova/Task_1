package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.Ellips;
import model.Rectan;
import javafx.scene.paint.Color;
import model.*;

import java.io.Console;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public Canvas mainCanvas;
    public TextField widthTextField;
    public TextField heightTextField;
    public ColorPicker colorPicker;
    public ChoiceBox figureComboBox;
    public TextField borderWidth;
    public TextField textField;
    public ChoiceBox figureComboBox1;
    public CheckBox checkBoxDecor;
    ObservableList<String> listFig = FXCollections.observableArrayList("Прямоугольник", "Круг", "Эллипс", "Скругленный прямоугольник", "Квадрат");
    ObservableList<String> listFig2 = FXCollections.observableArrayList("Контур", "Текст");
    private Shape sh = new Rectan(Color.BLUE, 100, 200, 0,0);
    private ShapeDraw sh1 = new Conturee(sh, 1, Color.BLUE, 100, 200, 0,0);
    GraphicsContext gc;
    double length = 100;
    double width = 150;

    public void canvasMouseClick(MouseEvent mouseEvent) {
        String choice = figureComboBox.getValue().toString();
        String choice2 = figureComboBox1.getValue().toString();
        length = Double.parseDouble(heightTextField.getText());
        width = Double.parseDouble(widthTextField.getText());
        ShapeFactory shapeFactory = new ShapeFactory(colorPicker.getValue(), length, width, mouseEvent.getX(), mouseEvent.getY());
        Shape shape1 = shapeFactory.createShape(choice);

        if (checkBoxDecor.isSelected()){
            if(choice2.equals("Контур")){
                sh1 = new Conturee(shape1, Double.parseDouble(borderWidth.getText()), colorPicker.getValue(), length, width, mouseEvent.getX(), mouseEvent.getY());
                sh1.draw(gc);
            }
            else if(choice2.equals("Текст")){
                sh1 = new Textt(shape1, textField.getText(), colorPicker.getValue(), length, width, mouseEvent.getX(), mouseEvent.getY());
                sh1.draw(gc);
            }
            else {
                sh.draw(gc);
            }
        }
        else {
            shape1.draw(gc);
        }
    }

    public void wMouseClick(MouseEvent mouseEvent) {
        String choice = figureComboBox.getValue().toString();
        if(choice.equals("Круг") || choice.equals("Квадрат")) {
            widthTextField.setText(heightTextField.getText());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        figureComboBox.setItems(listFig);
        figureComboBox1.setItems(listFig2);
        figureComboBox1.setValue("Контур");
        gc = mainCanvas.getGraphicsContext2D();
        heightTextField.setText("10");
        widthTextField.setText("10");
        borderWidth.setText("1");
        textField.setText("Текст");
    }
}
