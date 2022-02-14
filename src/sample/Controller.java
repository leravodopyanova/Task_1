package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.Ellips;
import model.Rectan;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.control.ChoiceBox;
import model.*;

public class Controller {
    public Canvas mainCanvas;
    public Button rectBtn;
    public Button ellipsBtn;
    public Button roundrecBtn;
    public TextField widthTextField;
    public TextField heightTextField;
    public ColorPicker colorPicker;
    public TextField xField;
    public TextField yField;
    public Button polligBtn;
    public ChoiceBox figureComboBox;
    ObservableList<String> listFig = FXCollections.observableArrayList("Прямоугольник", "Круг", "Эллипс", "Скругленный прямоугольник", "Квадрат", "Сложная фигура");
    private Shape sh = new Rectan(Color.BLUE, 100.0, 200.0, 100.0, 50.0);

    @FXML
    private void initialize(){
        figureComboBox.setItems(listFig);
    }
    public void rectOnAction(ActionEvent actionEvent) {
        Rectan rect = new Rectan(colorPicker.getValue(), 0, 0, 0, 0);
        sh = rect;

        //GraphicsContext gr = mainCanvas.getGraphicsContext2D();
        //rect.draw(gr);
    }

    public void ellipsOnAction(ActionEvent actionEvent) {
        double length = Double.parseDouble(heightTextField.getText());
        double width = Double.parseDouble(widthTextField.getText());
        Ellips el = new Ellips(colorPicker.getValue(), length, width, 100, 200);
        GraphicsContext gr = mainCanvas.getGraphicsContext2D();
        el.draw(gr);
    }

    public void roundrecOnAction(ActionEvent actionEvent) {
    }

    public void heightOnAction(ActionEvent actionEvent) {
    }

    public void widthOnAction(ActionEvent actionEvent) {
    }

    public void colorOnAction(ActionEvent actionEvent) {
    }

    public void polligOnAction(ActionEvent actionEvent) {
        double x1 = Double.parseDouble(xField.getText());
        double y1 = Double.parseDouble(yField.getText());
        GraphicsContext gc = mainCanvas.getGraphicsContext2D();
        gc.beginPath();
        gc.setFill(colorPicker.getValue());
        // Make different Paths
        gc.moveTo(50, 50);
        gc.quadraticCurveTo(90, 90, x1, y1);
        gc.fill();
        gc.closePath();
    }

    public void canvasMouseClick(MouseEvent mouseEvent) {
        String choice = figureComboBox.getValue().toString();
        double length = Double.parseDouble(heightTextField.getText());
        double width = Double.parseDouble(widthTextField.getText());

        switch (choice){
            case "Прямоугольник":
                sh = new Rectan(colorPicker.getValue(), length, width, mouseEvent.getX(), mouseEvent.getY());
                break;
            case "Эллипс":
                sh = new Ellips(colorPicker.getValue(), length, width, mouseEvent.getX(), mouseEvent.getY());
                break;
            case "Скругленный прямоугольник":
                sh = new RoundRectang(colorPicker.getValue(), length, width, mouseEvent.getX(), mouseEvent.getY());
                break;
            case "Круг":
                widthTextField.isDisabled();
                sh = new Ellips(colorPicker.getValue(), length, length, mouseEvent.getX(), mouseEvent.getY());
                widthTextField.isEditable();
                break;
            case "Квадрат":
                widthTextField.isDisabled();
                sh = new Rectan(colorPicker.getValue(), length, length, mouseEvent.getX(), mouseEvent.getY());
                widthTextField.isEditable();
                break;
            case "Сложная фигура":
                GraphicsContext gc = mainCanvas.getGraphicsContext2D();
                gc.beginPath();
                gc.setFill(colorPicker.getValue());
                // Make different Paths
                gc.moveTo(mouseEvent.getX(), mouseEvent.getY());
                gc.quadraticCurveTo(90, 90, mouseEvent.getX() + 100, mouseEvent.getY() + 100);
                gc.fill();
                gc.closePath();
                break;
            default:
                sh = new Rectan(colorPicker.getValue(), length, width, mouseEvent.getX(), mouseEvent.getY());
        }
        GraphicsContext gc = mainCanvas.getGraphicsContext2D();
        sh.draw(gc);
    }
}
