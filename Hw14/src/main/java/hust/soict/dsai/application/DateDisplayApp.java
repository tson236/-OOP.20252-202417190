package hust.soict.dsai.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DateDisplayApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader =
                new FXMLLoader(
                        getClass().getResource(
                                "/hust/soict/dsai/view/MainView.fxml"));

        Scene scene =
                new Scene(loader.load(), 400, 550);

        stage.setTitle("Date Display GUI");

        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}