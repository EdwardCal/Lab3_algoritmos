package controller;

import domain.DivideAndConquer;
import domain.Dynamic;
import domain.Vector;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class DivideAndConquerController
{
    @javafx.fxml.FXML
    private TextField NumberNTF;
    @javafx.fxml.FXML
    private TextArea ResultTA;
    @javafx.fxml.FXML
    private ChoiceBox choiceBox;
    Alert alert;
    Vector vector;
    @javafx.fxml.FXML
    public void initialize() {
        alert= alert("DivideAndConquer Option", "There was an error");
        alert.setAlertType(Alert.AlertType.ERROR);
        choiceBox.getItems().add("Iterative Binary Search");
        choiceBox.getItems().add("Recursive Binary Search");
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

    public void ShowButtonOnAction(ActionEvent actionEvent) {
        if(isValid()){
            vector = new Vector(Integer.valueOf(this.NumberNTF.getText()));
            util.Utility.fill(vector);
            vector.sort();
            ResultTA.setText(vector.toString()+"\n");
        } else{
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Please complete the info and try again...");
            alert.showAndWait();
        }
    }

    public void SearchButtonOnAction(ActionEvent actionEvent) {
        DivideAndConquer divideAndConquer = new DivideAndConquer();
        String value = (String) choiceBox.getValue();
        int x=0;

        if(isValid()){
            if(value=="Iterative Binary Search"){
                x=Integer.valueOf(this.NumberNTF.getText());
                for (int i = 0; i < 20; i++) {
                    String result="";
                    int valueBinary = util.Utility.random(99);
                    //java.util.Arrays
                    int indexArrays = java.util.Arrays.binarySearch(vector.getData(), valueBinary);
                    result += indexArrays >= 0
                            ? "java.util.Arrays BS...The element [" + valueBinary + "] exists at position " + indexArrays + "\n"

                            : "java.util.Arrays BS...The element [" + valueBinary + "] does not exist in vector\n"
                    ;
                    int indexArraysCollection = java.util.Collections.binarySearch(vector.getList(), valueBinary);
                    result += indexArraysCollection >= 0
                            ? "java.util.Collection BS...The element [" + valueBinary + "] exists at position " + indexArraysCollection + "\n"
                            : "java.util.Collection BS...The element [" + valueBinary + "] does not exist in vector\n";
                    int indexArraysDomain = domain.DivideAndConquer.binarySearch(vector.getData(), valueBinary);
                    result += indexArraysDomain >= 0
                            ? "ITERATIVE BS...The element [" + valueBinary + "] exists at position " + indexArraysDomain + "\n"
                            : "ITERATIVE BS...The element [" + valueBinary + "] does not exist in vector\n";
                    ResultTA.setText(ResultTA.getText()+"\n"+result+"\n");
                }
            } else if ( value=="Recursive Binary Search") {
                Vector vector = new Vector(Integer.parseInt(NumberNTF.getText()));
                x=Integer.valueOf(this.NumberNTF.getText());
                for (int i = 0; i < 20; i++) {
                    String result = "";
                    int valueBinary = util.Utility.random(99);
                    //java.util.Arrays
                    int indexArrays = java.util.Arrays.binarySearch(vector.getData(), valueBinary);
                    result += indexArrays >= 0
                            ? "java.util.Arrays BS...The element [" + valueBinary + "] exists at position " + indexArrays + "\n"

                            : "java.util.Arrays BS...The element [" + valueBinary + "] does not exist in vector\n"
                    ;
                    int indexArraysCollection = java.util.Collections.binarySearch(vector.getList(), valueBinary);
                    result += indexArraysCollection >= 0
                            ? "java.util.Collection BS...The element [" + valueBinary + "] exists at position " + indexArraysCollection + "\n"
                            : "java.util.Collection BS...The element [" + valueBinary + "] does not exist in vector\n";
                    int indexArraysDomainRecursive = domain.DivideAndConquer.binarySearch(vector.getData(), valueBinary,0,Integer.parseInt(NumberNTF.getText())-1);
                    result += indexArraysDomainRecursive >= 0
                            ?"RECURSIVE BS...The element ["+valueBinary+"] exists at position "+indexArraysDomainRecursive+ "\n"
                            :"RECURSIVE BS...The element ["+valueBinary+"] does not exist in vector\n";
                    ResultTA.setText(ResultTA.getText()+"\n"+result+"\n");
                }
            }

        }else{
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Please complete the info and try again...");
            alert.showAndWait();
        }
    }
}