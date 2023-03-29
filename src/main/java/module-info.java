module ucr.lab3 {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens ucr.lab3 to javafx.fxml;
    exports ucr.lab3;
}