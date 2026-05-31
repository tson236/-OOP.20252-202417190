module hw14 {

    requires javafx.controls;
    requires javafx.fxml;

    exports hust.soict.dsai.application;

    opens hust.soict.dsai.controller to javafx.fxml;
}