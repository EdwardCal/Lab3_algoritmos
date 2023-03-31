package controller;

import domain.Dynamic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class DynamicController
{
    @javafx.fxml.FXML
    private TextField ResultTF;
    @javafx.fxml.FXML
    private TextField NumberNTF;
    @javafx.fxml.FXML
    private ChoiceBox choiceBox;

    Alert alert;

    @javafx.fxml.FXML
    public void initialize() {
        alert= alert("Dynamic Option", "There was an error");
        alert.setAlertType(Alert.AlertType.ERROR);
        choiceBox.getItems().add("Factorial");
        choiceBox.getItems().add("Fibonacci");
    }
    private boolean isValid() {
        return !this.NumberNTF.getText().isEmpty();
    }
    private Alert alert(String title, String headerText){
        Alert a= new Alert(Alert.AlertType.INFORMATION);
        a.setTitle(title);
        a.setHeaderText(headerText);
        DialogPane dp= a.getDialogPane();
        return a;
    }

    public void CalculateButtonOnAction(ActionEvent event) {
        Dynamic dm = new Dynamic();
        String value = (String) choiceBox.getValue();
        int x=0;
        if(isValid() && value=="Fibonacci"){
            x=Integer.valueOf(this.NumberNTF.getText());
            ResultTF.setText(String.valueOf(dm.fibonacci(x)));
        } else if (isValid() && value=="Factorial") {
            x=Integer.valueOf(this.NumberNTF.getText());
            ResultTF.setText(String.valueOf(dm.factorial(x)));
        }


    }

    public void ClearButtonOnAction(ActionEvent actionEvent) {
        ResultTF.setText("");
        NumberNTF.setText("");
    }


}