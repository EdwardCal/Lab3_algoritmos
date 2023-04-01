package controller;

import domain.Dynamic;
import domain.Probabilistic;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

public class ProbabilisticController
{

    @javafx.fxml.FXML
    private TextField NumberNTF;
    @javafx.fxml.FXML
    private ChoiceBox choiceBox;

    Alert alert;
    @javafx.fxml.FXML
    private TextArea ResultTA;

    @javafx.fxml.FXML
    public void initialize() {
        alert= alert("Probabilistic Option", "There was an error");
        alert.setAlertType(Alert.AlertType.ERROR);
        choiceBox.getItems().add("Birthday Paradox");
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

    public void ClearButtonOnAction(ActionEvent actionEvent) {
        ResultTA.setText("");
        NumberNTF.setText("");
    }

    public void CalculateButtonOnAction(ActionEvent actionEvent) {
        Probabilistic probabilistic = new Probabilistic();
        String value = (String) choiceBox.getValue();
        int x=0;
        if(isValid() && value=="Birthday Paradox"){
            x=Integer.valueOf(this.NumberNTF.getText());
            ResultTA.setText("Birthday Paradox Probability for " + x + " persons is: \n\n" + util.Utility.format(probabilistic.birthdayProbability(x))+"%");
        }
    }
}