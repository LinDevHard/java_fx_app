package org.devteam;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


class MainApp extends Application {

    public static void main(String[] args){
        launch();
    }

    @Override
    public void init() throws Exception {
        System.out.println("Init App");
        super.init();
    }


    @Override
    public void start(Stage stage) throws Exception {

        FlowPane rootNode = new FlowPane(Orientation.VERTICAL, 0, 20);

        Scene scene = new Scene(rootNode, 200, 200);

        Label label = new Label("First application");
        rootNode.getChildren().add(label);

        stage.setTitle("Firs application on JavaFx");
        stage.setScene(scene);
        stage.show();

    }
}
