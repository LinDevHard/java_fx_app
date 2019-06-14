package org.devteam;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.devteam.data.DataLoader;


public class MainApp extends Application {
    private static final String APP_NAME = "Trading Platform";

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("main_screen.fxml"));

        Scene scene = new Scene(root);
        DataLoader dt = new DataLoader();
        dt.getChartActually("AAPL");
        stage.setTitle(APP_NAME);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){
        launch();
    }

}

