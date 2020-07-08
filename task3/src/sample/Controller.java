package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.List;

public class Controller {

    private Queue<Double> firstQueue = new Queue<>();
    private Queue<Double> secondQueue = new Queue<>();

    @FXML
    private TextField addFirstField = new TextField();

    @FXML
    private TextField addSecondField = new TextField();

    @FXML
    private TextArea firstArea = new TextArea();

    @FXML
    private TextArea secondArea = new TextArea();

    @FXML
    private TextField resultField = new TextField();

    int solve(Queue<Double> first, Queue<Double> second){

        int count = 0;

        while(first.size() != 0 && second.size() != 0) {
            double x = first.pop();
            double y = second.pop();

            if (x < y) {
                double z = x + y;
                first.push(z);
            } else {
                double z = x - y;
                second.push(z);
            }
            count++;
        }
        return count;
    }

    private void updateFirstArea(){
        firstArea.clear();

        List<Double> list = firstQueue.toList();

        for(Double a : list){
            firstArea.appendText(Double.toString(a) + "\n");
        }
    }

    private void updateSecondArea(){
        secondArea.clear();

        List<Double> list = secondQueue.toList();

        for(Double a : list){
            secondArea.appendText(Double.toString(a) + "\n");
        }
    }

    @FXML
    private void addToFirstQueue(){
        String text = addFirstField.getText();
        Double d = Double.parseDouble(text);
        firstQueue.push(d);
        addFirstField.clear();
        updateFirstArea();
    }

    @FXML
    private void clearFirstQueue(){
        firstQueue.clear();
        updateFirstArea();
    }

    @FXML
    private void addToSecondQueue(){
        String text = addSecondField.getText();
        Double d = Double.parseDouble(text);
        secondQueue.push(d);
        addSecondField.clear();
        updateSecondArea();
    }

    @FXML
    private void clearSecondQueue(){
        secondQueue.clear();
        updateSecondArea();
    }

    @FXML
    private void run(){
        resultField.clear();
        resultField.appendText(String.valueOf(solve(firstQueue,secondQueue)));
    }
}
