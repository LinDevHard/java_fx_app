package org.devteam.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Tab;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;


public class SkeletonController {
    private Stage mainStage;

    private FXMLLoader fxmlLoader = new FXMLLoader();
    private Parent fxmlDialog;
    private Stage aboutDialogStage;

    @FXML
    private MenuBar menubar;

    @FXML
    public Tab summary;

    @FXML
    private void initialize(){
        initLoader();
    }

    private void initLoader()  {
        try {

            fxmlLoader.setLocation(getClass().getResource("/fxml/about.fxml"));
            fxmlDialog = fxmlLoader.load();
            AboutController aboutController = fxmlLoader.getController();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }

    @FXML
    public void onActionExit(){
        Stage stage = (Stage) menubar.getScene().getWindow();
        stage.close();
    }



    @FXML
    public void onActionOpenAbout() throws IOException {
     if (aboutDialogStage == null){
         aboutDialogStage = new Stage();
         aboutDialogStage.setTitle("Trading Platform About");
         aboutDialogStage.setResizable(false);
         aboutDialogStage.setScene(new Scene(fxmlDialog));
         aboutDialogStage.initModality(Modality.WINDOW_MODAL);
         aboutDialogStage.initOwner(mainStage);
     }
     aboutDialogStage.showAndWait();
    }


}
