package controller;

import domain.Vector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Optional;

public class VectorController
{
    @FXML
    private TextField maxSizeTextField;

    @FXML
    private TextArea textArea;

    Alert alert;

    Vector vector;


    @javafx.fxml.FXML
    public void initialize(){
        alert= alert("Vector Algorithm", "There was an error");
        alert.setAlertType(Alert.AlertType.ERROR);
    }

    private boolean isValid() {
        return !this.maxSizeTextField.getText().isEmpty();
    }

    private Alert alert(String title, String headerText){
        Alert a= new Alert(Alert.AlertType.INFORMATION);
        a.setTitle(title);
        a.setHeaderText(headerText);
        DialogPane dp= a.getDialogPane();
        return a;
    }


    public void clearOnAction(ActionEvent actionEvent) {
        textArea.setText("");
        maxSizeTextField.setText("");
    }

    public void fillShowOnAction(ActionEvent actionEvent) {
        if(isValid()){
            vector = new Vector(Integer.valueOf(this.maxSizeTextField.getText()));
            util.Utility.fill(vector);
            vector.sort();
            textArea.setText(vector.toString());
        } else{
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Please complete the info and try again...");
            alert.showAndWait();
        }
    }

    public void addValueOnAction(ActionEvent actionEvent) {
    }

    public void addIndexOnAction(ActionEvent actionEvent) {
    }

    public void sizeOnAction(ActionEvent actionEvent) {
    }

    public void removeValueOnAction(ActionEvent actionEvent) {
    }

    public void removeIndexOnAction(ActionEvent actionEvent) {
    }

    public void containsOnAction(ActionEvent actionEvent) {
        TextInputDialog dialog = new TextInputDialog("Vector - Contains: Enter the element to search");
        Optional<String> result = dialog.showAndWait();
        if((result.isPresent())&&(result.get().compareTo("")!=0)) {
            textArea.setText(textArea.getText()+"\n======Contains====== \n"+vector.contains(Integer.parseInt(result.get())));
        }
    }
}
