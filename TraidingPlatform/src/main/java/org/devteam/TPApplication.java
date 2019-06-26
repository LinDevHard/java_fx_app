package org.devteam;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.devteam.view.SkeletonController;

public class TPApplication extends Application {
    private static final String APP_NAME = "Trading Platform";

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/fxml/skeleton.fxml"));
        Parent root = fxmlLoader.load();
        SkeletonController skeletonController = fxmlLoader.getController();
        skeletonController.setMainStage(stage);

        Scene scene = new Scene(root);
        stage.setTitle(APP_NAME);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){
        launch();
    }

}

