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
        vector.clear();
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
        TextInputDialog dialog = new TextInputDialog("Enter the element to add");
        Optional<String> result = dialog.showAndWait();
        if((result.isPresent())&&(result.get().compareTo("")!=0)) {
            vector.add(Integer.parseInt(result.get()));
            textArea.setText(textArea.getText()+vector.toString());
        }
    }

    public void addIndexOnAction(ActionEvent actionEvent) {
        TextInputDialog dialog = new TextInputDialog("Enter the index of the element to change and the element you want to add");
        Optional<String> result = dialog.showAndWait();
        String resultSplit[]= result.get().split(",");
        if((result.isPresent())&&(result.get().compareTo("")!=0)) {
            vector.add(Integer.parseInt(resultSplit[0]), Integer.parseInt(resultSplit[1]));
            textArea.setText(textArea.getText()+vector.toString());
        }
    }

    public void sizeOnAction(ActionEvent actionEvent) {
        textArea.setText(textArea.getText()+"\n======Size====== \n"+vector.size());
    }

    public void removeValueOnAction(ActionEvent actionEvent) {

        TextInputDialog dialog = new TextInputDialog("Enter the value to remove");
        Optional<String> result = dialog.showAndWait();
        if((result.isPresent())&&(result.get().compareTo("")!=0)) {
            ;
            textArea.setText(textArea.getText()+"\n=======Remove Value=======\n"+vector.remove(result.get())+vector.toString());
        }
    }

    public void removeIndexOnAction(ActionEvent actionEvent) {
        TextInputDialog dialog = new TextInputDialog("Enter the element to remove");
        Optional<String> result = dialog.showAndWait();
        if((result.isPresent())&&(result.get().compareTo("")!=0)) {
            ;
            textArea.setText(textArea.getText()+"\n======Remove Index=======\n"+vector.remove(Integer.parseInt(result.get()))+vector.toString());
        }
    }

    public void containsOnAction(ActionEvent actionEvent) {
        TextInputDialog dialog = new TextInputDialog("Vector - Contains: Enter the element to search");
        Optional<String> result = dialog.showAndWait();
        if((result.isPresent())&&(result.get().compareTo("")!=0)) {
            textArea.setText(textArea.getText()+"\n======Contains====== \n"+vector.contains(Integer.parseInt(result.get())));
        }
    }
}
